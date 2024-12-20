package com.example.isa.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.isa.exception.ResourceConflictException;
import com.example.isa.model.RegularUser;
import com.example.isa.model.User;
import com.example.isa.model.dto.JwtAuthenticationRequest;
import com.example.isa.model.dto.UserRequest;
import com.example.isa.model.dto.UserTokenState;
import com.example.isa.service.EmailService;
import com.example.isa.service.RegularUserService;
import com.example.isa.service.UserService;
import com.example.isa.util.TokenUtils;



//Kontroler zaduzen za autentifikaciju korisnika
@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;
	@Autowired
	private RegularUserService regularUserService;

	@Autowired
	private EmailService emailService;


	
	// Prvi endpoint koji pogadja korisnik kada se loguje.
	// Tada zna samo svoje korisnicko ime i lozinku i to prosledjuje na backend.
	@PostMapping("/login")
	public ResponseEntity<UserTokenState> createAuthenticationToken(
			@RequestBody JwtAuthenticationRequest authenticationRequest, HttpServletResponse response) {
		// Ukoliko kredencijali nisu ispravni, logovanje nece biti uspesno, desice se
		// AuthenticationException
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		// Ukoliko je autentifikacija uspesna, ubaci korisnika u trenutni security
		// kontekst
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Kreiraj token za tog korisnika
		User user = (User) authentication.getPrincipal();
		String jwt = tokenUtils.generateToken(user.getUsername(), user.getId());
		//napraviti drugi service koji generise token , ne radi se u konctoleru
		int expiresIn = tokenUtils.getExpiredIn();

		// Vrati token kao odgovor na uspesnu autentifikaciju
		return ResponseEntity.ok(new UserTokenState(jwt, expiresIn));
	}

	// Endpoint za registraciju novog korisnika
	@PostMapping("/signup")
	public ResponseEntity<User> addUser(@RequestBody UserRequest userRequest, UriComponentsBuilder ucBuilder) {
		User existUser = this.userService.findByUsername(userRequest.getUsername());

		if (existUser != null) {
			throw new ResourceConflictException(userRequest.getId(), "Username already exists");
		}

		User user = this.userService.save(userRequest);

		

		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	@PostMapping("/regularUser/signup")
	public ResponseEntity<User> addRegularUser(@RequestBody UserRequest userRequest, UriComponentsBuilder ucBuilder) throws Exception {
		User existUser = this.userService.findByUsername(userRequest.getUsername());
		User userEmail = this.userService.findByEmail(userRequest.getEmail());

		if(userEmail != null){
			throw new Exception("User with this email already exists");
		}

		if (existUser != null) {
			throw new ResourceConflictException(userRequest.getId(), "Username already exists");
		}

		User user = this.userService.saveRegularUser(userRequest);
		RegularUser regularUser = this.regularUserService.createNewRegularUser(user);
		this.emailService.sendEmailRegistration(user.getEmail());
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
}

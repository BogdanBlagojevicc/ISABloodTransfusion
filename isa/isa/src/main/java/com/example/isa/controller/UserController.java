package com.example.isa.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.model.User;
import com.example.isa.service.UserService;

@CrossOrigin
@RestController
@RequestMapping(value = "api/baseuser")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }  

    @GetMapping("/whoami")
	@PreAuthorize("hasRole('ROLE_REGULAR_USER')")
	public User user(Principal user) {
		return this.userService.findByUsername(user.getName());
	}
}

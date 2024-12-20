package com.example.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.isa.model.Role;
import com.example.isa.model.User;
import com.example.isa.model.dto.Gender;
import com.example.isa.model.dto.UserDTO;
import com.example.isa.model.dto.UserRequest;
import com.example.isa.repository.CenterAdministratorRepository;
import com.example.isa.repository.RegularUserRepository;
import com.example.isa.repository.TermRepository;
import com.example.isa.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final TermRepository termRepository;
    private final RegularUserRepository regularUserRepository;
    private final CenterAdministratorRepository centerAdministratorRepository;

    // @Autowired
    // public UserService(UserRepository userRepository){
    //     this.userRepository = userRepository;
    // }

    @Autowired
    public UserService(UserRepository userRepository, TermRepository termRepository, RegularUserRepository regularUserRepository, CenterAdministratorRepository centerAdministratorRepository){
        this.userRepository = userRepository;
        this.termRepository = termRepository;
        this.regularUserRepository = regularUserRepository;
        this.centerAdministratorRepository = centerAdministratorRepository;
    }

    @Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleService roleService;


    public User create(User user) throws Exception{
        if(user.getId() != null){
            throw new Exception("ID must be null");
        }
        return this.userRepository.save(user);
    }

    public User findOne(Long id) throws Exception{
        User user = this.userRepository.getById(id);

        if(user == null){
            throw new Exception("User does not exist");
        }

        return user;
    }

    public User findByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}

    public User findByEmail(String email) throws Exception{
        return userRepository.findByEmail(email);
    }

	public User save(UserRequest userRequest) {
		User u = new User();
		u.setUsername(userRequest.getUsername());
		
		// pre nego sto postavimo lozinku u atribut hesiramo je kako bi se u bazi nalazila hesirana lozinka
		// treba voditi racuna da se koristi isi password encoder bean koji je postavljen u AUthenticationManager-u kako bi koristili isti algoritam
		u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		
		u.setFirstName(userRequest.getFirstname());
		u.setLastName(userRequest.getLastname());
		u.setEnabled(true);
        u.setAddress(userRequest.getAddress());
        u.setCity(userRequest.getCity());
        u.setCountry(userRequest.getCountry());
        u.setPhoneNumber(userRequest.getPhoneNumber());
        u.setJmbg(userRequest.getJmbg());
        u.setGender(Gender.valueOf(userRequest.getGender()));
        u.setProfession(userRequest.getProfession());
        u.setEducation(userRequest.getEducation());

		//u.setEmail(userRequest.getEmail()); ****************** MOZDA BUDE TREBALO DA SE MENJA ************************ CONE

		// u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
		List<Role> roles = roleService.findByName("ROLE_CENTER_ADMINISTRATOR");
		u.setRoles(roles);
		
		return this.userRepository.save(u);
	}

    public User saveRegularUser(UserRequest userRequest) {
		User u = new User();
		u.setUsername(userRequest.getUsername());
		
		// pre nego sto postavimo lozinku u atribut hesiramo je kako bi se u bazi nalazila hesirana lozinka
		// treba voditi racuna da se koristi isi password encoder bean koji je postavljen u AUthenticationManager-u kako bi koristili isti algoritam
		u.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		
		u.setFirstName(userRequest.getFirstname());
		u.setLastName(userRequest.getLastname());
		u.setEnabled(true);
		u.setAddress(userRequest.getAddress());
        u.setCity(userRequest.getCity());
        u.setCountry(userRequest.getCountry());
        u.setPhoneNumber(userRequest.getPhoneNumber());
        u.setJmbg(userRequest.getJmbg());
        u.setGender(Gender.valueOf(userRequest.getGender()));
        u.setProfession(userRequest.getProfession());
        u.setEducation(userRequest.getEducation());
		u.setEmail(userRequest.getEmail()); 

		// u primeru se registruju samo obicni korisnici i u skladu sa tim im se i dodeljuje samo rola USER
		List<Role> roles = roleService.findByName("ROLE_REGULAR_USER");
		u.setRoles(roles);
		
		return this.userRepository.save(u);
	}

    public List<User> donatedUsers(){
        Long centarCASId = (long) 1;
        List<Long> termIds = centerAdministratorRepository.findAllTermIdByCenterCASId(centarCASId); 
        return null;
    }

}

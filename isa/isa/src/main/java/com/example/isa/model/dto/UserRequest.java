package com.example.isa.model.dto;

import lombok.Getter;
import lombok.Setter;

// DTO koji preuzima podatke iz HTML forme za registraciju
@Getter
@Setter
public class UserRequest {

	private Long id;

	private String username;

	private String password;

	private String firstname;

	private String lastname;
	
	private String email;

}
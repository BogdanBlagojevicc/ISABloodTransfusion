package com.example.isa;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.isa.service.EmailService;

@SpringBootApplication
public class IsaApplication {

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(IsaApplication.class, args);
	}

	// @EventListener(ApplicationReadyEvent.class)
	// public void sendEmail(){
	// 	emailService.sendEmail("joldicnenad13@gmail.com");
	// }

}

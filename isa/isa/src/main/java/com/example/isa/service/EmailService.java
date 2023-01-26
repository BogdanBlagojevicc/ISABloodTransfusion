package com.example.isa.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

   
    public void sendEmail(String toEmail) {
        
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("joldicnenad13@gmail.com");
            message.setTo(toEmail);
            message.setText("neki tekst random");
            message.setSubject("provera za registraciju");

           // javaMailSender.send(message);

            System.out.println("Mail send successfully...");
    }

    public void sendEmailRegistration(String toEmail) {
        
        try {
        MimeMessage msg = javaMailSender.createMimeMessage();
        msg.setSubject("ISA blood transfusion");
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(toEmail);
        helper.setFrom("wotnenad@gmail.com");
        helper.setSubject("Potvrda o registraciji");
        String message = "Uspesno ste zakazali registraciju "; 
                
        helper.setText(message, true);
        javaMailSender.send(msg);
    } catch (MessagingException ex) {
        System.out.println("Error while sending email");
    }
}
    
}

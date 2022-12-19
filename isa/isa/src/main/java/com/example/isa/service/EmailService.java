package com.example.isa.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
@Service
public class EmailService {
    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

   
    public void sendEmail(String toEmail) {
        
            try {
            MimeMessage msg = javaMailSender.createMimeMessage();
            msg.setSubject("ISA ");
            MimeMessageHelper helper = new MimeMessageHelper(msg, true);
            helper.setTo(toEmail);
            helper.setFrom("isamrs");
            helper.setSubject("Potvrda o terminu");
            String message = "Uspesno ste zakazali termin "; 
                    
            helper.setText(message, true);
            javaMailSender.send(msg);
        } catch (MessagingException ex) {
            System.out.println("Error while sending email");
        }
    }

    public void sendEmailRegistration(String toEmail) {
        
        try {
        MimeMessage msg = javaMailSender.createMimeMessage();
        msg.setSubject("ISA ");
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo(toEmail);
        helper.setFrom("isamrs");
        helper.setSubject("Potvrda o registraciji");
        String message = "Uspesno ste zakazali registraciju "; 
                
        helper.setText(message, true);
        javaMailSender.send(msg);
    } catch (MessagingException ex) {
        System.out.println("Error while sending email");
    }
}
    
}

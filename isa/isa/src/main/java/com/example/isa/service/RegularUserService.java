package com.example.isa.service;

import java.io.Console;
import java.util.List;
import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import com.example.isa.model.RegularUser;
import com.example.isa.model.User;
import com.example.isa.model.dto.Gender;
import com.example.isa.model.dto.RegularUserDTO;
import com.example.isa.repository.RegularUserRepository;
import com.example.isa.repository.UserRepository;
import com.example.isa.model.dto.LoyaltyProgram;



@Service
public class RegularUserService {

    private final RegularUserRepository regularUserRepository;
    private final UserRepository userRepository;

    @Autowired
    public RegularUserService(RegularUserRepository regularUserRepository, UserRepository userRepository){
        this.regularUserRepository = regularUserRepository;
        this.userRepository = userRepository;
    }

    
    public RegularUser create(RegularUser regularUser) throws Exception{
        if(regularUser.getBaseUserRU().getId() != null){
            throw new Exception("ID must be null");
        }
        RegularUser newRegularUser = this.regularUserRepository.save(regularUser);
        return newRegularUser;
    }

    public RegularUser createNewRegularUser(User user){

        RegularUser regularUser = new RegularUser(LoyaltyProgram.REGULAR, 0, 0, user);
       
        RegularUser newRegularUser = this.regularUserRepository.save(regularUser);
        return newRegularUser;
    }

    public RegularUser findOne(Long id) throws Exception{
        RegularUser regularUser = this.regularUserRepository.findByBaseUserRUId(id);
        if(regularUser == null){
            throw new Exception("User does not exist");
        }
        return regularUser;
    }

    public RegularUser update(Long id, RegularUserDTO regularUserDTO) throws Exception{

        if(this.regularUserRepository.findByBaseUserRUId(id) == null){
            throw new Exception("User does not exist");
        }

        User updatedUser = new User(
            id,
            regularUserDTO.getUsername(),
            regularUserDTO.getPassword(),
            regularUserDTO.getFirstName(),
            regularUserDTO.getLastName(),
            regularUserDTO.getAddress(),
            regularUserDTO.getCity(),
            regularUserDTO.getCountry(),
            regularUserDTO.getPhoneNumber(),
            regularUserDTO.getJmbg(),
            Gender.valueOf(regularUserDTO.getGender()),
            regularUserDTO.getProfession(),
            regularUserDTO.getEducation()
        );


        this.userRepository.save(updatedUser);

        RegularUser updatedRegularUser = new RegularUser(
            LoyaltyProgram.valueOf(regularUserDTO.getLoyalty()),
            regularUserDTO.getPoints(),
            regularUserDTO.getPenalties(),
            updatedUser
        );

        this.regularUserRepository.save(updatedRegularUser);

        return updatedRegularUser;
    }
    
    public List<RegularUser> findAll(){
        return regularUserRepository.findAll();
    }

   
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.mailtrap.io");
        mailSender.setPort(2525);

        mailSender.setUsername("f41777af419e05");
        mailSender.setPassword("002d47d6f84aaf");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.debug", "true");
        props.put("management.health.mail.enabled", "false");
        return mailSender;
    }


    // public List<RegularUser> findByFirstNameAndLastName(String firstName, String lastName){
    //     return this.regularUserRepository.findByFirstNameAndLastName(firstName, lastName);
    // }

    public RegularUser updatePenalty(Long id) throws Exception{
        RegularUser regularUser = regularUserRepository.getById(id);
        regularUser.setPenalties(regularUser.getPenalties()+1);
        regularUserRepository.save(regularUser);
        return regularUser;
    }

    // public List<RegularUser> findByOrderByFirstNameAsc(){
    //     return this.regularUserRepository.findByOrderByFirstNameAsc();
    // }

}
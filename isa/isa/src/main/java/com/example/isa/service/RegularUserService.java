package com.example.isa.service;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    // public List<RegularUser> findByFirstNameAndLastName(String firstName, String lastName){
    //     return this.regularUserRepository.findByFirstNameAndLastName(firstName, lastName);
    // }

}
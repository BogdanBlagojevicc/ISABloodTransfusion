package com.example.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.model.User;
import com.example.isa.model.dto.UserDTO;
import com.example.isa.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

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

}

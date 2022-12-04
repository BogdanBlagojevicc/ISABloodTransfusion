package com.example.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.model.Role;
import com.example.isa.repository.RoleRepository;


@Service
public class RoleService  {

  @Autowired
  private RoleRepository roleRepository;

  public Role findById(Long id) {
    return this.roleRepository.getOne(id);
  }

  public List<Role> findByName(String name) {
    return this.roleRepository.findByName(name);
  }


}

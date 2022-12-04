package com.example.isa.repository;
import com.example.isa.model.Role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
	List<Role> findByName(String name);
}

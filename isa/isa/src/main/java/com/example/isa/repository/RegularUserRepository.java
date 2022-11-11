package com.example.isa.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.isa.model.RegularUser;

public interface RegularUserRepository extends JpaRepository<RegularUser, Long> {

    RegularUser findRegularUserById(Long id);

    List<RegularUser> findAll();

    List<RegularUser> findByFirstNameAndLastName(String firstName, String lastName);

}

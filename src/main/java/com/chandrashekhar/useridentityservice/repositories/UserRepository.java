package com.chandrashekhar.useridentityservice.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandrashekhar.useridentityservice.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>{
    
}

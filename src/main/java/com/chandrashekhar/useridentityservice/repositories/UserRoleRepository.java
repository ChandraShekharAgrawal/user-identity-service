package com.chandrashekhar.useridentityservice.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandrashekhar.useridentityservice.entities.Role;
import com.chandrashekhar.useridentityservice.entities.UserRole;
import com.chandrashekhar.useridentityservice.entities.UserRoleKey;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, UserRoleKey>{
    List<Role> findRolesByUserId( UUID userId);
}

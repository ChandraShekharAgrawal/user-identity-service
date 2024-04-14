package com.chandrashekhar.useridentityservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chandrashekhar.useridentityservice.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

    Role findByRole(String roleName);

}

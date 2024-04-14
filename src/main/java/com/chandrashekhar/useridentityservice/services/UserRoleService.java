package com.chandrashekhar.useridentityservice.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



import org.springframework.stereotype.Service;

import com.chandrashekhar.useridentityservice.dtos.AssignRoleRequestDto;
import com.chandrashekhar.useridentityservice.dtos.AssignRoleResponseDto;
import com.chandrashekhar.useridentityservice.repositories.RoleRepository;
import com.chandrashekhar.useridentityservice.repositories.UserRepository;
import com.chandrashekhar.useridentityservice.repositories.UserRoleRepository;
import com.chandrashekhar.useridentityservice.entities.User;
import com.chandrashekhar.useridentityservice.entities.Role;
import com.chandrashekhar.useridentityservice.entities.UserRole;

@Service
public class UserRoleService {

    private UserRoleRepository userRoleRepository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserRoleService(UserRoleRepository userRoleRepository, UserRepository userRepository, RoleRepository roleRepository){
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public AssignRoleResponseDto assignRoleToUser(AssignRoleRequestDto assignRoleRequestDto) {
        UUID userId = assignRoleRequestDto.getUserId();
        String roleName = assignRoleRequestDto.getRoleName();

        Optional<User> userOptional = userRepository.findById(userId);
        User user = null;
        if(userOptional.isPresent()){
            user = userOptional.get();
        }
        else{
            throw new IllegalArgumentException("User not found with id: " + userId);
        }

        Role role = roleRepository.findByRole(roleName);

        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);

        userRoleRepository.save(userRole);

        AssignRoleResponseDto assignRoleResponseDto = new AssignRoleResponseDto();
        assignRoleResponseDto.setUserId(userId);
        List<Role> roleList = userRoleRepository.findRolesByUserId(userId);
        assignRoleResponseDto.setRoleList(roleList);
        return assignRoleResponseDto;
    }
}

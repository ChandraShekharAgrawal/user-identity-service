package com.chandrashekhar.useridentityservice.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.chandrashekhar.useridentityservice.dtos.UserDto;
import com.chandrashekhar.useridentityservice.entities.User;
import com.chandrashekhar.useridentityservice.mappers.UserMapper;
import com.chandrashekhar.useridentityservice.repositories.UserRepository;

@Service
public class UserService {
    
    private UserRepository userRepository;    
    private UserMapper userMapper;    

    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public UserDto getUserById(UUID id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return userMapper.convertUserToDto(userOptional.get());
        }
        throw new IllegalArgumentException("User not found with id: " + id);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDto = userMapper.convertUserListToUserDtoList(users);
        return userDto;
    }

}

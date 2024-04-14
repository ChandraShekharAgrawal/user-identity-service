package com.chandrashekhar.useridentityservice.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.chandrashekhar.useridentityservice.dtos.UserDto;
import com.chandrashekhar.useridentityservice.entities.User;

@Component
public class UserMapper {
    

    public UserDto convertUserToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());

        // we are ignoring password from serialization, so we can have the below line as well. But not required. So, commented out.
        // userDto.setPassword(user.getPassword());
        userDto.setAddress(user.getAddress());
        userDto.setPhone(user.getPhone());
        return userDto;
    }

    public List<UserDto> convertUserListToUserDtoList(List<User> users) {
        return users.stream()
                    .map(this::convertUserToDto)
                    .collect(Collectors.toList());        
    }
}

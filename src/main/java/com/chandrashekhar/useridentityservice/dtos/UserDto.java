package com.chandrashekhar.useridentityservice.dtos;

import java.util.UUID;

// import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UserDto {
    private UUID id;
    private String email;

    // @JsonIgnore
    // private String password;

    private String phone;
    private String address;
}

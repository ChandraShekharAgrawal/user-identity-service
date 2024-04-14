package com.chandrashekhar.useridentityservice.dtos;

import lombok.Data;

@Data
public class CreateRoleRequestDto {
    private String role;
    private String description;
}

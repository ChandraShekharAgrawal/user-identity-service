package com.chandrashekhar.useridentityservice.dtos;

import lombok.Data;

@Data
public class RoleResponseDto {
    private Integer id;
    private String role;
    private String description;
}

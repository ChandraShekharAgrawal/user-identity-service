package com.chandrashekhar.useridentityservice.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class AssignRoleRequestDto {
    private UUID userId;
    private String roleName;
}

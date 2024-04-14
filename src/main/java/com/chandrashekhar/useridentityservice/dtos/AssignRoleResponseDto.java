package com.chandrashekhar.useridentityservice.dtos;

import java.util.List;
import java.util.UUID;

import com.chandrashekhar.useridentityservice.entities.Role;

import lombok.Data;

@Data
public class AssignRoleResponseDto {
    private UUID userId;
    private List<Role> roleList;
}

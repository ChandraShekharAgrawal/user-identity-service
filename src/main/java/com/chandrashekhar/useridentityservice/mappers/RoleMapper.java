package com.chandrashekhar.useridentityservice.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.chandrashekhar.useridentityservice.dtos.RoleResponseDto;
import com.chandrashekhar.useridentityservice.entities.Role;

@Component
public class RoleMapper {

    public RoleResponseDto convertRoleToRoleResponseDto(Role role){
        RoleResponseDto roleResponseDto = new RoleResponseDto();
        roleResponseDto.setId(role.getId());
        roleResponseDto.setRole(role.getRole());
        roleResponseDto.setDescription(role.getDescription());
        return roleResponseDto;
    }
    
    public List<RoleResponseDto> convertRoleListToRoleResponseDtoList(List<Role> roleList) {
        return roleList.stream()
                        .map(this::convertRoleToRoleResponseDto)
                        .collect(Collectors.toList());
    }
    
}

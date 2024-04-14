package com.chandrashekhar.useridentityservice.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chandrashekhar.useridentityservice.dtos.CreateRoleRequestDto;
import com.chandrashekhar.useridentityservice.dtos.RoleResponseDto;
import com.chandrashekhar.useridentityservice.entities.Role;
import com.chandrashekhar.useridentityservice.mappers.RoleMapper;
import com.chandrashekhar.useridentityservice.repositories.RoleRepository;

@Service
public class RoleService {
    
    private RoleRepository roleRepository;
    private RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper){
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    public List<RoleResponseDto> getAllRoles() {
        List<Role> roleList = roleRepository.findAll();
        List<RoleResponseDto> roleResponseDtoList = roleMapper.convertRoleListToRoleResponseDtoList(roleList);
        return roleResponseDtoList;
    }

    public RoleResponseDto createRole(CreateRoleRequestDto createRoleRequestDto) {
        Role role = new Role();
        role.setRole(createRoleRequestDto.getRole());
        role.setDescription(createRoleRequestDto.getDescription());
        Role createdRole = roleRepository.save(role);

        RoleResponseDto roleResponseDto = roleMapper.convertRoleToRoleResponseDto(createdRole);
        return roleResponseDto;
    }
}

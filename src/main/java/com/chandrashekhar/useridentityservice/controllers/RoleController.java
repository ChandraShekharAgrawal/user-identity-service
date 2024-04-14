package com.chandrashekhar.useridentityservice.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandrashekhar.useridentityservice.dtos.CreateRoleRequestDto;
import com.chandrashekhar.useridentityservice.dtos.RoleResponseDto;
import com.chandrashekhar.useridentityservice.services.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDto>> getAllRoles(){
        List<RoleResponseDto> roleResponseDtoList = roleService.getAllRoles();
        return new ResponseEntity<>(roleResponseDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleResponseDto> createRole(@RequestBody CreateRoleRequestDto createRoleRequestDto){
        RoleResponseDto createdRoleResponseDto = roleService.createRole(createRoleRequestDto);
        return new ResponseEntity<>(createdRoleResponseDto, HttpStatus.CREATED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
    
}

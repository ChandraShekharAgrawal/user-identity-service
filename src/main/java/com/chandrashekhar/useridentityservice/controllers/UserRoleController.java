package com.chandrashekhar.useridentityservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandrashekhar.useridentityservice.dtos.AssignRoleRequestDto;
import com.chandrashekhar.useridentityservice.dtos.AssignRoleResponseDto;
import com.chandrashekhar.useridentityservice.services.UserRoleService;

@RestController
@RequestMapping("/userRoles")
public class UserRoleController {
    
    private UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService){
        this.userRoleService = userRoleService;
    }
    @PostMapping
    public ResponseEntity<AssignRoleResponseDto> assignRoleToUser(@RequestBody AssignRoleRequestDto assignRoleRequestDto){
        AssignRoleResponseDto assignRoleResponseDto = userRoleService.assignRoleToUser(assignRoleRequestDto);
        return new ResponseEntity<>(assignRoleResponseDto, HttpStatus.CREATED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}

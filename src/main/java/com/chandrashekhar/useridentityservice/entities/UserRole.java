package com.chandrashekhar.useridentityservice.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_roles")
@IdClass(UserRoleKey.class)
public class UserRole {
    @Id
    @Column(name = "user_id")
    private UUID userId;

    @Id
    @Column(name = "role_id")
    private Integer roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Role role;

    // public UUID getUserId(){
    //     return userId;
    // }

    // public void setUserId(UUID userId){
    //     this.userId = userId;
    // }

    // public Integer getRoleId(){
    //     return roleId;
    // }

    // public void setRoleId(Integer roleId){
    //     this.roleId = roleId;
    // }

    // public User getUser(){
    //     return user;
    // }

    // public void setUser(User user){
    //     this.user = user;
    // }

    // public Role getRole(){
    //     return role;
    // }

    // public void setRole(Role role){
    //     this.role = role;
    // }

    // public UserRoleKey getKey(){
    //     return new UserRoleKey(userId, roleId);
    // }

    // public void setKey(UserRoleKey key){
    //     this.roleId = key.getRoleId();
    //     this.userId = key.getUserId();
    // }
}

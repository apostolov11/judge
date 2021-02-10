package com.softuni.security;

import com.softuni.model.entity.RoleNameEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private Long id;
    private String username;
    private RoleNameEnum roleNameEnum;

    public CurrentUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RoleNameEnum getRoleNameEnum() {
        return roleNameEnum;
    }

    public void setRoleNameEnum(RoleNameEnum roleNameEnum) {
        this.roleNameEnum = roleNameEnum;
    }

    public boolean isAnonymous() {
        return this.username == null;
    }

    public boolean isAdmin() {
        return this.roleNameEnum == roleNameEnum.ADMIN;
    }


}

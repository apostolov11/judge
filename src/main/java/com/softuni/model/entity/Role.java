package com.softuni.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RoleNameEnum name;

    public Role() {
    }

    public RoleNameEnum getName() {
        return name;
    }

    public void setName(RoleNameEnum name) {
        this.name = name;
    }
}

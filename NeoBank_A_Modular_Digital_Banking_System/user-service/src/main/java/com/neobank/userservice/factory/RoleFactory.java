package com.neobank.userservice.factory;

import com.neobank.userservice.entity.Role;

public class RoleFactory {
    public static Role createRole(String type) {
        Role role = new Role();
        role.setRoleName(type.toUpperCase());
        return role;
    }
}


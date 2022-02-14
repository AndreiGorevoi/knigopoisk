package com.freeapp.knigopoiskback.service;

import com.freeapp.knigopoiskback.entity.Role;
import com.freeapp.knigopoiskback.entity.TypeOfRoles;

import java.util.List;
import java.util.UUID;

public interface RoleService {
        Role getByName(TypeOfRoles name);
        Role getById(UUID id);
        List<Role> getAll();
        void save(Role role);
}

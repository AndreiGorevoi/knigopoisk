package com.freeapp.knigopoiskback.repository;

import com.freeapp.knigopoiskback.entity.Role;
import com.freeapp.knigopoiskback.entity.TypeOfRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
        Role findRoleByName(TypeOfRoles name);
}

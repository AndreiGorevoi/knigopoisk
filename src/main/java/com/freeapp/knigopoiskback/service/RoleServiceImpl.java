package com.freeapp.knigopoiskback.service;

import com.freeapp.knigopoiskback.entity.Role;
import com.freeapp.knigopoiskback.entity.TypeOfRoles;
import com.freeapp.knigopoiskback.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {
        private final RoleRepository roleRepository;

        public RoleServiceImpl(RoleRepository roleRepository) {
                this.roleRepository = roleRepository;
        }

        @Override
        public Role getByName(TypeOfRoles name) {
                return roleRepository.findRoleByName(name);
        }

        @Override
        public Role getById(UUID id) {
                return roleRepository.findById(id).orElse(null);
        }

        @Override
        public List<Role> getAll() {
                return roleRepository.findAll();
        }

        @Override
        public void save(Role role) {
                roleRepository.save(role);
        }
}

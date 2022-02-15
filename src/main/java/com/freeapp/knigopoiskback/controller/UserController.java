package com.freeapp.knigopoiskback.controller;

import com.freeapp.knigopoiskback.dto.RegistrationData;
import com.freeapp.knigopoiskback.dto.UserDto;
import com.freeapp.knigopoiskback.entity.AppUser;
import com.freeapp.knigopoiskback.entity.TypeOfRoles;
import com.freeapp.knigopoiskback.service.AppUserService;
import com.freeapp.knigopoiskback.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

        private final AppUserService appUserService;
        private final RoleService roleService;
        private final PasswordEncoder passwordEncoder;

        public UserController(
            AppUserService appUserService, RoleService roleService, PasswordEncoder passwordEncoder) {
                this.appUserService = appUserService;
                this.roleService = roleService;
                this.passwordEncoder = passwordEncoder;
        }

        @GetMapping(value = "/all")
        public ResponseEntity<List<AppUser>> getAll() {
                return ResponseEntity.ok(appUserService.findAll());
        }

        @PostMapping(value = "/save")
        public ResponseEntity<UserDto> saveUser(@RequestBody RegistrationData registrationData) {
                if (registrationData != null) {
                        AppUser appUser = AppUser.createUserForRegistrationData(registrationData, this.passwordEncoder);
                        appUser.setRoles(List.of(roleService.getByName(TypeOfRoles.USER)));
                        appUserService.save(appUser);
                        return ResponseEntity.ok(UserDto.fromUser(appUser));
                }
                return ResponseEntity.badRequest().build();
        }
}

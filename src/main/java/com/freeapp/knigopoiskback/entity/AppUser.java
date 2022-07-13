package com.freeapp.knigopoiskback.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.freeapp.knigopoiskback.dto.RegistrationData;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "users")
public class AppUser extends BaseEntity {
        @Column(name = "login")
        private String login;

        @Column(name = "password")
        private String password;

        @Column(name = "email")
        private String email;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "user_roles", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
            @JoinColumn(name = "role_id", referencedColumnName = "id") })
        @JsonIgnore
        private List<Role> roles;

        public static AppUser createUserForRegistrationData(
            RegistrationData registrationData,
            PasswordEncoder passwordEncoder) {
                AppUser appUser = new AppUser();
                appUser.setLogin(registrationData.getLogin());
                appUser.setEmail(registrationData.getEmail());
                appUser.setPassword(passwordEncoder.encode(registrationData.getPassword()));
                return appUser;
        }

        @Override
        public String toString() {
                return "AppUser{" + "login='" + login + '\'' + ", email='" + email + '\'' + '}';
        }
}

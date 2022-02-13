package com.freeapp.knigopoiskback.entity;

import lombok.Data;

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
        private List<Role> roles;
}

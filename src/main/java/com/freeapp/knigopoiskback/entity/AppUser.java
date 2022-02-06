package com.freeapp.knigopoiskback.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "USERS")
public class AppUser {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getLogin() {
                return login;
        }

        public void setLogin(String login) {
                this.login = login;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        @Column(name = "login")
        private String login;

        @Column(name = "password")
        private String password;

}

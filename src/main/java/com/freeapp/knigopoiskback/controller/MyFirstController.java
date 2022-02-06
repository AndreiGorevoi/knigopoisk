package com.freeapp.knigopoiskback.controller;

import com.freeapp.knigopoiskback.repository.AppUserRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/controller")
@CrossOrigin(origins = "http://localhost:3000")
public class MyFirstController {
        private final AppUserRepository appUserRepository;

        public MyFirstController(AppUserRepository appUserRepository) {
                this.appUserRepository = appUserRepository;
        }

        @GetMapping(value = "/test")
        public String startedMethod() {
                return appUserRepository.findById(1L).get().getLogin();
        }
}

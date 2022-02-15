package com.freeapp.knigopoiskback.service;

import com.freeapp.knigopoiskback.entity.AppUser;

import java.util.List;
import java.util.UUID;

public interface AppUserService {
        AppUser findByLogin(String login);
        AppUser findById(UUID id);
        List<AppUser> findAll();
        void save(AppUser user);
}

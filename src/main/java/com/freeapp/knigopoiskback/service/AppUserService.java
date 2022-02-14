package com.freeapp.knigopoiskback.service;

import com.freeapp.knigopoiskback.entity.AppUser;

import java.util.List;
import java.util.UUID;

public interface AppUserService {
        AppUser getByLogin(String login);
        AppUser getById(UUID id);
        List<AppUser> getAll();
        void save(AppUser user);
}

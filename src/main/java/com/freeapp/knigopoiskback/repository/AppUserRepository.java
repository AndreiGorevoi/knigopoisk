package com.freeapp.knigopoiskback.repository;

import com.freeapp.knigopoiskback.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
        AppUser findAppUserByLogin(String login);
}

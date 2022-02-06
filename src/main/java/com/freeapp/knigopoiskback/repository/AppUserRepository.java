package com.freeapp.knigopoiskback.repository;

import com.freeapp.knigopoiskback.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
}

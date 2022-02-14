package com.freeapp.knigopoiskback.service;

import com.freeapp.knigopoiskback.entity.AppUser;
import com.freeapp.knigopoiskback.repository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppUserServiceImpl implements AppUserService {

        private final AppUserRepository appUserRepository;

        public AppUserServiceImpl(AppUserRepository appUserRepository) {
                this.appUserRepository = appUserRepository;
        }

        @Override
        public AppUser getByLogin(String login) {
                return appUserRepository.findAppUserByLogin(login);
        }

        @Override
        public AppUser getById(UUID id) {
                return appUserRepository.findById(id).orElse(null);
        }

        @Override
        public List<AppUser> getAll() {
                return appUserRepository.findAll();
        }

        @Override
        public void save(AppUser user) {
                appUserRepository.save(user);
        }
}

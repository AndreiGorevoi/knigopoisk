package com.freeapp.knigopoiskback.security.jwt;

import com.freeapp.knigopoiskback.entity.AppUser;
import com.freeapp.knigopoiskback.service.AppUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Andrei Gorevoi
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

        private final AppUserService appUserService;

        public JwtUserDetailsService(AppUserService appUserService) {
                this.appUserService = appUserService;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                AppUser appUser = appUserService.findByLogin(username);
//                TODO: replace to Optional?
                if (appUser == null) {
                        throw new UsernameNotFoundException("User with username".concat(username).concat(" not found"));
                }

                return JwtUserFactory.create(appUser);
        }
}

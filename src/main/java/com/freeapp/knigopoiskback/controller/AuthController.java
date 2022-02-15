package com.freeapp.knigopoiskback.controller;

import com.freeapp.knigopoiskback.dto.LoginData;
import com.freeapp.knigopoiskback.entity.AppUser;
import com.freeapp.knigopoiskback.security.jwt.JwtTokenProvider;
import com.freeapp.knigopoiskback.service.AppUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Andrei Gorevoi
 */
@RestController
@RequestMapping(value = "/api/")
public class AuthController {

        private final AuthenticationManager authenticationManager;
        private final JwtTokenProvider jwtTokenProvider;
        private final AppUserService appUserService;

        public AuthController(
            AuthenticationManager authenticationManager,
            JwtTokenProvider jwtTokenProvider,
            AppUserService appUserService) {
                this.authenticationManager = authenticationManager;
                this.jwtTokenProvider = jwtTokenProvider;
                this.appUserService = appUserService;
        }

        @PostMapping("login")
        public ResponseEntity login(@RequestBody LoginData data) {
                try {
                        String login = data.getLogin();
                        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login,
                            data.getPassword()));
                        AppUser appUser = appUserService.findByLogin(login);

                        if (appUser == null) {
                                throw new UsernameNotFoundException("User with login: ".concat(login)
                                    .concat(" not found"));
                        }
                        String token = jwtTokenProvider.createToken(login, appUser.getRoles());
                        HashMap<Object, Object> response = new HashMap<>();
                        response.put("login", login);
                        response.put("token", token);
                        return ResponseEntity.ok(response);
                } catch (AuthenticationException e) {
                        throw new BadCredentialsException("Invalid login or password");
                }
        }
}

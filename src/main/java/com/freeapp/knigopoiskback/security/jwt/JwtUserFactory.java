package com.freeapp.knigopoiskback.security.jwt;

import com.freeapp.knigopoiskback.entity.AppUser;
import com.freeapp.knigopoiskback.entity.Role;
import com.freeapp.knigopoiskback.entity.Status;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrei Gorevoi
 */
@NoArgsConstructor
public class JwtUserFactory {
        public static JwtUser create(AppUser user) {
                return new JwtUser(
                    user.getId(),
                    user.getLogin(),
                    user.getPassword(),
                    user.getEmail(),
                    user.getStatus() == Status.ACTIVE,
                    JwtUserFactory.mapToGrantedAuthorities(user.getRoles()));
        }

        public static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
                return userRoles.stream().map(role -> new SimpleGrantedAuthority(role.getName().name()))
                    .collect(Collectors.toList());
        }
}

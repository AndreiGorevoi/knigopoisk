package com.freeapp.knigopoiskback.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.UUID;

/**
 * @author Andrei Gorevoi
 */
public class JwtUser implements UserDetails {

        private final UUID id;
        private final String login;
        private final String password;
        private final String email;
        private final boolean enabled;
        private final Collection<? extends GrantedAuthority> authorities;

        public JwtUser(
            UUID id,
            String login,
            String password,
            String email,
            boolean enabled,
            Collection<? extends GrantedAuthority> authorities) {
                this.id = id;
                this.login = login;
                this.password = password;
                this.email = email;
                this.enabled = enabled;
                this.authorities = authorities;
        }

        @JsonIgnore
        public UUID getId() {
                return id;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
                return authorities;
        }

        @Override
        @JsonIgnore
        public String getPassword() {
                return password;
        }

        @Override
        public String getUsername() {
                return login;
        }

        @Override
        public boolean isAccountNonExpired() {
                return true;
        }

        @Override
        @JsonIgnore
        public boolean isAccountNonLocked() {
                return true;
        }

        @Override
        @JsonIgnore
        public boolean isCredentialsNonExpired() {
                return true;
        }

        @Override
        public boolean isEnabled() {
                return enabled;
        }

        public String getEmail() {
                return email;
        }
}

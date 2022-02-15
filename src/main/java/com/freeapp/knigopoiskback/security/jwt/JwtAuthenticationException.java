package com.freeapp.knigopoiskback.security.jwt;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Andrei Gorevoi
 */
public class JwtAuthenticationException extends AuthenticationException {
        public JwtAuthenticationException(String msg, Throwable cause) {
                super(msg, cause);
        }

        public JwtAuthenticationException(String msg) {
                super(msg);
        }
}

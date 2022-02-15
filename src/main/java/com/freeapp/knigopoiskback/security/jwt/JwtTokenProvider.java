package com.freeapp.knigopoiskback.security.jwt;

import com.freeapp.knigopoiskback.entity.Role;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andrei Gorevoi
 */
@Component
public class JwtTokenProvider {

        @Value("${jwt.token.secret}")
        private String secret;
        @Value("${jwt.token.expired}")
        private long validityInMilliseconds;

        private final UserDetailsService userDetailsService;

        public JwtTokenProvider(UserDetailsService userDetailsService) {
                this.userDetailsService = userDetailsService;
        }

        @Bean
        public PasswordEncoder getPasswordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @PostConstruct
        protected void init() {
                secret = Base64.getEncoder().encodeToString(secret.getBytes());
        }

        public String createToken(String username, List<Role> userRoles) {
                Claims claims = Jwts.claims().setSubject(username);
                claims.put("roles", userRoles);

                Date now = new Date();
                Date validity = new Date(now.getTime() + validityInMilliseconds);
                return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity)
                    .signWith(SignatureAlgorithm.HS256, secret).compact();
        }

        public String getUserName(String token) {
                return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
        }

        public String resolveToken(HttpServletRequest request) {
                String bearerToken = request.getHeader("Authorization");
                if (bearerToken != null && bearerToken.startsWith("Bearer")) {
                        return bearerToken.substring(7);
                }
                return null;
        }

        public Authentication getAuthentication(String token) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUserName(token));
                return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
        }

        public boolean validateToken(String token) {
                try {
                        Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
                        if (claims.getBody().getExpiration().before(new Date())) {
                                return false;
                        }
                        return true;
                } catch (JwtException | IllegalArgumentException e) {
                        throw new JwtAuthenticationException("Jwt token os expired or invalid");
                }
        }

        public List<String> getRoleNames(List<Role> userRoles) {
                return userRoles.stream().map(role -> role.getName().name()).collect(Collectors.toList());
        }
}

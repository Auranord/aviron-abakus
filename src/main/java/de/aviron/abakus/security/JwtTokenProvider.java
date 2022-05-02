package de.aviron.abakus.security;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import de.aviron.abakus.config.JwtConfig;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {

    private final JwtConfig jwtConfig;

    public JwtTokenProvider(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public String generateToken(String userEmail) {
        Instant now = Instant.now();
        Instant expiration = now.plus(jwtConfig.getTokenExpirationDays(), ChronoUnit.DAYS);

        return Jwts.builder()
                .setSubject(userEmail)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(expiration))
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret())
                .compact();

    }

    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return generateToken(user.getUsername());
    }

    public String getUserMailFromToken(String token) {
        Claims claims = Jwts
                .parser()
                .setSigningKey(jwtConfig.getSecret())
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }

        return false;
    }

}

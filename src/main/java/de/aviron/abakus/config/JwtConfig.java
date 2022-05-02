package de.aviron.abakus.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    
    private String secret;
    private Integer tokenExpirationDays;

    public JwtConfig() {
    }

}

package com.HenriqueMundim.github.com.orange_app_api.domain.services.token;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String tokenSecret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(tokenSecret);

            return JWT.create()
                    .withIssuer("orange-app")
                    .withExpiresAt(generateExpirationDate())
                    .sign(algorithm);

        } catch (JWTCreationException exception) {
            System.out.println(exception.getMessage());
            return "";
        }
    }


    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-3:00"));
    }
}

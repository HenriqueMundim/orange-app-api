package com.HenriqueMundim.github.com.orange_app_api.app.controllers;

import com.HenriqueMundim.github.com.orange_app_api.domain.services.auth.AuthService;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.UserLoginDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(
            value = "/login"
    )
    public ResponseEntity<String> login(@RequestBody UserLoginDTO data) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        String token = authService.authenticate(data);
        return ResponseEntity.ok().body(token);
    }
}

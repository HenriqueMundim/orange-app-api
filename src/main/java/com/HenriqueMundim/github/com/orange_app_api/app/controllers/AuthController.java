package com.HenriqueMundim.github.com.orange_app_api.app.controllers;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.domain.services.auth.AuthService;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.InputUserDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.OutputUserDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.UserLoginDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.UserLoginResponseDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserLoginResponseDTO> login(@RequestBody UserLoginDTO data) {
        String token = authService.authenticate(data);
        return ResponseEntity.ok(new UserLoginResponseDTO(token));
    }

    @PostMapping(
            value = "/enroll"
    )
    public ResponseEntity<OutputUserDTO> enroll(@RequestBody InputUserDTO data) {
        User user = this.authService.enroll(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toDomain(user));
    }
}

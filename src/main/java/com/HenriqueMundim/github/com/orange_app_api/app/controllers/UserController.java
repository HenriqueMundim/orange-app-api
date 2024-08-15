package com.HenriqueMundim.github.com.orange_app_api.app.controllers;

import com.HenriqueMundim.github.com.orange_app_api.domain.services.user.UserService;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.OutputUserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<OutputUserDTO> getUserInfo(@AuthenticationPrincipal UserDetails userDetails) {
        OutputUserDTO userInfo = userService.getUserByUsername(userDetails.getUsername());

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userInfo);
    }
}

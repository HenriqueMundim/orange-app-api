package com.HenriqueMundim.github.com.orange_app_api.domain.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<DefaultException> authenticationExceptionHandler(AuthenticationException exception, WebRequest request) {
        DefaultException response = new DefaultException(LocalDateTime.now(), exception.getMessage());
        String location = request.getDescription(false).split("=")[1];

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).location(URI.create(location)).body(response);
    }
 }

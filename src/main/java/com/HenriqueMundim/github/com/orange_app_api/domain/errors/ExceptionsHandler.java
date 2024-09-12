package com.HenriqueMundim.github.com.orange_app_api.domain.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.auth0.jwt.exceptions.JWTVerificationException;

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

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<DefaultException> resourceAlreadyExistsExceptionHandler(ResourceAlreadyExistsException exception, WebRequest request) {
        DefaultException response = new DefaultException(LocalDateTime.now(), exception.getMessage());
        String location = request.getDescription(false).split("=")[1];

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).location(URI.create(location)).body(response);
    }
    
    @ExceptionHandler(ResourceNotFoundException.class) 
    public ResponseEntity<DefaultException> resourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
    	DefaultException response = new DefaultException(LocalDateTime.now(), exception.getMessage());
    	String location = request.getDescription(false).split("=")[1];
    	
    	return ResponseEntity.status(HttpStatus.NOT_FOUND).location(URI.create(location)).body(response);
    }
    
    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<DefaultException> jwtVerificationExeption(JWTVerificationException exception, WebRequest request) {
    	DefaultException response = new DefaultException(LocalDateTime.now(), exception.getMessage());
    	String location = request.getDescription(false).split("=")[1];	
    	
    	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).location(URI.create(location)).body(response);
    }
  }

package com.HenriqueMundim.github.com.orange_app_api.domain.errors;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String message) {
        super(message);
    }
}

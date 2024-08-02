package com.HenriqueMundim.github.com.orange_app_api.domain.errors;

import java.time.LocalDateTime;

public class DefaultException {

    private LocalDateTime date;

    private String message;

    public DefaultException() {}

    public DefaultException(LocalDateTime date, String message) {
        this.date = date;
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

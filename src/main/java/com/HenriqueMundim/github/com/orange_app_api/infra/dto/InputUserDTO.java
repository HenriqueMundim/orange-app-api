package com.HenriqueMundim.github.com.orange_app_api.infra.dto;

import com.HenriqueMundim.github.com.orange_app_api.domain.enums.UserRole;

import java.io.Serial;
import java.io.Serializable;

public class InputUserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    private String email;

    private String username;

    private String lastName;

    private String password;

    private UserRole role;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}

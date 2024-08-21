package com.HenriqueMundim.github.com.orange_app_api.infra.dto;

import com.HenriqueMundim.github.com.orange_app_api.domain.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serial;
import java.io.Serializable;

public class InputUserDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    private String email;

    private String lastName;

    private String password;

    private UserRole role;

    public InputUserDTO(String name, String email, String lastName, String password, UserRole role) {
		this.name = name;
		this.email = email;
		this.lastName = lastName;
		this.password = password;
		this.role = role;
	}

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

    @JsonIgnore
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}

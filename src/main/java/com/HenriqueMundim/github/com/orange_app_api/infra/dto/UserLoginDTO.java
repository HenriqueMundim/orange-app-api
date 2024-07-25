package com.HenriqueMundim.github.com.orange_app_api.infra.dto;

import java.io.Serial;
import java.io.Serializable;

public class UserLoginDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public String username;

    public String password;

    public UserLoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

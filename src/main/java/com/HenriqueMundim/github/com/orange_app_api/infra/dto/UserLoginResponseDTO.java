package com.HenriqueMundim.github.com.orange_app_api.infra.dto;

import java.io.Serial;
import java.io.Serializable;

public class UserLoginResponseDTO {

    private String token;

    public UserLoginResponseDTO() {}

    public UserLoginResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}

package com.HenriqueMundim.github.com.orange_app_api.infra.mapper;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.domain.enums.UserRole;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.InputUserDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.OutputUserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserMapper {

    public static OutputUserDTO toDomain(User user) {
        OutputUserDTO response = new OutputUserDTO();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getUsername());

        return response;
    }

    public static User toEntity(InputUserDTO user) {
        User response = new User();

        response.setName(user.getName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getUsername());
        response.setPassword(user.getPassword());
        response.setRole(UserRole.USER);

        return response;
    }
}

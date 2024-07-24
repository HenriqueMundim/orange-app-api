package com.HenriqueMundim.github.com.orange_app_api.domain.interfaces;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;

public interface IUserRepository {
    User findByUsername(String username);
}

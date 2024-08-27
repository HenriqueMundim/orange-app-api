package com.HenriqueMundim.github.com.orange_app_api.domain.interfaces;

import java.util.Optional;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;

public interface IUserRepository {
    User findByUsername(String username);
    User save(User user);
    Optional<User> findById(Integer id);
}

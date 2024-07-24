package com.HenriqueMundim.github.com.orange_app_api.infra.repositories;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.domain.interfaces.IUserRepository;
import com.HenriqueMundim.github.com.orange_app_api.infra.daos.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {

    private final UserDao dao;

    @Autowired
    public UserRepository(UserDao userDao) {
        this.dao = userDao;
    }

    @Override
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    public User save(User user) {
        return dao.save(user);
    }
}

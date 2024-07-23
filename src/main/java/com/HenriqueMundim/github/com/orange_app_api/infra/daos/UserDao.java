package com.HenriqueMundim.github.com.orange_app_api.infra.daos;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}

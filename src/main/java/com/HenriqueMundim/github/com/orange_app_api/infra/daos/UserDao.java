package com.HenriqueMundim.github.com.orange_app_api.infra.daos;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    User findByUsername(String username);
}

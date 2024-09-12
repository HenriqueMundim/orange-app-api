package com.HenriqueMundim.github.com.orange_app_api.infra.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Integer> {}

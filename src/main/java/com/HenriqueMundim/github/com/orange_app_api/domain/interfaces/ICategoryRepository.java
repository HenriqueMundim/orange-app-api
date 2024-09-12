package com.HenriqueMundim.github.com.orange_app_api.domain.interfaces;

import java.util.List;
import java.util.Optional;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Category;

public interface ICategoryRepository {
	List<Category> findAll();
	Optional<Category> findById(Integer id);
}

package com.HenriqueMundim.github.com.orange_app_api.domain.interfaces;

import java.util.List;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Category;

public interface ICategoryRepository {
	List<Category> findAll();
}

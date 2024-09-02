package com.HenriqueMundim.github.com.orange_app_api.infra.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Category;
import com.HenriqueMundim.github.com.orange_app_api.domain.interfaces.ICategoryRepository;
import com.HenriqueMundim.github.com.orange_app_api.infra.daos.CategoryDAO;

@Repository
public class CategoryRepository implements ICategoryRepository {
	
	private final CategoryDAO dao;
	
	public CategoryRepository(CategoryDAO dao) {
		this.dao = dao;
	}

	public List<Category> findAll() {
		return this.dao.findAll();
	}
	
}

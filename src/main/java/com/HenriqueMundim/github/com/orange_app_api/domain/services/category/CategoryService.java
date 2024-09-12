package com.HenriqueMundim.github.com.orange_app_api.domain.services.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Category;
import com.HenriqueMundim.github.com.orange_app_api.infra.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> findAll() {
		return this.categoryRepository.findAll();
	}
}

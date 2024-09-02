package com.HenriqueMundim.github.com.orange_app_api.app.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Category;
import com.HenriqueMundim.github.com.orange_app_api.domain.services.category.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
	
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> getAll() {
		System.out.println("OK");
		return ResponseEntity.status(HttpStatus.OK).body(this.categoryService.findAll());
	}
}

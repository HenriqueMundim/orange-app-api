package com.HenriqueMundim.github.com.orange_app_api.infra.dto;

import java.util.HashSet;
import java.util.Set;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Category;


public class CreateProjectDTO {
	
	private Integer id;
	private String title;
	private String link;
	private String description;
	private String imageUrl;
	private Integer userId;
	private Set<Category> categories = new HashSet<>();
	
	public CreateProjectDTO() {}
	
	public CreateProjectDTO(Integer id, String title, String link, String description, String imageUrl, Integer userId, Set<Category> categories) {
		this.id = id;
		this.title = title;
		this.link = link;
		this.description = description;
		this.imageUrl = imageUrl;
		this.userId = userId;
		this.categories = categories;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

}

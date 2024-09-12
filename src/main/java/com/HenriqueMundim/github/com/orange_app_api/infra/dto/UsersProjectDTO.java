package com.HenriqueMundim.github.com.orange_app_api.infra.dto;

import java.util.HashSet;
import java.util.Set;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Category;

public class UsersProjectDTO {
	
	private Integer id;
	private String title;
	private String link;
	private String description;
	private String imageUrl;
	private Set<Category> categories = new HashSet<Category>();
	private OutputUserDTO author;
	
	public UsersProjectDTO() {}
	
	public UsersProjectDTO(Integer id, String title, String link, String description, String imageUrl, Set<Category> categories, OutputUserDTO author) {
		this.id = id;
		this.title = title;
		this.link = link;
		this.description = description;
		this.imageUrl = imageUrl;
		this.categories = categories;
		this.author = author;
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

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public OutputUserDTO getAuthor() {
		return author;
	}

	public void setAuthor(OutputUserDTO author) {
		this.author = author;
	} 
}

package com.HenriqueMundim.github.com.orange_app_api.infra.dto;

import java.util.HashSet;
import java.util.Set;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Category;

public class OutputProjectDTO {
	
	private Integer id;
	private String title;
	private String link;
	private String description;
	private String imageUrl;
	private OutputUserDTO author;
	private Set<Category> categories = new HashSet<Category>();
	
	public OutputProjectDTO() {}
	
	public OutputProjectDTO(Integer id, String title, String link, String description, String imageUrl, OutputUserDTO author, Set<Category> categories) {
		this.id = id;
		this.title = title;
		this.link = link;
		this.description = description;
		this.imageUrl = imageUrl;
		this.author = author;
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

	public OutputUserDTO getAuthor() {
		return author;
	}

	public void setAuthor(OutputUserDTO author) {
		this.author = author;
	}

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	
}

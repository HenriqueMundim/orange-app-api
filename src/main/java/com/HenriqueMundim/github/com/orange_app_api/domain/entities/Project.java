package com.HenriqueMundim.github.com.orange_app_api.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String link;
	
	@Column(nullable = false)
	private String description;
	
	@Column(name = "image_url", nullable = false)
	private String imageUrl;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@Column(name = "user_id", nullable = false)
	private User author;
	
	public Project(Integer id, String title, String link, String description, String imageUrl) {
		this.id = id;
		this.title = title;
		this.link = link;
		this.description = description;
		this.imageUrl = imageUrl;
	}
	
	
}

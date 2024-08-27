package com.HenriqueMundim.github.com.orange_app_api.app.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Project;
import com.HenriqueMundim.github.com.orange_app_api.domain.services.project.ProjectService;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
	
	private final ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping
	public ResponseEntity<Page<Project>> GetAllUserProjects(
		@RequestParam Integer id,
		@RequestParam(defaultValue = "0") Integer page,
		@RequestParam(defaultValue = "9") Integer size
	) {
		return ResponseEntity.status(HttpStatus.OK).body(this.projectService.findAllByUser(id, page, size));
	}

}

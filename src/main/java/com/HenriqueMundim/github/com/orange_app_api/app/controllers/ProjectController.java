package com.HenriqueMundim.github.com.orange_app_api.app.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.HenriqueMundim.github.com.orange_app_api.domain.services.project.ProjectService;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.CreateProjectDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.InputProjectDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.OutputProjectDTO;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
	
	private final ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Page<OutputProjectDTO>> getAllUserProjects(
		@PathVariable Integer id,
		@RequestParam(defaultValue = "0") Integer page,
		@RequestParam(defaultValue = "9") Integer size
	) {
		return ResponseEntity.status(HttpStatus.OK).body(this.projectService.findAllByUser(id, page, size));
	}
	
	@GetMapping(value = "/search/{id}")
	public ResponseEntity<Page<OutputProjectDTO>> getAllUserProjectsByCategory(
			@PathVariable Integer id,
			@RequestParam String category,
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "9") Integer size
		) {
		return ResponseEntity.status(HttpStatus.OK).body(this.projectService.findAllByUserAndCategory(id, category, page, size));
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<Page<OutputProjectDTO>> getAllProjectsByCategory(
			@RequestParam String category,
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "9") Integer size
		) {
		return ResponseEntity.status(HttpStatus.OK).body(this.projectService.findAllByCategory(category, page, size));
	}
	
	
	@GetMapping
	public ResponseEntity<Page<OutputProjectDTO>> getAllProject(
			@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "9") Integer size
		) {
		return ResponseEntity.status(HttpStatus.OK).body(this.projectService.findAll(page, size));
	}
	
	@PostMapping
	public ResponseEntity<OutputProjectDTO> registerProject(@RequestBody CreateProjectDTO project) {
  		return ResponseEntity.status(HttpStatus.CREATED).body(this.projectService.save(project));
	}
	
	@PatchMapping
	public ResponseEntity<OutputProjectDTO> updateProject(@RequestBody InputProjectDTO project) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.projectService.updateProject(project));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
   
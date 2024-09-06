package com.HenriqueMundim.github.com.orange_app_api.app.controllers;

import org.springframework.data.domain.Page;
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
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.UsersProjectDTO;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
	
	private final ProjectService projectService;
	
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping
	public ResponseEntity<Page<OutputProjectDTO>> getAllUserProjects(
		@RequestParam Integer id,
		@RequestParam(defaultValue = "0") Integer page,
		@RequestParam(defaultValue = "9") Integer size
	) {
		return ResponseEntity.status(HttpStatus.OK).body(this.projectService.findAllByUser(id, page, size));
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
		this.projectService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
   
package com.HenriqueMundim.github.com.orange_app_api.infra.mapper;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Project;
import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.CreateProjectDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.InputProjectDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.OutputProjectDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.UsersProjectDTO;

public class ProjectMapper {
			
	public static UsersProjectDTO toDomainWithoutUser(Project project) {
		UsersProjectDTO projectsDTO = new UsersProjectDTO();
		
		projectsDTO.setId(project.getId());
		projectsDTO.setTitle(project.getTitle());
		projectsDTO.setLink(project.getLink());
		projectsDTO.setDescription(project.getDescription());
		projectsDTO.setImageUrl(project.getImageUrl());
		projectsDTO.setCategories(project.getCategories());
		
		return projectsDTO;
	}
	
	public static Project toEntityWithId(InputProjectDTO projectDTO, User user) {
		Project project = new Project();
		
		project.setId(projectDTO.getId());
		project.setTitle(projectDTO.getTitle());
		project.setLink(projectDTO.getLink());
		project.setDescription(projectDTO.getDescription());
		project.setImageUrl(projectDTO.getImageUrl());
		project.setCategories(projectDTO.getCategories());
		project.setAuthor(user);
		
		return project;
	}
	
	public static Project toEntity(CreateProjectDTO projectDTO) {
		Project project = new Project();
		
		project.setTitle(projectDTO.getTitle());
		project.setLink(projectDTO.getLink());
		project.setDescription(projectDTO.getDescription());
		project.setImageUrl(projectDTO.getImageUrl());
		project.setCategories(projectDTO.getCategories());
		
		return project;
	}
	
	public static OutputProjectDTO toDomainWithuser(Project project) {
    	OutputProjectDTO projectDTO = new OutputProjectDTO();
    	
    	projectDTO.setId(project.getId());
		projectDTO.setTitle(project.getTitle());
		projectDTO.setLink(project.getLink());
		projectDTO.setDescription(project.getDescription());
		projectDTO.setImageUrl(project.getImageUrl()); 
		projectDTO.setAuthor(UserMapper.toDomain(project.getAuthor()));
		projectDTO.setCategories(project.getCategories());
		
		return projectDTO;
    }
}

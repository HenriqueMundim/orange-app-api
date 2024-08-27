package com.HenriqueMundim.github.com.orange_app_api.infra.mapper;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Project;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.UsersProjectDTO;

public class ProjectMapper {
	
	public static UsersProjectDTO toDomainWithoutUser(Project project) {
		UsersProjectDTO projectsDTO = new UsersProjectDTO();
		
		projectsDTO.setId(project.getId());
		projectsDTO.setTitle(project.getTitle());
		projectsDTO.setLink(project.getLink());
		projectsDTO.setDescription(project.getDescription());
		projectsDTO.setImageUrl(project.getImageUrl());
		
		return projectsDTO;
	}
}

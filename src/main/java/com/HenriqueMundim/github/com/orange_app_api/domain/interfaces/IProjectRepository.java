package com.HenriqueMundim.github.com.orange_app_api.domain.interfaces;

import org.springframework.data.domain.Page;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Project;
import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.CreateProjectDTO;

public interface IProjectRepository {
	Page<Project> findAllByUser(User id, Integer page, Integer size);
	
	Project save(Project project);
}

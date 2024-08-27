package com.HenriqueMundim.github.com.orange_app_api.domain.services.project;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Project;
import com.HenriqueMundim.github.com.orange_app_api.infra.daos.ProjectDAO;

@Service
public class ProjectService {
	
	private final ProjectDAO dao;
	
	public ProjectService(ProjectDAO dao) {
		this.dao = dao;
	}
	
	public Page<Project> findAllByUser(Integer id, Integer page, Integer size) {
		return null;
	}
 	
}

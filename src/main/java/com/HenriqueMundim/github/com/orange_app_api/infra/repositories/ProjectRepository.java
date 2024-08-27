package com.HenriqueMundim.github.com.orange_app_api.infra.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Project;
import com.HenriqueMundim.github.com.orange_app_api.domain.interfaces.IProjectRepository;
import com.HenriqueMundim.github.com.orange_app_api.infra.daos.ProjectDAO;

public class ProjectRepository implements IProjectRepository{
	
	private final ProjectDAO dao;
	
	public ProjectRepository(ProjectDAO dao) {
		this.dao = dao;
	}

	@Override
	public Page<Project> findAllByUser(Integer id, Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return dao.findByUser(id, pageable);
	}
	

}

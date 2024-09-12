package com.HenriqueMundim.github.com.orange_app_api.infra.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Project;
import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.domain.interfaces.IProjectRepository;
import com.HenriqueMundim.github.com.orange_app_api.infra.daos.ProjectDAO;

@Repository
public class ProjectRepository implements IProjectRepository{
	
	private final ProjectDAO dao;
	
	public ProjectRepository(ProjectDAO dao) {
		this.dao = dao;
	}

	@Override
	public Page<Project> findAllByUser(User user, Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return dao.findByUser(user, pageable);
	}

	@Override
	public Project save(Project project) {
		return dao.save(project);
	}

	@Override
	public void delete(Project project) {
		this.dao.delete(project);
	}

	@Override
	public Optional<Project> findById(Integer id) {
		return this.dao.findById(id);
	}

	@Override
	public Project update(Project project) {
		return this.dao.save(project);
	}

	@Override
	public Page<Project> findAllByUserAndCategory(User user, String category, Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return dao.findByUserAndCategory(user, category, pageable);
	}

	@Override
	public Page<Project> findAll(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size);
		return this.dao.findAll(pageable);
	}	

}

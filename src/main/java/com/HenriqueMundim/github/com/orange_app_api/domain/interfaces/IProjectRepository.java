package com.HenriqueMundim.github.com.orange_app_api.domain.interfaces;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Project;
import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;

public interface IProjectRepository {
	Page<Project> findAllByUser(User id, Integer page, Integer size);
	Page<Project> findAllByUserAndCategory(User id, String category, Integer page, Integer size);
	Project save(Project project);
	void delete(Project project);
	Optional<Project> findById(Integer id);
	Project update(Project project);
}

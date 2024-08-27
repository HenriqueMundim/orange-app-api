package com.HenriqueMundim.github.com.orange_app_api.domain.interfaces;

import org.springframework.data.domain.Page;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Project;

public interface IProjectRepository {
	Page<Project> findAllByUser(Integer id, Integer page, Integer size);
}

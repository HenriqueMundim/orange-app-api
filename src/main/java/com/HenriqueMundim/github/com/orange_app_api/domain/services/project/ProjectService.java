package com.HenriqueMundim.github.com.orange_app_api.domain.services.project;

import org.hibernate.internal.ExceptionConverterImpl;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Project;
import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.infra.repositories.ProjectRepository;
import com.HenriqueMundim.github.com.orange_app_api.infra.repositories.UserRepository;

@Service
public class ProjectService {
	
	private final ProjectRepository projectRepository;
	private final UserRepository userRepository;
	
	public ProjectService(ProjectRepository projectRepository, UserRepository userRepository) {
		this.projectRepository = projectRepository;
		this.userRepository = userRepository;
	}
	
	public Page<Project> findAllByUser(Integer id, Integer page, Integer size) throws Exception {
		User isExists = this.userRepository.findById(id).orElse(null);
		
		if(isExists == null) {
			throw new Exception("Error");
		}
		
		
		return this.projectRepository.findAllByUser(id, page, size);
	}
 	
}

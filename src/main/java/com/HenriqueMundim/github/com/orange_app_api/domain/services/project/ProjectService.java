package com.HenriqueMundim.github.com.orange_app_api.domain.services.project;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Project;
import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.domain.errors.ResourceNotFoundException;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.CreateProjectDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.OutputProjectDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.UsersProjectDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.mapper.ProjectMapper;
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
	
	public Page<UsersProjectDTO> findAllByUser(Integer id, Integer page, Integer size) {
		User isExists = this.userRepository.findById(id).orElse(null);
		
		if(isExists == null) {
			throw new ResourceNotFoundException("User with this ID not found!");
		}
		
		Page<Project> result = this.projectRepository.findAllByUser(id, page, size);
		
		if (result.isEmpty()) {
			return null;
		}
		
		return result.map(ProjectMapper::toDomainWithoutUser);
	}
 	
	public OutputProjectDTO save(CreateProjectDTO projectDTO) {
		User author = this.userRepository.findById(projectDTO.getUserId()).orElse(null);
		
		if(author == null) {
			throw new ResourceNotFoundException("User with this ID not found!");
		}
		
		Project newProject = ProjectMapper.toEntity(projectDTO);
		newProject.setAuthor(author);
		
		return ProjectMapper.toDomainWithuser(this.projectRepository.save(newProject));
	}
}

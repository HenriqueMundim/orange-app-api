package com.HenriqueMundim.github.com.orange_app_api.domain.services.project;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Project;
import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.domain.errors.ResourceNotFoundException;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.CreateProjectDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.InputProjectDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.OutputProjectDTO;
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
	
	public Page<OutputProjectDTO> findAllByUser(Integer id, Integer page, Integer size) {
		User isExists = this.userRepository.findById(id).orElse(null);
		
		if(isExists == null) {
			throw new ResourceNotFoundException("User with this ID not found!");
		}
		
		Page<Project> result = this.projectRepository.findAllByUser(isExists, page, size);
		
		if (result.isEmpty()) {
			return null;
		}
		
		return result.map(ProjectMapper::toDomainWithuser);
	}
	
	public Page<OutputProjectDTO> findAllByUserAndCategory(Integer id, String category, Integer page, Integer size) {
		User isExists = this.userRepository.findById(id).orElse(null);
		
		if(isExists == null) {
			throw new ResourceNotFoundException("User with this ID not found!");
		}
		
		Page<Project> result = this.projectRepository.findAllByUserAndCategory(isExists, category, page, size);
		
		if (result.isEmpty()) {
			return null;
		}
		
		return result.map(ProjectMapper::toDomainWithuser);
	}
	
	public Page<OutputProjectDTO> findAllByCategory(String category, Integer page, Integer size) {

		Page<Project> result = this.projectRepository.findAllByCategory(category, page, size);
		
		if (result.isEmpty()) {
			return null;
		}
		
		return result.map(ProjectMapper::toDomainWithuser);
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
	
	public void delete(Integer id) {
		Project isExist = this.projectRepository.findById(id)
				.orElseThrow(() -> { 
					throw new ResourceNotFoundException("Project with this ID not found"); 
				});
		
		this.projectRepository.delete(isExist);
	}
	
	public OutputProjectDTO updateProject (InputProjectDTO project) {
		User user = this.userRepository.findById(project.getAuthor().getId())
				.orElseThrow(() -> { throw new ResourceNotFoundException("User with this ID not found!"); });
		
		this.projectRepository.findById(project.getId())
				.orElseThrow(() -> { throw new ResourceNotFoundException("Project with this ID not found!"); });
		
		return ProjectMapper.toDomainWithuser(this.projectRepository.update(ProjectMapper.toEntityWithId(project, user)));
	}
	
	public Page<OutputProjectDTO> findAll(Integer page, Integer size) {
		return this.projectRepository.findAll(page, size).map(ProjectMapper::toDomainWithuser);
	}
  
}

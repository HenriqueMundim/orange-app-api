package com.HenriqueMundim.github.com.orange_app_api.domain.services.project;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Category;
import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Project;
import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;
import com.HenriqueMundim.github.com.orange_app_api.domain.errors.ResourceNotFoundException;
import com.HenriqueMundim.github.com.orange_app_api.domain.services.category.CategoryService;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.CreateProjectDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.OutputProjectDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.dto.UsersProjectDTO;
import com.HenriqueMundim.github.com.orange_app_api.infra.mapper.ProjectMapper;
import com.HenriqueMundim.github.com.orange_app_api.infra.repositories.CategoryRepository;
import com.HenriqueMundim.github.com.orange_app_api.infra.repositories.ProjectRepository;
import com.HenriqueMundim.github.com.orange_app_api.infra.repositories.UserRepository;

@Service
public class ProjectService {
	
	private final ProjectRepository projectRepository;
	private final UserRepository userRepository;
	private final CategoryRepository categoryRepository;
	
	public ProjectService(ProjectRepository projectRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
		this.projectRepository = projectRepository;
		this.userRepository = userRepository;
		this.categoryRepository = categoryRepository;
	}
	
	public Page<UsersProjectDTO> findAllByUser(Integer id, Integer page, Integer size) {
		User isExists = this.userRepository.findById(id).orElse(null);
		
		if(isExists == null) {
			throw new ResourceNotFoundException("User with this ID not found!");
		}
		
		Page<Project> result = this.projectRepository.findAllByUser(isExists, page, size);
		
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
		for (Integer category_id : projectDTO.getCategories()) {
			Category category = 
		}
		
		return ProjectMapper.toDomainWithuser(this.projectRepository.save(newProject));
	}
}

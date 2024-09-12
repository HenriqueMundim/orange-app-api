package com.HenriqueMundim.github.com.orange_app_api.infra.daos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.HenriqueMundim.github.com.orange_app_api.domain.entities.Project;
import com.HenriqueMundim.github.com.orange_app_api.domain.entities.User;

@Repository
public interface ProjectDAO extends JpaRepository<Project, Integer> {
	
	@Query("SELECT pr FROM Project pr WHERE pr.author = ?1")
	Page<Project> findByUser(User user, Pageable pageable);
	
	@Query("SELECT pr FROM Project pr JOIN pr.categories c WHERE pr.author = :user AND LOWER(c.name) LIKE LOWER(CONCAT('%', :category, '%'))")
	Page<Project> findByUserAndCategory(User user, String category, Pageable pageable);
	
	@Query("SELECT pr FROM Project pr JOIN pr.categories c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :category, '%'))")
	Page<Project> findAllByCategory(String category, Pageable pageable);
}

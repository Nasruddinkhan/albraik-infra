package com.albraik.infra.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albraik.infra.project.model.ProjectTypeEntity;

@Repository
public interface ProjectTypeRepo extends JpaRepository<ProjectTypeEntity, String>{
	
	List<ProjectTypeEntity> findByIsActiveTrueOrderByOrderAsc();

}

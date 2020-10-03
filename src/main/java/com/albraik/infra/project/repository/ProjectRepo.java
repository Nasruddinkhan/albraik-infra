package com.albraik.infra.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albraik.infra.project.model.ProjectEntity;

@Repository
public interface ProjectRepo extends JpaRepository<ProjectEntity, Integer>{
	Page<ProjectEntity> findBycreatedBy(Integer userId, Pageable firstPageWithTwoElements);
}

package com.albraik.infra.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albraik.infra.project.model.ProjectDetailEntity;
@Repository
public interface ProjectDetailsRepo extends JpaRepository<ProjectDetailEntity, Integer> {

}

package com.albraik.infra.jobtitle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.albraik.infra.jobtitle.model.JobTitleEntity;

public interface JobtitleRepo extends JpaRepository<JobTitleEntity, Integer>{

	List<JobTitleEntity> findByCreatedBy(Integer userId);

}

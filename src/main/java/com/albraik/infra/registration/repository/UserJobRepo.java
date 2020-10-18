package com.albraik.infra.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albraik.infra.registration.model.UserJobEntity;

@Repository
public interface UserJobRepo extends JpaRepository<UserJobEntity, Integer>{

	UserJobEntity findByuserId(Integer userId);
	
}

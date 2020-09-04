package com.albraik.infra.registration.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albraik.infra.registration.model.UserEntity;

@Repository
public interface UserRepo  extends JpaRepository<UserEntity, Integer>{

	Optional<UserEntity> findByemail(String email);
	UserEntity findByEmail(String email);
}

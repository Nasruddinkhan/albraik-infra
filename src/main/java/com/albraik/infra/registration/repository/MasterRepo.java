package com.albraik.infra.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albraik.infra.registration.model.MasterEntity;

@Repository
public interface MasterRepo extends JpaRepository<MasterEntity, String> {

	List<MasterEntity> findByRole(String role);

}

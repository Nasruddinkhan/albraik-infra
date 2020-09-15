package com.albraik.infra.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albraik.infra.role.model.RoleEntity;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, Integer> {

	List<RoleEntity> findByCreatedBy(Integer createdBy);

}

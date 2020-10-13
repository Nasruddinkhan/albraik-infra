package com.albraik.infra.department.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albraik.infra.department.model.DepartmentEntity;

@Repository
public interface DepartmentRepo extends JpaRepository<DepartmentEntity, Integer> {

	List<DepartmentEntity> findByCreatedByAndIsActiveTrueAndIsDeletedFalse(Integer createdBy);
	DepartmentEntity findByCreatedByAndCompanyIdAndNameAndIsActiveTrueAndIsDeletedFalse(Integer userId, Integer companyId, String name);

}

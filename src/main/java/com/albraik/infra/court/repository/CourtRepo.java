package com.albraik.infra.court.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albraik.infra.court.model.CourtEntity;
import com.albraik.infra.role.model.RoleEntity;

@Repository
public interface CourtRepo extends JpaRepository<CourtEntity, Integer> {

	List<CourtEntity> findByCreatedBy(Integer createdBy);
	
	List<CourtEntity> findByCompanyId(Integer companyId);

}

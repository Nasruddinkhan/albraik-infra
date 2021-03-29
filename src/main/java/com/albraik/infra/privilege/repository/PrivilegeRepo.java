package com.albraik.infra.privilege.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albraik.infra.privilege.model.PrivilegeEntity;

@Repository
public interface PrivilegeRepo extends JpaRepository<PrivilegeEntity, String>{

}

package com.albraik.infra.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albraik.infra.role.model.RolePrivilegeEntity;

@Repository
public interface RolePrivilegeRepo extends JpaRepository<RolePrivilegeEntity, Integer> {

}

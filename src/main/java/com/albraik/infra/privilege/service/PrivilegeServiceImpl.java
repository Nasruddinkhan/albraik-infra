package com.albraik.infra.privilege.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.privilege.model.PrivilegeEntity;
import com.albraik.infra.privilege.repository.PrivilegeRepo;

@Service
@Transactional
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private PrivilegeRepo privilegeRepo;

	@Override
	public List<PrivilegeEntity> getAllPrivileges() {
		List<PrivilegeEntity> privileges = privilegeRepo.findAll();
		return privileges;
	}

}
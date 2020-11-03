package com.albraik.infra.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.contact.model.ContactTypeEntity;
import com.albraik.infra.contact.repository.ContactTypeRepo;

@Service
@Transactional
public class ContactTypeServiceImpl implements ContactTypeService {

	@Autowired
	private ContactTypeRepo contactTypeRepo;

	
	@Override
	public List<ContactTypeEntity> getAllContactType() {
		List<ContactTypeEntity> contactTypes = contactTypeRepo.findAll();
		return contactTypes;
	}


}

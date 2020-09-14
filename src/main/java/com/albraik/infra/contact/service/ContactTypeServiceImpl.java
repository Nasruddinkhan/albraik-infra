package com.albraik.infra.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.contact.dto.ContactDTO;
import com.albraik.infra.contact.model.ContactEntity;
import com.albraik.infra.contact.model.ContactTypeEntity;
import com.albraik.infra.contact.repository.ContactRepo;
import com.albraik.infra.contact.repository.ContactTypeRepo;
import com.albraik.infra.exception.PhoneNumberExistException;
import com.albraik.infra.exception.ResourceNotFoundException;
import com.albraik.infra.exception.UnauthorizedAccessException;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.repository.UserRepo;
import com.albraik.infra.util.ObjectUtilMapper;

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

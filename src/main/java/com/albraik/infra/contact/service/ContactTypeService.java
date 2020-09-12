package com.albraik.infra.contact.service;

import java.util.List;

import com.albraik.infra.contact.dto.ContactDTO;
import com.albraik.infra.contact.model.ContactEntity;
import com.albraik.infra.contact.model.ContactTypeEntity;
import com.albraik.infra.registration.model.UserEntity;

public interface ContactTypeService {
	
	List<ContactTypeEntity> getAllContactType();
	
}

package com.albraik.infra.contact.service;

import java.util.List;

import com.albraik.infra.contact.dto.ContactDTO;
import com.albraik.infra.contact.model.ContactEntity;
import com.albraik.infra.registration.model.UserEntity;

public interface ContactService {
	
	ContactEntity createContact(UserEntity userEntity, ContactDTO contactDTO);
	
	ContactEntity updateContact(UserEntity userEntity, ContactDTO contactDTO, Integer contactId);
	
	void deleteContact(UserEntity userEntity, Integer contactId);
	
	List<ContactEntity> getAllContacts(Integer companyId);
	
	List<ContactEntity> getUserContacts(UserEntity userDetails, Integer createdBy);
	
	ContactEntity getContactDetails(UserEntity userDetails, Integer contactId);
	
	List<ContactEntity> getContactsByType(Integer companyId, Integer contactType);
	
}

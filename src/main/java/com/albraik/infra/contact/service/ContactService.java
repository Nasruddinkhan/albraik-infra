package com.albraik.infra.contact.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.albraik.infra.contact.dto.ContactDTO;
<<<<<<< HEAD
import com.albraik.infra.contact.dto.UpdateContactDTO;
=======
import com.albraik.infra.contact.dto.ContactResponseDto;
import com.albraik.infra.contact.dto.ContactViewResponseDto;
>>>>>>> e6fc384... contact module complete
import com.albraik.infra.contact.model.ContactEntity;
import com.albraik.infra.registration.model.UserEntity;

public interface ContactService {
	
	ContactEntity createContact(UserEntity userEntity, ContactDTO contactDTO);
	
	ContactEntity updateContact(UserEntity userEntity, UpdateContactDTO contactDTO, Integer contactId);
	
	ContactEntity deleteContact(UserEntity userEntity, Integer contactId);
	
	List<ContactEntity> deleteMultipleContact(UserEntity userEntity, List<Integer> contactIdList);
	
	List<ContactEntity> getAllContacts(Integer companyId);
	
	List<ContactEntity> getUserContacts(UserEntity userDetails, Integer createdBy);
	
	ContactEntity getContactDetails(UserEntity userDetails, Integer contactId);
	
	List<ContactEntity> getContactsByType(Integer companyId, Integer contactType);

	Page<ContactResponseDto> getAllContacts(Integer companyId, String name, Integer concatid, Pageable contactPage);

	ContactViewResponseDto getContactDetails(Integer contactId);
	
}

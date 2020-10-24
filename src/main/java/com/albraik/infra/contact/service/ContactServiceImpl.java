package com.albraik.infra.contact.service;

import static com.albraik.infra.util.ObjectUtilMapper.mapAll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.contact.dto.ContactDTO;
import com.albraik.infra.contact.dto.UpdateContactDTO;
import com.albraik.infra.contact.model.ContactEntity;
import com.albraik.infra.contact.repository.ContactRepo;
import com.albraik.infra.exception.PhoneNumberExistException;
import com.albraik.infra.exception.ResourceNotFoundException;
import com.albraik.infra.exception.UnauthorizedAccessException;
import com.albraik.infra.jobtitle.dto.JobTitleResDTO;
import com.albraik.infra.jobtitle.model.JobTitleEntity;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.repository.UserRepo;
import com.albraik.infra.util.ObjectUtilMapper;

@Service
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepo contactRepo;

	private UserRepo userRepo;

	@Override
	public ContactEntity createContact(UserEntity userEntity, ContactDTO contactDTO) {
		// check if contact already exist
		if (isContactExist(contactDTO.getMobileNumber()))
			throw new PhoneNumberExistException("Contact already exists");

		// set contact details
		ContactEntity contactEntity = ObjectUtilMapper.map(contactDTO, ContactEntity.class);
		;
		long currentTime = System.currentTimeMillis();
		contactEntity.setCreatedBy(userEntity.getId());
		contactEntity.setCreatedTime(currentTime);
		contactEntity.setUpdatedTime(currentTime);
		contactEntity.setCompanyId(userEntity.getCompanyId());
		contactEntity.setIsDeleted(false);
		// save & return contact
		return contactRepo.save(contactEntity);
	}

	@Override
	public ContactEntity updateContact(UserEntity userEntity, UpdateContactDTO contactDTO, Integer contactId) {
		ContactEntity contactDetails = getContactDetails(userEntity, contactId);
		
		if (contactDetails.getCreatedBy() != userEntity.getId())
			throw new UnauthorizedAccessException("unauthorized access");
		
		if (!contactDetails.getMobileNumber().equals(contactDTO.getMobileNumber())
				&& isContactExist(contactDTO.getMobileNumber()))
			throw new PhoneNumberExistException("Contact already exists");

		ObjectUtilMapper.map(contactDTO, contactDetails);
		contactDetails.setUpdatedTime(System.currentTimeMillis());
		return contactRepo.save(contactDetails);
	}

	@Override
	public ContactEntity deleteContact(UserEntity userDetails, Integer contactId) {
		
		ContactEntity contactDetails = getContactDetails(userDetails, contactId);
		
		if(contactDetails == null)
			throw new ResourceNotFoundException("No Contact found");

		if (contactDetails.getCreatedBy() != userDetails.getId())
			throw new UnauthorizedAccessException("You don't have access to delete the Contact: " + contactDetails.getId());
		
		contactDetails.setIsDeleted(true);
		contactDetails.setUpdatedTime(System.currentTimeMillis());
		return contactRepo.save(contactDetails);
	}
	
	@Override
	public List<ContactEntity> deleteMultipleContact(UserEntity userEntity, List<Integer> contactIdList) {
		List<ContactEntity> contactList = contactRepo.findAllById(contactIdList);
		if(contactList.isEmpty())
			throw new ResourceNotFoundException("No Contact found");
		contactList.forEach(contact -> {
			if(userEntity.getId() != contact.getCreatedBy())
				throw new UnauthorizedAccessException("You don't have access to delete the Contact: " + contact.getId());
			contact.setIsDeleted(true);
			contact.setUpdatedTime(System.currentTimeMillis());
		});
		return contactRepo.saveAll(contactList);
	}

	@Override
	public List<ContactEntity> getAllContacts(Integer companyId) {
		List<ContactEntity> allContacts = contactRepo.findByCompanyIdAndIsDeletedIsFalse(companyId);
		return allContacts;
	}

	@Override
	public List<ContactEntity> getUserContacts(UserEntity userDetails, Integer createdBy) {
		
		if (userDetails.getId() != createdBy)
			throw new UnauthorizedAccessException("unauthorized access");
		
		List<ContactEntity> myContacts = contactRepo.findByCreatedByAndIsDeletedIsFalse(createdBy);
		return myContacts;
	}
	
	@Override
	public List<ContactEntity> getContactsByType(Integer companyId, Integer contactType) {
		return contactRepo.findByCompanyIdAndContactTypeIdAndIsDeletedIsFalse(companyId, contactType);
	}

	@Override
	public ContactEntity getContactDetails(UserEntity userDetails, Integer contactId) {
		
		ContactEntity contactDetails = contactRepo.findByIdAndIsDeletedIsFalse(contactId);
		if (contactDetails == null)
			throw new ResourceNotFoundException("contact not found");
		
		if (userDetails.getCompanyId() != contactDetails.getCompanyId())
			throw new UnauthorizedAccessException("unauthorized access");
		
		return contactDetails;
	}

	private boolean isContactExist(String mobileNumber) {
		ContactEntity contactEntity = contactRepo.findByMobileNumberAndIsDeletedIsFalse(mobileNumber);
		return contactEntity != null;
	}

}

package com.albraik.infra.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albraik.infra.contact.model.ContactEntity;

@Repository
public interface ContactRepo extends JpaRepository<ContactEntity, Integer>{

	ContactEntity findByMobileNumberAndIsDeletedIsFalse(String mobileNumber);
	
	List<ContactEntity> findByCompanyIdAndIsDeletedIsFalse(Integer companyId);
	
	List<ContactEntity> findByCreatedByAndIsDeletedIsFalse(Integer createdBy);
	
	ContactEntity findByIdAndIsDeletedIsFalse(Integer id);
	
}

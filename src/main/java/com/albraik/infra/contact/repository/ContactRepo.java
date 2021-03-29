package com.albraik.infra.contact.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.albraik.infra.contact.dto.ContactResponseDto;
import com.albraik.infra.contact.model.ContactEntity;

@Repository
public interface ContactRepo extends JpaRepository<ContactEntity, Integer>{

	ContactEntity findByMobileNumberAndIsDeletedIsFalse(String mobileNumber);
	
	List<ContactEntity> findByCompanyIdAndIsDeletedIsFalse(Integer companyId);
	
	List<ContactEntity> findByCreatedByAndIsDeletedIsFalse(Integer createdBy);
	
	ContactEntity findByIdAndIsDeletedIsFalse(Integer id);
	
	List<ContactEntity> findByCompanyIdAndContactTypeIdAndIsDeletedIsFalse(Integer companyId, Integer contactTypeId);

	@Query("select c.id, c.name, c.phoneNumber, c.faxNumber, c.email, c.address, c.comment, t.name"
			+ " from ContactEntity c "
			+ "	join ContactTypeEntity t  "
			+ "	on t.id =c.contactType.id "
			+ " and  c.companyId = :companyId"
			+ " and c.isDeleted = false")
	Page<Object[]> findByCompanyIdAndIsDeletedIsFalse(@Param("companyId")Integer companyId, 
			Pageable contactPage);

	@Query("select c.id, c.name, c.phoneNumber, c.faxNumber, c.email, c.address, c.comment, t.name "
			+ "	from ContactEntity c "
			+ "	join ContactTypeEntity t  "
			+ "	on t.id =c.contactType.id "
			+ " and  c.companyId = :companyId "
			+ " and t.id = :concatid"
			+ " and c.isDeleted = false")
	Page<Object[]> findByCompanyIdAndIsDeletedIsFalse(Integer companyId, Pageable contactPage,
			@Param("concatid")Integer concatid);
	@Query("select c.id, c.name, c.phoneNumber, c.faxNumber, c.email, c.address, c.comment, t.name "
			+ " from ContactEntity c "
			+ " join ContactTypeEntity t  "
			+ "	on t.id =c.contactType.id "
			+ " and  c.companyId = :companyId "
			+ " and t.id = :concatid"
			+ " and c.name = :name"
			+ " and c.isDeleted = false")
	Page<Object[]> findByCompanyIdAndIsDeletedIsFalse(Integer companyId, Pageable contactPage,
			@Param("concatid")Integer concatid, String name);

	@Query("select c.id, c.name, c.phoneNumber, c.faxNumber, c.email, c.address, c.comment, t.name"
			+ " from ContactEntity c "
			+ " join ContactTypeEntity t  "
			+ " on t.id =c.contactType.id "
			+ " and  c.companyId = :companyId "
			+ " and c.name = :name"
			+ " and c.isDeleted = false")
	Page<Object[]> findByCompanyIdAndIsDeletedIsFalse(Integer companyId, Pageable contactPage, String name);

	@Query("select c.id, c.name, c.phoneNumber, c.faxNumber, c.email, c.address, c.comment, t.name, "
			+ " u.firstName, u.email"
			+ "  from ContactEntity c "
			+ "	join ContactTypeEntity t "
			+ " on t.id = c.contactType.id "
			+ " join UserEntity u "
			+ " on u.id = c.createdBy"
			+ " and  c.id  = :contactId")
	List<Object[]> findBycontactId(Integer contactId);
	
}

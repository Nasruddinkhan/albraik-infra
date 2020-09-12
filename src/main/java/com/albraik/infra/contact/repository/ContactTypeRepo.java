package com.albraik.infra.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.albraik.infra.contact.model.ContactEntity;
import com.albraik.infra.contact.model.ContactTypeEntity;

@Repository
public interface ContactTypeRepo extends JpaRepository<ContactTypeEntity, Integer>{

}

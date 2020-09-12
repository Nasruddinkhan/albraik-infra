package com.albraik.infra.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albraik.infra.contact.model.ContactTypeEntity;
import com.albraik.infra.contact.service.ContactTypeService;

@RestController
@RequestMapping("/contact/type")
public class ContactTypeController {

	@Autowired
	private ContactTypeService contactTypeService;


	@GetMapping
	public ResponseEntity<List<ContactTypeEntity>> getAllContactTypes() {
		List<ContactTypeEntity> contactTypes = contactTypeService.getAllContactType();
		if (contactTypes.isEmpty())
			return new ResponseEntity<>(contactTypes, HttpStatus.NO_CONTENT);
		return ResponseEntity.ok(contactTypes);
	}

}

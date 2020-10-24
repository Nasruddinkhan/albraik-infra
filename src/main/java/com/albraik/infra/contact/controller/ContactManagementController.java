package com.albraik.infra.contact.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.albraik.infra.contact.dto.ContactDTO;
import com.albraik.infra.contact.dto.UpdateContactDTO;
import com.albraik.infra.contact.model.ContactEntity;
import com.albraik.infra.contact.service.ContactService;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.service.UserService;

@RestController
@RequestMapping("/api/contact")
public class ContactManagementController {

	@Autowired
	private UserService userService;

	@Autowired
	private ContactService contactService;

	@PostMapping
	public ResponseEntity<ContactEntity> createContact(@Validated @RequestBody ContactDTO contactDTO,
			Principal principal) {
		UserEntity userEntity = userService.getUserDetailsByEmail(principal.getName());
		ContactEntity contactEntity = contactService.createContact(userEntity, contactDTO);
		return ResponseEntity.ok(contactEntity);
	}

	@PutMapping("/{contactId}")
	public ResponseEntity<ContactEntity> updateContact(@Validated @RequestBody UpdateContactDTO contactDTO,
			@PathVariable Integer contactId, Principal principal) {
		UserEntity userDetails = userService.getUserDetailsByEmail(principal.getName());
		ContactEntity contactDetails = contactService.updateContact(userDetails, contactDTO, contactId);
		return ResponseEntity.ok(contactDetails);

	}

	@DeleteMapping("/{contactId}")
	public ResponseEntity<ContactEntity> deleteContact(@PathVariable Integer contactId, Principal principal) {
		UserEntity userDetails = userService.getUserDetailsByEmail(principal.getName());
		ContactEntity contact = contactService.deleteContact(userDetails, contactId);
		return ResponseEntity.ok(contact);
	}

	@DeleteMapping
	public ResponseEntity<List<ContactEntity>> deleteMultipleContact(@RequestParam("id") List<Integer> contactIdList,
			Principal principal) {
		UserEntity userDetails = userService.getUserDetailsByEmail(principal.getName());
		List<ContactEntity> deletedContactList = contactService.deleteMultipleContact(userDetails, contactIdList);
		return ResponseEntity.ok(deletedContactList);
	}

	@GetMapping
	public ResponseEntity<List<ContactEntity>> getAllContacts(Principal principal) {
		UserEntity userDetails = userService.getUserDetailsByEmail(principal.getName());
		List<ContactEntity> allContacts = contactService.getAllContacts(userDetails.getCompanyId());
		if (allContacts.isEmpty())
			return new ResponseEntity<>(allContacts, HttpStatus.NO_CONTENT);
		return ResponseEntity.ok(allContacts);
	}

	@GetMapping(params = { "createdBy" })
	public ResponseEntity<List<ContactEntity>> getMyContacts(@RequestParam Integer createdBy, Principal principal) {
		UserEntity userDetails = userService.getUserDetailsByEmail(principal.getName());
		List<ContactEntity> myContacts = contactService.getUserContacts(userDetails, createdBy);
		if (myContacts.isEmpty())
			return new ResponseEntity<>(myContacts, HttpStatus.NO_CONTENT);
		return ResponseEntity.ok(myContacts);
	}

	@GetMapping(params = { "contactTypeId" })
	public ResponseEntity<List<ContactEntity>> getContactsByType(@RequestParam Integer contactTypeId,
			Principal principal) {
		UserEntity userDetails = userService.getUserDetailsByEmail(principal.getName());
		List<ContactEntity> myContacts = contactService.getContactsByType(userDetails.getCompanyId(), contactTypeId);
		if (myContacts.isEmpty())
			return new ResponseEntity<>(myContacts, HttpStatus.NO_CONTENT);
		return ResponseEntity.ok(myContacts);
	}

	@GetMapping("/{contactId}")
	public ResponseEntity<ContactEntity> getContactDetails(Principal principal, @PathVariable Integer contactId) {
		UserEntity userDetails = userService.getUserDetailsByEmail(principal.getName());
		ContactEntity contactDetails = contactService.getContactDetails(userDetails, contactId);
		return ResponseEntity.ok(contactDetails);
	}

}

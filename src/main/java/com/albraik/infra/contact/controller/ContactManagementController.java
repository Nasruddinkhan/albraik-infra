package com.albraik.infra.contact.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import com.albraik.infra.contact.dto.ContactResponseDto;
import com.albraik.infra.contact.dto.ContactViewResponseDto;
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

	
	@GetMapping("/{contactId}/delete")
	public ResponseEntity<?> deleteContact(@PathVariable Integer contactId,
			Principal principal) {
		System.out.println("ContactManagementController.deleteContact()");
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
	@GetMapping("/{pageNo}/{concatid}/{name}/all")
	public ResponseEntity<Page<ContactResponseDto>> getAllContacts(@PathVariable Integer pageNo ,
			@PathVariable Integer concatid,
			@PathVariable String name,
			Principal principal) {
		UserEntity userDetails = userService.getUserDetailsByEmail(principal.getName());
		Pageable contactPage = PageRequest.of(pageNo - 1, 10, Sort.by("id").descending());
		Page<ContactResponseDto> allContacts = contactService.getAllContacts(userDetails.getCompanyId(), 
				 name, concatid,
				contactPage);
		if (allContacts.isEmpty())
			throw new RuntimeException("No record found");
		return ResponseEntity.ok(allContacts);
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
	
	@GetMapping("/{contactId}/view")
	public ResponseEntity<ContactViewResponseDto> getViewContactDetails(@PathVariable Integer contactId) {
		ContactViewResponseDto contactDetails = contactService.getContactDetails( contactId);
		return ResponseEntity.ok(contactDetails);
	}

}

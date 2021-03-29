package com.albraik.infra.court.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.albraik.infra.contact.model.ContactEntity;
import com.albraik.infra.court.dto.CourtDTO;
import com.albraik.infra.court.model.CourtEntity;
import com.albraik.infra.court.service.CourtService;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.service.UserService;
import com.albraik.infra.role.dto.RoleDTO;
import com.albraik.infra.role.dto.RoleResDTO;
import com.albraik.infra.role.service.RoleService;

@RestController
@RequestMapping("/api/court")
public class CourtController {

	@Autowired
	private CourtService courtService;

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<List<CourtEntity>> createCourt(@RequestBody List<CourtDTO> courtList, Principal principal) {

		UserEntity userEntity = userService.getUserDetailsByEmail(principal.getName());
		List<CourtEntity> courtEntityList = courtService.createCourt(courtList, userEntity);
		return new ResponseEntity<List<CourtEntity>>(courtEntityList, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<CourtEntity>> getCourtList(Principal principal) {
		UserEntity userEntity = userService.getUserDetailsByEmail(principal.getName());
		List<CourtEntity> courtEntityList = courtService.getCourtByCompanyId(userEntity.getCompanyId());
		return ResponseEntity.ok(courtEntityList);
	}
	
	@PutMapping("/{courtId}")
	public ResponseEntity<CourtEntity> updateCourt(@PathVariable Integer courtId, @RequestBody CourtDTO courtDTO, Principal principal)
	{
		UserEntity userEntity = userService.getUserDetailsByEmail(principal.getName());
		CourtEntity courtEntity = courtService.updateCourt(courtId, courtDTO, userEntity);
		return ResponseEntity.ok(courtEntity);
	}
	
	@DeleteMapping
	public ResponseEntity<List<CourtEntity>> deleteMultipleCourt(@RequestParam("id") List<Integer> courtIdList, Principal principal)
	{
		UserEntity userEntity = userService.getUserDetailsByEmail(principal.getName());
		List<CourtEntity> courtList = courtService.deleteCourt(courtIdList, userEntity);
		return ResponseEntity.ok(courtList);
	}
}

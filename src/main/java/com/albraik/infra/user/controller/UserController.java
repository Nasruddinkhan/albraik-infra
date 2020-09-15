package com.albraik.infra.user.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.service.UserService;
import com.albraik.infra.user.dto.UserDTO;
import com.albraik.infra.user.service.UserDetailService;
import com.albraik.infra.util.AppConstants;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserDTO>> getAllUsers(Principal principal) {
		UserEntity userEntity = userService.getUserDetailsByEmail(principal.getName());
		List<UserDTO> userList = userDetailService.getUsers(userEntity.getCompanyId(), AppConstants.ROLE_USER);
		if (userList.isEmpty())
			return new ResponseEntity<>(userList, HttpStatus.NO_CONTENT);
		return ResponseEntity.ok(userList);
	}

}

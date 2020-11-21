package com.albraik.infra.login.controller;

import static com.albraik.infra.util.ObjectUtilMapper.map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albraik.infra.privilege.repository.PrivilegeRepo;
import com.albraik.infra.registration.dto.LoginRequestDTO;
import com.albraik.infra.registration.dto.LoginResponseDTO;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.model.UserJobEntity;
import com.albraik.infra.registration.repository.UserRepo;
import com.albraik.infra.registration.service.UserJobService;
import com.albraik.infra.role.service.RoleService;
import com.albraik.infra.security.JwtUtil;

@RestController
@RequestMapping("/login")
public class LoginController {

	private JwtUtil jwtUtil;
	private AuthenticationManager authManager;
	private UserRepo userRepo;
	private RoleService roleService;
	private UserJobService userJobService;

	@Autowired
	public LoginController(final JwtUtil jwtUtil, final AuthenticationManager authManager, final UserRepo userRepo,
			final RoleService roleService, final UserJobService userJobService) {
		super();
		this.jwtUtil = jwtUtil;
		this.authManager = authManager;
		this.userRepo = userRepo;
		this.roleService = roleService;
		this.userJobService = userJobService;
	}

	@PostMapping(value = "/validateUser")
	public ResponseEntity<LoginResponseDTO> validate(@RequestBody LoginRequestDTO loginRequestDTO) {
		System.out.println("LoginController.validate() loginRequestDTO [" + loginRequestDTO + "]");
		authManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
		UserEntity userEntity = userRepo.findByEmail(loginRequestDTO.getUsername());
		LoginResponseDTO loginDto = map(userEntity, LoginResponseDTO.class);
		loginDto.setToken(jwtUtil.genrateToken(userEntity));
		try {
			UserJobEntity userJob = userJobService.getUserJobByUserId(userEntity.getId());
			loginDto.setRolePrivilegeDetails(roleService.getRoleWithPrivilegeByRoleId(userJob.getRole().getId()));
		} catch (Exception e) {
			// do nothing as job and role can still be null
		}
		return new ResponseEntity<>(loginDto, HttpStatus.OK);
	}
}

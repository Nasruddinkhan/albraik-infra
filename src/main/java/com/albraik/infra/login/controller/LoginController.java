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
import com.albraik.infra.registration.dto.LoginRequestDTO;
import com.albraik.infra.registration.dto.LoginResponseDTO;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.repository.UserRepo;
import com.albraik.infra.security.JwtUtil;

@RestController
@RequestMapping("/login")
public class LoginController {

	private JwtUtil jwtUtil;
	private AuthenticationManager authManager;
	private UserRepo userRepo;
	
	@Autowired
	public LoginController(final JwtUtil jwtUtil,final AuthenticationManager authManager, 
			final UserRepo userRepo) {
		super();
		this.jwtUtil = jwtUtil;
		this.authManager = authManager;
		this.userRepo = userRepo;
	}

	@PostMapping(value = "/validateUser")
	public ResponseEntity<LoginResponseDTO> validate(@RequestBody LoginRequestDTO loginRequestDTO){
		System.out.println("LoginController.validate() loginRequestDTO ["+loginRequestDTO+"]");
		authManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(), loginRequestDTO.getPassword()));
		UserEntity userEntity = userRepo.findByEmail(loginRequestDTO.getUsername());
		LoginResponseDTO loginDto = map(userEntity, LoginResponseDTO.class);
		loginDto.setToken(jwtUtil.genrateToken(userEntity));
		return new ResponseEntity<>(loginDto, HttpStatus.OK);
	}
}

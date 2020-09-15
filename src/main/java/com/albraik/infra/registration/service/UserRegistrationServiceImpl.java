package com.albraik.infra.registration.service;

import static com.albraik.infra.util.ObjectUtilMapper.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.exception.EmailExistsException;
import com.albraik.infra.registration.dto.UserRegisterRequestDTO;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.model.UserJobEntity;
import com.albraik.infra.registration.repository.UserJobRepo;
import com.albraik.infra.registration.repository.UserRepo;

@Service("userRegistrationService")
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService {
	
	private UserRepo usrRepo;
	private UserJobRepo userJobRepo;
	private BCryptPasswordEncoder bcryptPasswordEncode;
	
	
	@Autowired
	public UserRegistrationServiceImpl(final UserRepo usrRepo,
			final UserJobRepo userJobRepo,
			final BCryptPasswordEncoder bcryptPasswordEncode) {
		super();
		this.usrRepo = usrRepo;
		this.userJobRepo = userJobRepo;
		this.bcryptPasswordEncode = bcryptPasswordEncode;
	}

	@Override
	public UserRegisterRequestDTO createUser(UserRegisterRequestDTO userRegistrationRequestDTO, String plainPassword) {
		
		if (emailExist(userRegistrationRequestDTO.getEmail()))
			throw new EmailExistsException(
					"There is an account with that email address: " + userRegistrationRequestDTO.getEmail());
		UserEntity user = map(userRegistrationRequestDTO, UserEntity.class);
		user.setPassword(bcryptPasswordEncode.encode(plainPassword));
		user = usrRepo.save(user);
		UserJobEntity userJob = map(userRegistrationRequestDTO, UserJobEntity.class);
		userJob.setUserId(user.getId());
		userJobRepo.save(userJob);
		return userRegistrationRequestDTO;
	}

	private boolean emailExist(String email) {
		final UserEntity user = usrRepo.findByEmail(email);
		return user != null;
	}

}

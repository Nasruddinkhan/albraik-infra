package com.albraik.infra.registration.service;

import static com.albraik.infra.util.ObjectUtilMapper.map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.exception.EmailExistsException;
import com.albraik.infra.exception.UserNotFound;
import com.albraik.infra.registration.dto.AdminRegisterRequestDTO;
import com.albraik.infra.registration.dto.ChangePasswordRequestDTO;
import com.albraik.infra.registration.dto.ChangePasswordResponseDTO;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.repository.UserRepo;

@Service("adminRegistrationService")
@Transactional
public class AdminRegistrationServiceImpl implements AdminRegistrationService {
	// private BCryptPasswordEncoder bcryptPasswordEncode;
	private UserRepo usrRepo;
	private BCryptPasswordEncoder bcryptPasswordEncode;

	@Autowired
	public AdminRegistrationServiceImpl(final UserRepo usrRepo, final BCryptPasswordEncoder bcryptPasswordEncode) {
		super();
		this.usrRepo = usrRepo;
		this.bcryptPasswordEncode = bcryptPasswordEncode;
	}

	@Override
	public AdminRegisterRequestDTO save(AdminRegisterRequestDTO adRegisterRequestDTO) {
		if (emailExist(adRegisterRequestDTO.getEmail()))
			throw new EmailExistsException(
					"There is an account with that email address: " + adRegisterRequestDTO.getEmail());
		UserEntity user = map(adRegisterRequestDTO, UserEntity.class);
		user = usrRepo.save(user);
		user.setPassword(bcryptPasswordEncode.encode(adRegisterRequestDTO.getPassword()));
		return map(user, AdminRegisterRequestDTO.class);
		// TODO Auto-generated method stub
	}

	private boolean emailExist(String email) {
		final UserEntity user = usrRepo.findByEmail(email);
		return user != null;
	}

	@Override
	public ChangePasswordResponseDTO changePassword(ChangePasswordRequestDTO passwordRequestDTO) {
		// TODO Auto-generated method stub
		System.out.println(passwordRequestDTO);
		UserEntity userEntity = usrRepo.findById(passwordRequestDTO.getId())
				.orElseThrow(() ->	new UserNotFound("User Not found"));
		userEntity.setIsFtl(passwordRequestDTO.getIsFtl());
		userEntity.setPassword(bcryptPasswordEncode.encode(passwordRequestDTO.getPassword()));
		userEntity = usrRepo.save(userEntity);
		 return map(userEntity, ChangePasswordResponseDTO.class);
	}
}

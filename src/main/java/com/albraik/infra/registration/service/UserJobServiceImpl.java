package com.albraik.infra.registration.service;

import static com.albraik.infra.util.ObjectUtilMapper.map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.albraik.infra.exception.EmailExistsException;
import com.albraik.infra.exception.ResourceNotFoundException;
import com.albraik.infra.registration.dto.LoginResponseDTO;
import com.albraik.infra.registration.dto.UserRegisterRequestDTO;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.model.UserJobEntity;
import com.albraik.infra.registration.repository.UserJobRepo;
import com.albraik.infra.registration.repository.UserRepo;
import com.albraik.infra.util.AppConstants;

@Service("userJobService")
@Transactional
public class UserJobServiceImpl implements UserJobService {

	@Autowired
	private UserJobRepo userJobRepo;

	@Override
	public UserJobEntity getUserJobByUserId(Integer userId) {
		UserJobEntity userJob = userJobRepo.findByuserId(userId);
		if (userJob == null)
			throw new ResourceNotFoundException("No user-job found");
		return userJob;
	}

}

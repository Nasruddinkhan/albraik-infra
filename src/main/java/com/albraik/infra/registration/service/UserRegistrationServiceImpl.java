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

@Service("userRegistrationService")
@Transactional
public class UserRegistrationServiceImpl implements UserRegistrationService {

	private UserRepo usrRepo;
	private UserJobRepo userJobRepo;
	private BCryptPasswordEncoder bcryptPasswordEncode;

	@Autowired
	public UserRegistrationServiceImpl(final UserRepo usrRepo, final UserJobRepo userJobRepo,
			final BCryptPasswordEncoder bcryptPasswordEncode) {
		super();
		this.usrRepo = usrRepo;
		this.userJobRepo = userJobRepo;
		this.bcryptPasswordEncode = bcryptPasswordEncode;
	}
    public void checEmailExists(String email) {
    	if (emailExist(email))
			throw new EmailExistsException(
					"There is an account with that email address: " + email);
    }
	@Override
	public UserRegisterRequestDTO createUser(UserRegisterRequestDTO userRegistrationRequestDTO, String plainPassword) {
		checEmailExists(userRegistrationRequestDTO.getEmail());
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

	@Override
	public LoginResponseDTO getUserDetails(Integer userId) {
		// TODO Auto-generated method stub
		LoginResponseDTO resDto = map(findUser(userId), LoginResponseDTO.class);
		return setJobsAndRole(resDto, userId);
	}

	UserJobEntity findUserJobs(Integer userId) {
		return userJobRepo.findByuserId(userId);
	}

	private LoginResponseDTO setJobsAndRole(LoginResponseDTO resDto, Integer userId) {
		// TODO Auto-generated method stub
		if (AppConstants.ROLE_USER.equals(resDto.getRole())) {
			UserJobEntity userJobs = findUserJobs(userId);
			resDto.setJobId(userJobs.getJobTitleId());
			resDto.setDeptId(userJobs.getDepartmentId());
			resDto.setRoleId(userJobs.getRoleId());
			resDto.setJoiningDate(userJobs.getJoiningDate());
		}
		return resDto;
	}

	UserEntity findUser(Integer userId) {
		Optional<UserEntity> user = usrRepo.findById(userId);
		if (!user.isPresent())
			throw new ResourceNotFoundException("record not found");
		return user.get();
	}

	@Override
	public LoginResponseDTO updateUser(LoginResponseDTO logResponseDTO) {
		// TODO Auto-generated method stub
		UserEntity usr = setUserDetails(findUser(logResponseDTO.getId()), logResponseDTO);
		return map(usrRepo.save(usr), LoginResponseDTO.class);
	}

	private UserEntity setUserDetails(UserEntity user, LoginResponseDTO logResponseDTO) {
		// TODO Auto-generated method stub
		user.setFirstName(logResponseDTO.getFirstName());
		user.setFatherName(logResponseDTO.getFatherName());
		user.setGrandFatherName(logResponseDTO.getGrandFatherName());
		user.setFamilyName(logResponseDTO.getFamilyName());
		user.setPhoneNumber(logResponseDTO.getPhoneNumber());
		user.setDateOfBirth(logResponseDTO.getDateOfBirth());
		user.setPlaceOfBirth(logResponseDTO.getPlaceOfBirth());
		user.setMobileNumber(logResponseDTO.getMobileNumber());
		user.setEducation(logResponseDTO.getEducation());
		user.setSkills(logResponseDTO.getSkills());
		user.setNationality(logResponseDTO.getNationality());
		user.setExperience(logResponseDTO.getExperience());
		return user;

	}

	@Override
	public UserRegisterRequestDTO updateUser(UserRegisterRequestDTO userRegistrationRequestDTO) {
		// TODO Auto-generated method stub
		//checEmailExists(userRegistrationRequestDTO.getEmail());
		UserEntity userEntity = findUser(userRegistrationRequestDTO.getUserId());
		userEntity = setUserDetails(userRegistrationRequestDTO, userEntity);
		UserJobEntity userJobs = findUserJobs(userRegistrationRequestDTO.getUserId());
		if(userJobs == null)
				throw new RuntimeException("record not found");
		userJobs = setUserJobs(userJobs, userRegistrationRequestDTO );
		userEntity = usrRepo.save(userEntity);
		userJobs = userJobRepo.save(userJobs);
		return map(userJobs, UserRegisterRequestDTO.class);
	}

	private UserJobEntity setUserJobs(UserJobEntity userJobs, UserRegisterRequestDTO userRegistrationRequestDTO) {
		// TODO Auto-generated method stub
		userJobs.setDepartmentId(userRegistrationRequestDTO.getDepartmentId());
		userJobs.setJobTitleId(userRegistrationRequestDTO.getJobTitleId());
		userJobs.setJoiningDate(userRegistrationRequestDTO.getJoiningDate());
		userJobs.setRoleId(userJobs.getRoleId());
		userJobs.setUserId(userRegistrationRequestDTO.getUserId());
		return userJobs;
	}

	private UserEntity setUserDetails(UserRegisterRequestDTO userRegistrationRequestDTO, UserEntity userEntity) {
		userEntity.setEmail(userRegistrationRequestDTO.getEmail());
		userEntity.setPhoneNumber(userRegistrationRequestDTO.getPhoneNumber());
		return userEntity;
	}
	@Override
	public LoginResponseDTO deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		UserEntity usrEntity =  findUser(userId);
		usrEntity.setIsActive(false);
		return map(usrRepo.save(usrEntity), LoginResponseDTO.class);
	}
}

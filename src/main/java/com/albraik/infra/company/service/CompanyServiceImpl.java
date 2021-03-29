package com.albraik.infra.company.service;

import static com.albraik.infra.util.ObjectUtilMapper.map;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.company.dto.CompanyRequestDTO;
import com.albraik.infra.company.model.CompanyEntity;
import com.albraik.infra.company.repository.CompanyRepo;
import com.albraik.infra.exception.ResourceNotFoundException;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.repository.UserRepo;
import com.albraik.infra.registration.service.AWSS3Service;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepo companyRepo;
	private AWSS3Service awsS3service;
	private UserRepo usrRepo;
	
	@Value("${aws.s3.bucket}")
	private String bucketName;
	@Value("${aws.s3.endpointUrl}")
	private String endPointURL;
	public CompanyServiceImpl(final CompanyRepo companyRepo, final AWSS3Service  awsS3service,final UserRepo usrRepo) {
		super();
		this.companyRepo = companyRepo;
		this.awsS3service = awsS3service;
		this.usrRepo = usrRepo;
	}

	@Override
	public CompanyRequestDTO createCompany(CompanyRequestDTO companyRequestDTO) {
		// TODO Auto-generated method stub
		String logoURL = awsS3service.uploadFile(companyRequestDTO.getFile(), bucketName, endPointURL, companyRequestDTO.getCreatedBy());
		Optional.ofNullable(logoURL).orElseThrow(() -> new RuntimeException("Image is not upload in S3 buket"));
		companyRequestDTO.setCompanyLogo(logoURL);
		CompanyEntity comaEntity = map(companyRequestDTO, CompanyEntity.class);
		comaEntity = companyRepo.save(comaEntity);
		if(comaEntity != null) {
			UserEntity userEntity =	usrRepo.findById(companyRequestDTO.getCreatedBy()).get();
			userEntity.setCompanyId(comaEntity.getId());
			usrRepo.save(userEntity);
		}
		return map(comaEntity, CompanyRequestDTO.class);
	}

	@Override
	public CompanyRequestDTO findByCompany(Integer companyID) {
		// TODO Auto-generated method stub
		Optional<CompanyEntity> companyEntity =   companyRepo.findById(companyID);                             
		if(!companyEntity.isPresent())
			  throw new ResourceNotFoundException("company not registerd");
		return map(companyEntity.get(), CompanyRequestDTO.class);
	}
}

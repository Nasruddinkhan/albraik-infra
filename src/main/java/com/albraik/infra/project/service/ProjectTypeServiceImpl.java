package com.albraik.infra.project.service;

import static com.albraik.infra.util.CommonUtils.createDynamicImage;
import static com.albraik.infra.util.ObjectUtilMapper.map;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.albraik.infra.project.dto.ProjectDto;
import com.albraik.infra.project.model.ProjectEntity;
import com.albraik.infra.project.model.ProjectTypeEntity;
import com.albraik.infra.project.repository.ProjectRepo;
import com.albraik.infra.project.repository.ProjectTypeRepo;
import com.albraik.infra.registration.service.AWSS3Service;

@Service("projectTypeService")
@Transactional
public class ProjectTypeServiceImpl implements ProjectTypeService {
	@Value("${aws.s3.bucket}")
	private String bucketName;
	@Value("${aws.s3.endpointUrl}")
	private String endPointURL;
	private ProjectTypeRepo projectTypeRepo;
	private ProjectRepo projectRepo;
	private AWSS3Service awsS3service;
	@Autowired
	public ProjectTypeServiceImpl(final ProjectTypeRepo projectTypeRepo, final ProjectRepo projectRepo,final AWSS3Service awsS3service) {
		super();
		this.projectTypeRepo = projectTypeRepo;
		this.projectRepo = projectRepo;
		this.awsS3service = awsS3service;
	}

	@Override
	public List<ProjectTypeEntity> getAllProjectType() {
		List<ProjectTypeEntity> projectTypes = projectTypeRepo.findByIsActiveTrueOrderByOrderAsc();
		return projectTypes;
	}

	@Override
	public ProjectDto addProjectTask(ProjectDto projectDto) {
		// TODO Auto-generated method stub
		String logoURL = projectDto.getCaseLogo();
		if(null == projectDto.getCaseLogo() ) {
			logoURL = awsS3service.uploadFile(createDynamicImage(projectDto.getName()), bucketName, endPointURL);
						Optional.ofNullable(logoURL).orElseThrow(() -> new RuntimeException("Image is not upload in S3 buket"));
		}
		ProjectEntity projectEntity = map(projectDto, ProjectEntity.class);
		projectEntity.setCaseLogo(logoURL);
		projectEntity = projectRepo.save(projectEntity);
		return map(projectEntity, ProjectDto.class);
	}

}

package com.albraik.infra.project.service;

import static com.albraik.infra.util.CommonUtils.createDynamicImage;
import static com.albraik.infra.util.ObjectUtilMapper.map;
import static com.albraik.infra.util.ObjectUtilMapper.mapAll;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.project.dto.ProjectCaseDto;
import com.albraik.infra.project.dto.ProjectCompanyEstiblishmentDto;
import com.albraik.infra.project.dto.ProjectDeedCase;
import com.albraik.infra.project.dto.ProjectDto;
import com.albraik.infra.project.dto.ProjectInheritanceDto;
import com.albraik.infra.project.dto.ProjectVerdictDto;
import com.albraik.infra.project.model.ProjectDetailEntity;
import com.albraik.infra.project.model.ProjectEntity;
import com.albraik.infra.project.model.ProjectTypeEntity;
import com.albraik.infra.project.repository.ProjectDetailsRepo;
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
	private ProjectDetailsRepo projectDetailsRepo;
	private Environment env;

	@Autowired
	public ProjectTypeServiceImpl(final ProjectTypeRepo projectTypeRepo, final ProjectRepo projectRepo,
			final AWSS3Service awsS3service, final ProjectDetailsRepo projectDetailsRepo, final Environment env) {
		super();
		this.projectTypeRepo = projectTypeRepo;
		this.projectRepo = projectRepo;
		this.awsS3service = awsS3service;
		this.projectDetailsRepo = projectDetailsRepo;
		this.env = env;
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
		if (null == projectDto.getCaseLogo()) {
			logoURL = awsS3service.uploadFile(createDynamicImage(projectDto.getName(), env), bucketName, endPointURL);
			Optional.ofNullable(logoURL).orElseThrow(() -> new RuntimeException("Image is not upload in S3 buket"));
		}
		ProjectEntity projectEntity = map(projectDto, ProjectEntity.class);
		projectEntity.setCaseLogo(logoURL);
		projectEntity = projectRepo.save(projectEntity);
		return map(projectEntity, ProjectDto.class);
	}

	@Override
	public ProjectCaseDto addProjectTask(ProjectCaseDto projectCaseDto) {
		// TODO Auto-generated method stub
		ProjectDto project = addProjectTask(projectCaseDto.getProject());
		ProjectDetailEntity projectDetailEntity = map(projectCaseDto, ProjectDetailEntity.class);
		projectDetailEntity.setProjectId(project.getProjectId());
		projectDetailEntity = projectDetailsRepo.save(projectDetailEntity);
		projectCaseDto = map(projectDetailEntity, ProjectCaseDto.class);
		projectCaseDto.setProject(project);
		return projectCaseDto;
	}

	@Override
	public ProjectCompanyEstiblishmentDto addEstiblishmentCompanyCase(
			ProjectCompanyEstiblishmentDto companyEstiblishmentDto) {
		// TODO Auto-generated method stub
		ProjectDto project = addProjectTask(companyEstiblishmentDto.getProject());
		ProjectDetailEntity projectDetailEntity = map(companyEstiblishmentDto, ProjectDetailEntity.class);
		projectDetailEntity.setProjectId(project.getProjectId());
		projectDetailEntity = projectDetailsRepo.save(projectDetailEntity);
		companyEstiblishmentDto = map(projectDetailEntity, ProjectCompanyEstiblishmentDto.class);
		companyEstiblishmentDto.setProject(project);
		return companyEstiblishmentDto;
	}

	@Override
	public ProjectDeedCase addDeedCase(ProjectDeedCase projectDeedCase) {
		// TODO Auto-generated method stub
		ProjectDto project = addProjectTask(projectDeedCase.getProject());
		ProjectDetailEntity projectDetailEntity = map(projectDeedCase, ProjectDetailEntity.class);
		projectDetailEntity.setProjectId(project.getProjectId());
		projectDetailEntity = projectDetailsRepo.save(projectDetailEntity);
		projectDeedCase = map(projectDetailEntity, ProjectDeedCase.class);
		projectDeedCase.setProject(project);
		return projectDeedCase;
	}

	@Override
	public ProjectInheritanceDto addInheritanceCase(ProjectInheritanceDto inheritanceDto) {
		// TODO Auto-generated method stub
		ProjectDto project = addProjectTask(inheritanceDto.getProject());
		ProjectDetailEntity projectDetailEntity = map(inheritanceDto, ProjectDetailEntity.class);
		projectDetailEntity.setProjectId(project.getProjectId());
		projectDetailEntity = projectDetailsRepo.save(projectDetailEntity);
		inheritanceDto = map(projectDetailEntity, ProjectInheritanceDto.class);
		inheritanceDto.setProject(project);
		return inheritanceDto;
	}

	@Override
	public ProjectVerdictDto addVerditCase(ProjectVerdictDto projectVerdictDto) {
		// TODO Auto-generated method stub
		ProjectDto project = addProjectTask(projectVerdictDto.getProject());
		ProjectDetailEntity projectDetailEntity = map(projectVerdictDto, ProjectDetailEntity.class);
		projectDetailEntity.setProjectId(project.getProjectId());
		projectDetailEntity = projectDetailsRepo.save(projectDetailEntity);
		projectVerdictDto = map(projectDetailEntity, ProjectVerdictDto.class);
		projectVerdictDto.setProject(project);
		return projectVerdictDto;
	}

	@Override
	public List<ProjectDto> getAllCase(String projectType, Integer companyId) {
		// TODO Auto-generated method stub
		return mapAll(projectRepo.findByprojectTypeIdAndIsActiveTrueAndCompanyId(projectType, companyId),
				ProjectDto.class);
	}
}

package com.albraik.infra.jobtitle.service;

import static com.albraik.infra.util.ObjectUtilMapper.mapAll;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.court.model.CourtEntity;
import com.albraik.infra.exception.ResourceNotFoundException;
import com.albraik.infra.exception.UnauthorizedAccessException;
import com.albraik.infra.jobtitle.dto.JobTitleDTO;
import com.albraik.infra.jobtitle.dto.JobTitleReqDTO;
import com.albraik.infra.jobtitle.dto.JobTitleResDTO;
import com.albraik.infra.jobtitle.model.JobTitleEntity;
import com.albraik.infra.jobtitle.repository.JobtitleRepo;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.util.ObjectUtilMapper;
@Service("jobTitleService")
@Transactional
public class JobTitleServiceImpl implements JobTitleService {
	private JobtitleRepo jobtitleRepo;
	@Autowired
	public JobTitleServiceImpl(final JobtitleRepo jobtitleRepo) {
		super();
		this.jobtitleRepo = jobtitleRepo;
	}

	@Override
	public List<JobTitleResDTO> createJobTitle(JobTitleReqDTO jobTitleReqDTO) {
		// TODO Auto-generated method stub
		List<JobTitleEntity> jobsEntities = jobtitleRepo.saveAll(
				jobTitleReqDTO.getName().stream().map((Function<? super String, ? extends JobTitleEntity>) obj -> {
					JobTitleEntity jobs = new JobTitleEntity();
					jobs.setCompanyId(jobTitleReqDTO.getCompanyId());
					jobs.setCreatedBy(jobTitleReqDTO.getCreatedBy());
					jobs.setCreatedTime(jobTitleReqDTO.getCreatedTime());
					jobs.setUpdatedTime(jobTitleReqDTO.getUpdatedTime());
					jobs.setIsActive(true);
					jobs.setIsDeleted(false);
					jobs.setName(obj);
					return jobs;
				}).collect(Collectors.toList()));
		if (jobsEntities.isEmpty())
			throw new RuntimeException("Internal server error");
		return mapAll(jobsEntities, JobTitleResDTO.class);
	}

	@Override
	public List<JobTitleResDTO> findAll(Integer userId) {
		// TODO Auto-generated method stub
		List<JobTitleEntity> jobs = jobtitleRepo.findByCreatedByAndIsActiveTrueAndIsDeletedFalse(userId);
		if (jobs.isEmpty())
			throw new ResourceNotFoundException("no department found");
		return mapAll(jobs, JobTitleResDTO.class);
	}
	
	@Override
	public JobTitleResDTO updateJobTitle(Integer jobTitleId, JobTitleDTO jobTitleDTO, UserEntity user) {
		JobTitleEntity jobTitleEntity = jobtitleRepo.findById(jobTitleId).orElseThrow(() -> new ResourceNotFoundException("Job title not found"));
		Integer createdBy = jobTitleEntity.getCreatedBy();
		if(createdBy != user.getId())
			throw new UnauthorizedAccessException("you don't have access to modify the job title");
		jobTitleEntity.setName(jobTitleDTO.getName());
		jobTitleEntity.setUpdatedTime(System.currentTimeMillis());
		return ObjectUtilMapper.map(jobtitleRepo.save(jobTitleEntity), JobTitleResDTO.class);
	}
	
	@Override
	public List<JobTitleResDTO> deleteJobTitle(List<Integer> jobTitleIdList, UserEntity user) {
		List<JobTitleEntity> jobTitleList = jobtitleRepo.findAllById(jobTitleIdList);
		if(jobTitleList.isEmpty())
			throw new ResourceNotFoundException("No job title found");
		jobTitleList.forEach(jobTitle -> {
			if(user.getId() != jobTitle.getCreatedBy())
				throw new UnauthorizedAccessException("You don't have access to delete the job title");
			jobTitle.setIsDeleted(true);
			jobTitle.setIsActive(false);
			jobTitle.setUpdatedTime(System.currentTimeMillis());
		});
		return mapAll(jobtitleRepo.saveAll(jobTitleList), JobTitleResDTO.class);
	}

	@Override
	public List<JobTitleResDTO> findAllJobtitle(Integer companyID) {
		// TODO Auto-generated method stub
		List<JobTitleEntity> jobs =  jobtitleRepo.findByCompanyId(companyID);
		if (jobs.isEmpty())
			throw new ResourceNotFoundException("no department found");
		return  mapAll(jobs, JobTitleResDTO.class);
	}

}

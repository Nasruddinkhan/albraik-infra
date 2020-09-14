package com.albraik.infra.jobtitle.service;

import static com.albraik.infra.util.ObjectUtilMapper.mapAll;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.exception.ResourceNotFoundException;
import com.albraik.infra.jobtitle.dto.JobTitleReqDTO;
import com.albraik.infra.jobtitle.dto.JobTitleResDTO;
import com.albraik.infra.jobtitle.model.JobTitleEntity;
import com.albraik.infra.jobtitle.repository.JobtitleRepo;
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
		List<JobTitleEntity> jobs = jobtitleRepo.findByCreatedBy(userId);
		if (jobs.isEmpty())
			throw new ResourceNotFoundException("no department found");
		return mapAll(jobs, JobTitleResDTO.class);
	}

}

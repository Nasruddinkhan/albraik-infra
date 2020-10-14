package com.albraik.infra.jobtitle.service;

import java.util.List;

import com.albraik.infra.jobtitle.dto.JobTitleDTO;
import com.albraik.infra.jobtitle.dto.JobTitleReqDTO;
import com.albraik.infra.jobtitle.dto.JobTitleResDTO;
import com.albraik.infra.registration.model.UserEntity;

public interface JobTitleService {

	List<JobTitleResDTO> createJobTitle(JobTitleReqDTO jobTitleReqDTO);

	List<JobTitleResDTO> findAll(Integer userId);

	JobTitleResDTO updateJobTitle(Integer jobTitleId, JobTitleDTO jobTitleReqDTO, UserEntity user);

	List<JobTitleResDTO> deleteJobTitle(List<Integer> jobTitleIdList, UserEntity user);

}

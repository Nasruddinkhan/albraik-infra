package com.albraik.infra.jobtitle.service;

import java.util.List;

import com.albraik.infra.jobtitle.dto.JobTitleReqDTO;
import com.albraik.infra.jobtitle.dto.JobTitleResDTO;

public interface JobTitleService {

	List<JobTitleResDTO> createJobTitle(JobTitleReqDTO jobTitleReqDTO);

	List<JobTitleResDTO> findAll(Integer userId);

}

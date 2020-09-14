package com.albraik.infra.company.service;

import com.albraik.infra.company.dto.CompanyRequestDTO;

public interface CompanyService {
	CompanyRequestDTO createCompany(CompanyRequestDTO companyRequestDTO);
	CompanyRequestDTO findByCompany(Integer companyID);

}

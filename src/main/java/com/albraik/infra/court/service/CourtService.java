package com.albraik.infra.court.service;

import java.util.List;

import com.albraik.infra.court.dto.CourtDTO;
import com.albraik.infra.court.model.CourtEntity;
import com.albraik.infra.registration.model.UserEntity;

public interface CourtService {

	List<CourtEntity> getCourtByCompanyId(Integer companyId);
	
	List<CourtEntity> createCourt(List<CourtDTO> courtList, UserEntity user);
	
	CourtEntity updateCourt(Integer courtId, CourtDTO courtDTO, UserEntity user);
	
	List<CourtEntity> deleteCourt(List<Integer> courtIdList, UserEntity user);
}

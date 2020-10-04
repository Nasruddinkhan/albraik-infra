package com.albraik.infra.court.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.court.dto.CourtDTO;
import com.albraik.infra.court.model.CourtEntity;
import com.albraik.infra.court.repository.CourtRepo;
import com.albraik.infra.registration.model.UserEntity;

@Service("courtService")
@Transactional
public class CourtServiceImpl implements CourtService {

	@Autowired
	private CourtRepo courtRepo;
	
	
	@Override
	public List<CourtEntity> getCourtByCompanyId(Integer companyId) {
		
		return courtRepo.findByCompanyId(companyId);
	}
	
	@Override
	public List<CourtEntity> createCourt(List<CourtDTO> courtList, UserEntity user) {
		List<CourtEntity> courtEntityList = new ArrayList<>();
		if(courtList == null || courtList.isEmpty())
			return courtEntityList;
		for(CourtDTO courtDTO : courtList)
		{
			long currentTime = System.currentTimeMillis();
			CourtEntity courtEntity = new CourtEntity(courtDTO.getName(), user.getCompanyId(), currentTime, currentTime, user.getId());
			courtEntityList.add(courtEntity);
		}
		return courtRepo.saveAll(courtEntityList);
	}
	
}

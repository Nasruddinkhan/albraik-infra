package com.albraik.infra.court.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.albraik.infra.court.dto.CourtDTO;
import com.albraik.infra.court.model.CourtEntity;
import com.albraik.infra.court.repository.CourtRepo;
import com.albraik.infra.exception.ResourceNotFoundException;
import com.albraik.infra.exception.UnauthorizedAccessException;
import com.albraik.infra.registration.model.UserEntity;

@Service("courtService")
@Transactional
public class CourtServiceImpl implements CourtService {

	@Autowired
	private CourtRepo courtRepo;
	
	
	@Override
	public List<CourtEntity> getCourtByCompanyId(Integer companyId) {
		
		return courtRepo.findByCompanyIdAndIsActiveTrueAndIsDeletedFalse(companyId);
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
	
	@Override
	public CourtEntity updateCourt(Integer courtId, CourtDTO courtDTO, UserEntity user) {
		CourtEntity courtEntity = courtRepo.findById(courtId).orElseThrow(() -> new ResourceNotFoundException("Court not found"));
		Integer createdBy = courtEntity.getCreatedBy();
		if(createdBy != user.getId())
			throw new UnauthorizedAccessException("you don't have access to modify the court");
		courtEntity.setName(courtDTO.getName());
		courtEntity.setUpdatedTime(System.currentTimeMillis());
		courtRepo.save(courtEntity);
		return courtEntity;
	}
	
	@Override
	public List<CourtEntity> deleteCourt(List<Integer> courtIdList, UserEntity user) {
		List<CourtEntity> courtList = courtRepo.findAllById(courtIdList);
		if(courtList.isEmpty())
			throw new ResourceNotFoundException("No court found");
		courtList.forEach(court -> {
			if(user.getId() != court.getCreatedBy())
				throw new UnauthorizedAccessException("You don't have access to delete the court");
			court.setIsDeleted(true);
			court.setIsActive(false);
			court.setUpdatedTime(System.currentTimeMillis());
		});
		return courtRepo.saveAll(courtList);
	}
	
}

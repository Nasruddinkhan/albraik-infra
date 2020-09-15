package com.albraik.infra.registration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.user.dto.UserDTO;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findByemail(String email);
	UserEntity findByEmail(String email);
	
	@Query("SELECT new com.albraik.infra.user.dto.UserDTO(um.id as id, um.firstName as name, um.email as email, uj.joiningDate as joiningDate) " +
			"FROM UserEntity um " + 
			"INNER JOIN UserJobEntity uj " + 
			"ON um.id = uj.id " + 
			"WHERE um.companyId = :companyId " + 
			"AND um.role = :role " + 
			"AND um.isActive = 1")
	List<UserDTO> findAllByCompanyIdAndRole(@Param("companyId")Integer companyId,
			@Param("role") String role);
	
	

}

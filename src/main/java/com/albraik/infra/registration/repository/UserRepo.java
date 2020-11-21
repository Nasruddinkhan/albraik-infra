package com.albraik.infra.registration.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.user.dto.UserDTO;
import com.albraik.infra.user.dto.UserJobDTO;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	Optional<UserEntity> findByemail(String email);

	UserEntity findByEmail(String email);

	@Query("select new com.albraik.infra.user.dto.UserDTO(u.id as id, u.phoneNumber as name, u.email as email, j.joiningDate as joiningDate)"
			+ " from UserEntity u, UserJobEntity j, JobTitleEntity t "
			+ " where	(j.user.id = u.id and j.jobTitle.id = t.id) "
			+ "  and	u.role =:role and u.companyId = :companyId "
			+ "  and u.isActive=1 and t.name=:name" )
	List<UserDTO> getUserJobtitle(@Param("companyId") Integer companyId,
			@Param("name") String name,
			@Param("role") String roleUser);
	
	List<UserEntity> findAllByCompanyIdAndRole(
			@Param("companyId") Integer companyId,
			@Param("role") String role);

}

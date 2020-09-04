package com.albraik.infra.registration.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.albraik.infra.registration.dto.MyUserDetails;
import com.albraik.infra.registration.model.UserEntity;
import com.albraik.infra.registration.repository.UserRepo;

@Service("userDetailsService")
public class UserServiceDetails implements UserDetailsService {
	private UserRepo usrRepo;
	
	public UserServiceDetails(final UserRepo usrRepo) {
		super();
		this.usrRepo = usrRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserEntity> users=	usrRepo.findByemail(username);
		users.orElseThrow(()->
		new  UsernameNotFoundException(username+" :: is not found"));
		return  users.map(MyUserDetails::new).get();
	}

}

package com.albraik.infra.registration.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.albraik.infra.registration.model.UserEntity;

public class MyUserDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8625815992842803477L;
	private Collection<? extends GrantedAuthority> authorities;
	private String username;
	private String password;
	private Boolean isEnabled;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	public MyUserDetails(UserEntity user) {
		super();
		List<GrantedAuthority> grantedAuths  = new ArrayList<GrantedAuthority>();
		grantedAuths.add((GrantedAuthority) new SimpleGrantedAuthority(user.getRole()));
		this.authorities =grantedAuths;
		this.username = user.getEmail();
		this.password=user.getPassword();
		this.isEnabled = user.getIsActive();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return isEnabled;
	}

}

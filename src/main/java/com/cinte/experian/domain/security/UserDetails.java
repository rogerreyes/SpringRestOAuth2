package com.cinte.experian.domain.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class UserDetails implements org.springframework.security.core.userdetails.UserDetails{
	
    private  Long id;
    private  String username;
    private  String firstname;
    private  String password;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	public UserDetails(){}
	
	public UserDetails(Long id, String username, String firstname, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.password = password;
		this.authorities = authorities;
	}

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}








}

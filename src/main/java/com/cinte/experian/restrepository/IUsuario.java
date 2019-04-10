package com.cinte.experian.restrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cinte.experian.domain.security.User;


public interface IUsuario extends JpaRepository<User, Long> {
	
	
	User findByUsername(String username);
	
	
}

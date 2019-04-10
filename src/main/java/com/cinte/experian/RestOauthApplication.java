package com.cinte.experian;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cinte.experian.domain.security.Authority;
import com.cinte.experian.domain.security.AuthorityName;
import com.cinte.experian.domain.security.User;
import com.cinte.experian.restrepository.IUsuario;


@SpringBootApplication
@EnableJpaRepositories(basePackages= "com.cinte.experian")
public class RestOauthApplication implements CommandLineRunner{
	
	@Autowired
	private IUsuario repositorioUSuario;
	
	  @Autowired
	    private PasswordEncoder passwordEncoder;    
	

	public static void main(String[] args) {
		SpringApplication.run(RestOauthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		Authority authUsuario = new Authority(1L, AuthorityName.ROLE_USER);
		Authority authAdmin = new Authority(2L, AuthorityName.ROLE_ADMIN);
		
//		
		User usuario = new User(null, "user", passwordEncoder.encode("user"),"userName","userLastName", "user@user.com",true, Arrays.asList(authUsuario));
		repositorioUSuario.save(usuario);
//		
		User administrador = new User(null, "admin", passwordEncoder.encode("admin"),"adminName","adminLastName", "admin@admin.com",true, Arrays.asList(authUsuario, authAdmin));
		repositorioUSuario.save(administrador);
//		
	}
	
	
	
	 @Bean
	    public PasswordEncoder getPasswordEncoder(){
	        return new BCryptPasswordEncoder();
	    } 

	
	
}

package com.cinte.experian.securityconfig;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import com.cinte.experian.domain.security.User;
import com.cinte.experian.restrepository.IUsuario;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    
    @Autowired
    private IUsuario repositorioUsuario;
	
    @Autowired
    private PasswordEncoder passwordEncoder;    
        
    @Autowired
    public void configureGlobal( AuthenticationManagerBuilder auth) throws Exception {

    	auth.userDetailsService(new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				User user = repositorioUsuario.findByUsername(username);

		        if (user == null) {
		            throw new UsernameNotFoundException(String.format("No se encuentra el usuario con el nombre '%s'.", username));
		        } else {
		        List<GrantedAuthority> listado = user.getAuthorities().stream().map(authority-> new SimpleGrantedAuthority(authority.getName().name())).collect(Collectors.toList());
		            return new com.cinte.experian.domain.security.UserDetails(user.getId(),user.getUsername(), user.getFirstname(), user.getPassword(), listado);
		        }
			}
		}).passwordEncoder(passwordEncoder);
    	
    	
//    	auth.inMemoryAuthentication().passwordEncoder(passwordEncoder).
//    	withUser("user").password("password").roles("USER").and()
//    	.withUser("admin").password("admin").roles("USER","ADMIN");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api").permitAll().antMatchers("/api/").permitAll().antMatchers("/oauth/token").permitAll()
                .anyRequest().authenticated()
                .and()
            .httpBasic()
                .and()
            .csrf().disable();
    }
    

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }    

}

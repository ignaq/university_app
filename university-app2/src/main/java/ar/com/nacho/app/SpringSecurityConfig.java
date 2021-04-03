package ar.com.nacho.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ar.com.nacho.app.models.service.JpaUserDetailsService;




@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	

	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers( "/layout/**").permitAll()
		
		.antMatchers("/listar", "/").hasRole("USER")
		.antMatchers("/descripcion").hasRole("USER")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login")
		.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
		
	}




	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
		
		PasswordEncoder encoder = this.passwordEncoder;
		builder.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
		
	}
	
}

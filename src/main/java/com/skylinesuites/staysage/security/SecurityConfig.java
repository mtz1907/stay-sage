/*package com.skylinesuites.staysage.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService userDetailsService() {

        PasswordEncoder encoder = passwordEncoder();

        UserDetails user = User.builder().passwordEncoder(encoder::encode)
                .username("usuario")
                .password("1234")
                .roles("USER")
                .build();
        UserDetails admin = User.builder().passwordEncoder(encoder::encode)
                .username("administrador")
                .password("1234")
                .roles("ADMIN", "USER")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        try {
            http.httpBasic(AbstractHttpConfigurer::disable);
            http.csrf(AbstractHttpConfigurer::disable);
            http.authorizeHttpRequests(auth -> auth
                    .requestMatchers("/",
                            "/ingresar",
                            "/imagenes/**",
                            "/videos/**",
                            "/css/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
            );
            // Modificamos el usuario y contraseña por defecto de Spring Security
            // Solo cambiamos el usuario y la contraseña pero dejamos el formulario de login por defecto de spring security
            http.formLogin(login -> login
                    .loginPage("/ingresar")
                    .permitAll()
                    .defaultSuccessUrl("/inicio", true)
                    .failureUrl("/ingresar?error=true")
            );
            return http.build();
        } catch (Exception e) {
            e.fillInStackTrace();
            throw e;
        }
    }
}
/*
 *@Bean
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Bean
 	public UserDetailsService userDetailsService() {

		PasswordEncoder encoder = passwordEncoder();

 		UserDetails user = User.builder().passwordEncoder(encoder::encode)
 			.username("user")
 			.password("1234")
 			.roles("USER")
 			.build();
 		UserDetails admin = User.builder().passwordEncoder(encoder::encode)
 			.username("admin")
 			.password("1234")
 			.roles("ADMIN", "USER")
 			.build();
 		return new InMemoryUserDetailsManager(user, admin);
 	}

	@Bean
 	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
 		http
 		.authorizeRequests()
 		.antMatchers("/css/**","/js/**","/images/**","/h2-console/**").permitAll()
 		.anyRequest().hasRole("USER")
 		.and()
 		.formLogin().loginPage("/login").permitAll()
 		.and()
 		.logout().permitAll();

 		//************* USED FOR ACCESSING THE H2 CONSOLE WITH SPRING SECURITY
 		//************* REMOVE IN PRODUCTION!
 		http.csrf().disable();
 		http.headers().frameOptions().disable();
 		//*************

 		return http.build();
 	}
 */

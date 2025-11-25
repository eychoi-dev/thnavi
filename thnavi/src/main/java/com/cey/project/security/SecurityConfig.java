//package com.cey.project.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.firewall.HttpFirewall;
//import org.springframework.security.web.firewall.StrictHttpFirewall;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//	
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//		httpSecurity.csrf(csrf -> csrf.disable())
//		            .authorizeHttpRequests(auth -> auth.requestMatchers(
//		            									"/", 	//사용자 메인으로 호출 시에는 로그인 없이 접근
//		            									"/login").permitAll()
//		                                               .anyRequest().authenticated() //로그인 페이지와 기타 css, js, images 는 로그인 없이도 접근 가능
//		            )
//					.formLogin(formLogin -> formLogin.loginPage("/login") // 로그인 JSP 호출
//							                         .loginProcessingUrl("/user/loginAction") //실제 로그인 요청을 받는 url
//							 						 .usernameParameter("userId")
//							 						 .passwordParameter("userPw")
//							 						 .defaultSuccessUrl("/admin", true)
//							 						 .failureUrl("/loginError")
//													 .permitAll()
//					)
////					.logout(logout -> logout.logoutUrl("/logout")
////					                        .logoutSuccessUrl("/main/adminMain")
////					                        .invalidateHttpSession(true)
////					)
//		;
//		return httpSecurity.build();
//	}
//	
//	@Bean
//	public HttpFirewall httpFirewall() {
//		StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
//		//요청 url에 // 더블 슬래시 요청을 true로 변경
//		strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
//		
//		return strictHttpFirewall;
//	}
//}

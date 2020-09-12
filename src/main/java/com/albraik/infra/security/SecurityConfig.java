package com.albraik.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.albraik.infra.registration.service.UserServiceDetails;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private BCryptPasswordEncoder byCrptPass;
	private UserServiceDetails userDetailsService;
	private JwtRequestFilter jwtRequestFilter;
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	private Environment env;
	@Autowired
	public SecurityConfig(final BCryptPasswordEncoder byCrptPass,
			final UserServiceDetails userDetailsService,
			final JwtRequestFilter JwtRequestFilte,final JwtAuthenticationEntryPoint unauthorizedHandler,final Environment env) {
		super();
		this.byCrptPass = byCrptPass;
		this.userDetailsService = userDetailsService;
		this.jwtRequestFilter = JwtRequestFilte;
		this.unauthorizedHandler = unauthorizedHandler;
		this.env = env;
	}

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(byCrptPass);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(env.getProperty("sign.in.url"),env.getProperty("web.jars") , env.getProperty("sign.up.urls") )
		.permitAll()
		.anyRequest()
		.fullyAuthenticated()
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(unauthorizedHandler)
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		http.cors();
	}
	
	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin(env.getProperty("allow.orgins"));
        config.addAllowedHeader(env.getProperty("allow.header"));
        config.addAllowedMethod(HttpMethod.OPTIONS);
        config.addAllowedMethod(HttpMethod.GET);
        config.addAllowedMethod(HttpMethod.POST);
        config.addAllowedMethod(HttpMethod.PUT);
        source.registerCorsConfiguration(env.getProperty("reg.cor.conf"), config);
        return new CorsFilter(source);
    }
}

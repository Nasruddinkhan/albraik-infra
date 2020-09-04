package com.albraik.infra.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.albraik.infra.registration.service.UserServiceDetails;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	private UserServiceDetails userServiceDetails;
	private JwtUtil jwtUtil;
	private Environment env;
	@Autowired
	public JwtRequestFilter(final UserServiceDetails userServiceDetails,final JwtUtil jwtUtil, final Environment env) {
		super();
		this.userServiceDetails = userServiceDetails;
		this.jwtUtil = jwtUtil;
		this.env= env;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String authorization=	request.getHeader(env.getProperty("auth.header"));
		String 	userName = null;
		String jwtToken = null;
		if(authorization != null && authorization.startsWith(env.getProperty("token.key"))) {
			jwtToken = authorization.substring(8);
			userName = jwtUtil.extractUserName(jwtToken);
		}
		if(userName !=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails  =this.userServiceDetails.loadUserByUsername(userName);
			if(jwtUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken passwordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				passwordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(passwordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}

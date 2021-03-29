package com.albraik.infra.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.albraik.infra.registration.model.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	public Environment env;
	
	public JwtUtil( final Environment env) {
		super();
		this.env = env;
	}
	public String extractUserName(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	public <T> T extractClaim(String token, Function<Claims, T> claim) {
		// TODO Auto-generated method stub
		final Claims claims = extractAllClaims(token);
		return claim.apply(claims);
	}
	public Claims extractAllClaims(String token) {
		// TODO Auto-generated method stub
		return Jwts.parser().setSigningKey(env.getProperty("secret.key")).parseClaimsJws(token).getBody();
	}
	public String genrateToken(UserEntity userDetails) {
		Map<String, Object> claim= new HashMap<>();
		return createToken(claim, userDetails.getEmail());
		
	}
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());         
	}
	private Date extractExpiration(String token) {
		// TODO Auto-generated method stub
		return extractClaim(token, Claims::getExpiration);
	}
	private String createToken(Map<String, Object> claim, String username) {
		// TODO Auto-generated method stub
		return 	Jwts.builder()
				.setClaims(claim)
				.setSubject(username)
				.setIssuedAt(new  Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000 * 60 * 60 *10))
				.signWith(SignatureAlgorithm.HS256, env.getProperty("secret.key"))
				.compact();
	}
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String userName = extractUserName(token);
		return ( userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}

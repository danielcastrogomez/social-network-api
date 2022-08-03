
package org.casdan.socialnetworkbackend.config;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.casdan.socialnetworkbackend.dto.CredentialsDto;
import org.casdan.socialnetworkbackend.dto.UserDto;
import org.casdan.socialnetworkbackend.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Configuration
public class UserAuthenticationProvider {
	
	@Value("${security.jwt.token.secret-key}")
	private String secretKey;
	
	
	private final AuthenticationService authenticationService;
	

	public UserAuthenticationProvider(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	
	public String createToken(String login) {
		
		Claims claims = Jwts.claims().setSubject(login);
		
		Date now = new Date();
		Date validUntil = new Date(now.getTime() + 3600000);
		
		
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(validUntil)
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}
	
	
	public Authentication validateCredentials(CredentialsDto credentialsDto) {
		UserDto userDto = authenticationService.authenticate(credentialsDto);
		
		return new UsernamePasswordAuthenticationToken(userDto,
				null,
				Collections.emptyList());
	}

	public Authentication validateToken(String token) {
		String login = Jwts.parser()
		.setSigningKey(secretKey)
		.parseClaimsJws(token)
		.getBody()
		.getSubject();
		
		
		UserDto userDto = authenticationService.findByLogin(login);
		
		return new UsernamePasswordAuthenticationToken(userDto,
				null,
				Collections.emptyList());
	}
	
	
	
	

}

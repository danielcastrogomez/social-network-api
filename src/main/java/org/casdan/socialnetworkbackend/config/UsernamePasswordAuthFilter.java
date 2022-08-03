package org.casdan.socialnetworkbackend.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.casdan.socialnetworkbackend.dto.CredentialsDto;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UsernamePasswordAuthFilter extends OncePerRequestFilter{
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	private final UserAuthenticationProvider userAuthenticationProvider;
	
	
	public UsernamePasswordAuthFilter(UserAuthenticationProvider userAuthenticationProvider) {
		this.userAuthenticationProvider = userAuthenticationProvider;
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if("/v1/signIn".equals(request.getServletPath())
				&& HttpMethod.POST.matches(request.getMethod())) {
			CredentialsDto credentialsDto = MAPPER.readValue(
					request.getInputStream(), CredentialsDto.class);
			
			try {
				SecurityContextHolder.getContext().setAuthentication(
						userAuthenticationProvider.validateCredentials(credentialsDto)
						);
			} catch (RuntimeException e) {
				SecurityContextHolder.clearContext();
				throw e;
			}
		}
		filterChain.doFilter(request, response);
	}

}

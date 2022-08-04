package org.casdan.socialnetworkbackend.services;

import java.nio.CharBuffer;
import java.util.UUID;

import org.casdan.socialnetworkbackend.dto.CredentialsDto;
import org.casdan.socialnetworkbackend.dto.UserDto;
import org.casdan.socialnetworkbackend.entities.User;
import org.casdan.socialnetworkbackend.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AuthenticationService {
	
	private final PasswordEncoder passwordEncoder;
	private final UserRepository userRepository;
	
	

	public AuthenticationService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
		this.passwordEncoder = passwordEncoder;
		this.userRepository = userRepository;
	}

	public UserDto findByLogin(String login) {
		User user = userRepository.findByLogin(login)
				.orElseThrow(() -> new RuntimeException("Login not found"));
		
		return new UserDto(1L, 
				user.getFirstName(), 
				user.getLastName(), 
				user.getLogin(),  
				user.getToken());
		
	}
	
	
	@Transactional
	public UserDto authenticate(CredentialsDto credentialsDto) {

		User user = userRepository.findByLogin(credentialsDto.getLogin())
		.orElseThrow(() -> new RuntimeException("User not found"));
		
		if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
			user.setToken(UUID.randomUUID().toString());
			
			return new UserDto(1L, 
					user.getFirstName(), 
					user.getLastName(), 
					user.getLogin(),  
					user.getToken());
		}
		
		throw new RuntimeException("Invalid Password");
	}
	
	public UserDto findByToken(String token) {
		User user = userRepository.findByToken(token)
				.orElseThrow(() -> new RuntimeException("Token not found"));
		
		return new UserDto(1L, 
				user.getFirstName(), 
				user.getLastName(), 
				user.getLogin(),  
				user.getToken());	
		
	}

}

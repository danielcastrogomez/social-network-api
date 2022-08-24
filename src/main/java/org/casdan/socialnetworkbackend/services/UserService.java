package org.casdan.socialnetworkbackend.services;

import java.nio.CharBuffer;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import org.casdan.socialnetworkbackend.dto.SignUpDto;
import org.casdan.socialnetworkbackend.dto.UserDto;
import org.casdan.socialnetworkbackend.entities.Message;
import org.casdan.socialnetworkbackend.entities.User;
import org.casdan.socialnetworkbackend.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	
	public UserDto signUp(SignUpDto userDto) {
		
		Optional<User> optionalUser = userRepository.findByLogin(userDto.getLogin());
		
		if(optionalUser.isPresent()) {
			throw new RuntimeException("Login already exists");
		}
		
		User user = new User(null,
				userDto.getFirstName(),
				userDto.getLastName(),
				userDto.getLogin(),
				passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())),
				UUID.randomUUID().toString(),
				null,
				LocalDateTime.now()
				);
		
		User storedUser = userRepository.save(user);
		
		return new UserDto(storedUser.getId(), 
				storedUser.getFirstName(),
				storedUser.getLastName(),
				storedUser.getLogin(),
				storedUser.getToken()
				);
	
	}
	
	
}

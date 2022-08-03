package org.casdan.socialnetworkbackend.services;

import org.casdan.socialnetworkbackend.dto.CredentialsDto;
import org.casdan.socialnetworkbackend.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService {
	
	private String user = "testUser";

	public UserDto findByLogin(String login) {
		if(login.equalsIgnoreCase(user)) {
			UserDto userDto = new UserDto(1L, "test", "user", "testUser", "");
			
			return userDto;
		}
		
		throw new RuntimeException("Login not found. " + HttpStatus.NOT_FOUND);
		
	}

	public UserDto authenticate(CredentialsDto credentialsDto) {

		if (credentialsDto.getLogin().equalsIgnoreCase(user)) {
			UserDto userDto = new UserDto(1L, "test", "user", "testUser", "");

			return userDto;

		}

		throw new RuntimeException("Credentials Invalid. " + HttpStatus.BAD_REQUEST);
	}

}

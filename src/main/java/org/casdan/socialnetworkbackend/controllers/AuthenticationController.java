package org.casdan.socialnetworkbackend.controllers;

import org.casdan.socialnetworkbackend.config.UserAuthenticationProvider;
import org.casdan.socialnetworkbackend.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class AuthenticationController {
	
	private final UserAuthenticationProvider userAuthenticationProvider;

	public AuthenticationController(UserAuthenticationProvider userAuthenticationProvider) {
		this.userAuthenticationProvider = userAuthenticationProvider;
	}
	
	@PostMapping("/signIn")
	public ResponseEntity<UserDto> signIn(@AuthenticationPrincipal UserDto user){
		user.setToken(userAuthenticationProvider.createToken(user.getLogin()));
		return ResponseEntity.ok(user);
	}

}

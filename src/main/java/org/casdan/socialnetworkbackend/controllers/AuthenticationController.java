package org.casdan.socialnetworkbackend.controllers;

import org.casdan.socialnetworkbackend.config.UserAuthenticationProvider;
import org.casdan.socialnetworkbackend.dto.SignUpDto;
import org.casdan.socialnetworkbackend.dto.UserDto;
import org.casdan.socialnetworkbackend.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class AuthenticationController {

	private final UserAuthenticationProvider userAuthenticationProvider;
	private final UserService userService;

	public AuthenticationController(UserAuthenticationProvider userAuthenticationProvider, UserService userService) {
		this.userAuthenticationProvider = userAuthenticationProvider;
		this.userService = userService;
	}

	@PostMapping("/signIn")
	public ResponseEntity<UserDto> signIn(@AuthenticationPrincipal UserDto user) {
		user.setToken(userAuthenticationProvider.createToken(user.getLogin()));
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/signUp")
	public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto user){
		UserDto createdUser = userService.signUp(user);
		return ResponseEntity.ok(createdUser);
	}

}

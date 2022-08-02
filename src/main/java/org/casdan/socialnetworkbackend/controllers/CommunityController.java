package org.casdan.socialnetworkbackend.controllers;

import java.net.URI;
import java.util.List;

import org.casdan.socialnetworkbackend.dto.ImageDto;
import org.casdan.socialnetworkbackend.dto.MessageDto;
import org.casdan.socialnetworkbackend.services.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/v1/community")
public class CommunityController {

	private final MessageService messageService;

	public CommunityController(MessageService messageService) {
		this.messageService = messageService;
	}

	@GetMapping("/messages")
	public ResponseEntity<List<MessageDto>> getCommunityMessages(
			@RequestParam(value = "page", defaultValue = "0") int page) {

		return ResponseEntity.ok(messageService.getCommunityMessages(page));
	}

	@GetMapping("/images")
	public ResponseEntity<List<ImageDto>> getCommunityImages(
			@RequestParam(value = "page", defaultValue = "0") int page) {

		return ResponseEntity.ok(messageService.getCommunityImages(page));

	}

	@PostMapping("/messages")
	public ResponseEntity<MessageDto> postMessage(@RequestBody MessageDto messageDto) {

		return ResponseEntity.created(URI.create("/v1/community/messages"))
				.body(messageService.postMessage(messageDto));

	}

	@PostMapping("/images")
	public ResponseEntity<ImageDto> postImage(@RequestParam MultipartFile file,
			@RequestParam(value = "title") String title) {

		return ResponseEntity.created(URI.create("/v1/community/images"))
				.body(messageService.postImage(file, title));

	}
}

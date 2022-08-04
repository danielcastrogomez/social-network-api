package org.casdan.socialnetworkbackend.services;

import java.util.Arrays;
import java.util.List;

import org.casdan.socialnetworkbackend.dto.ImageDto;
import org.casdan.socialnetworkbackend.dto.MessageDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MessageService {

	public List<MessageDto> getCommunityMessages(int page) {
		return Arrays.asList(new MessageDto(1L, "First Message"), new MessageDto(2L, "Second Message"));

	}

	public List<ImageDto> getCommunityImages(int page) {
		return Arrays.asList(new ImageDto(1L, "First Image Title", null), new ImageDto(2L, "Second Image Title", null));
	}

	public MessageDto postMessage(MessageDto messageDto) {
		return new MessageDto(4L, "New Message");
	}

	public ImageDto postImage(MultipartFile file, String title) {
		return new ImageDto(5L, "New Message Image", null);
	}

}

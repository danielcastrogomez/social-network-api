package org.casdan.socialnetworkbackend.dto;

public class MessageDto {

	private Long Id;
	private String content;

	public MessageDto() {
		super();
	}

	public MessageDto(Long id, String content) {
		Id = id;
		this.content = content;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}

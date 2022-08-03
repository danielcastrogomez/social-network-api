package org.casdan.socialnetworkbackend.dto;

public class ErrorDto {

	private String errorMessage;

	public ErrorDto(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public ErrorDto() {		
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}

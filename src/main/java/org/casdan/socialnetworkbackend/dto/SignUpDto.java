package org.casdan.socialnetworkbackend.dto;

public class SignUpDto {

	private String firstName;
	private String lastName;
	private String login;
	private char[] password;

	public SignUpDto(String firstName, String lastName, String login, char[] password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
	}

	public SignUpDto() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login; 
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

}

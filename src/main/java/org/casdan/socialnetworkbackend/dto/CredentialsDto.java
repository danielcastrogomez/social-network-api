package org.casdan.socialnetworkbackend.dto;

public class CredentialsDto {

	private String login;
	private char[] password;

	public CredentialsDto(String login, char[] password) {
		super();
		this.login = login;
		this.password = password;
	}

	public CredentialsDto() {

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

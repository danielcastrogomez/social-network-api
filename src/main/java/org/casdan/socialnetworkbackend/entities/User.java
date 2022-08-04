package org.casdan.socialnetworkbackend.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "social_network_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
	@GenericGenerator(name = "sequenceGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
			@Parameter(name = "sequence_name", value = "social_network_user_sequence"),
			@Parameter(name = "initial_value", value = "1000"), @Parameter(name = "increment_size", value = "1")

	})
	private Long id;

	@Column(name = "first_name", nullable = false)
	@Size(max = 100)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	@Size(max = 100)
	private String lastName;

	@Column(nullable = false)
	@Size(max = 100)
	private String login;

	@Column(nullable = false)
	@Size(max = 100)
	private String password;

	@Column
	@Size(max = 100)
	private String token;

	@CreatedDate
	@Column(name = "created_date", nullable = false)
	private LocalDateTime createdDate;

	public User() {
		super();
	}

	public User(Long id, String firstName, String lastName, String login, String password, String token,
			LocalDateTime createdDate) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.password = password;
		this.token = token;
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

}
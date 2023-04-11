package com.mvc.bookClub.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	
//	----- Variables / DB columns -----
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Name must not be blank")
	@Size(min=2, max=120, message="Name must be between 2 to 120 characters")
	private String name;
	
	@NotBlank(message="email must not be blank")
	@Email(message="Please input proper email")
	private String email;
	
	@NotBlank(message="Password can't be empty")
	@Size(min=6, max=120, message="Password need to be 6 to 120 character long")
	private String password;
	
	@Transient // <--- will not be saved in database
	@NotBlank(message="Please confirm password")
	private String confirmPassword;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updateAt;
	
	@PrePersist
	protected void conCreate() {
		this.createAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updateAt = new Date();
	}
	
//	----- Constructor -----
	public User() {}

	
//	----- Getters / Setters -----
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	
	public Date getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}	
}

package com.niit.collaborationbackend.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="Member")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
//	@OneToOne(mappedBy="UserId" , fetch=FetchType.EAGER)
	private int userId;
	
//	@NotEmpty(message = "Name should not be empty")
	@Column(name = " name")
	private String name;
	
//	@NotEmpty(message = "User name should not be empty")
	@Column(name = "username")
	private String username;
	
//	@NotEmpty(message = "password should not be empty")
//	@Size(min = 6, max = 15)
	@Column(name = "password")
	private String password;
	
//	@NotEmpty(message = "address should not be empty")
	@Column(name = "address")
	private String address;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "email" ,unique=true)
//	@NotEmpty(message = "Email address should not be empty")
//	@Email(message = "Enter Valid Email address")
	private String email;
	
	@Column(name = "contact")
//	@NotEmpty
	private String contact;
	
	@Column(name="DOB")
//	@NotEmpty
	private String dob;

	@Column(name="Enabled")
	boolean enabled =true;
	
//	@OneToMany(fetch = FetchType.EAGER ,cascade=CascadeType.ALL , mappedBy = "user")
//	private List<Blog> blog;
	public String getDob() {
		return dob;
	}
//
//	public void setBlog(List<Blog> blog) {
//		this.blog = blog;
//	}
//
	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String toString() {
		return String.format("{userId:%s,name:%s,username:%s, address:%s}",userId,name,username,address);	
	}
	}
// 
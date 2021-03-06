package com.niit.collaborationbackend.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;


@Entity
@Component
@Table(name="c_blog")
public class Blog {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int b_id;

@NotEmpty(message="Enter valid Title")
private String b_title;

@NotEmpty(message="write blog")
private String b_content;

private int b_date;

private long b_time;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name ="userId")
private User user;

@Transient
private MultipartFile b_image;

public int getB_id() {
	return b_id;
}
public void setB_id(int b_id) {
	this.b_id = b_id;
}
public String getB_title() {
	return b_title;
}
public void setB_title(String b_title) {
	this.b_title = b_title;
}
public String getB_content() {
	return b_content;
}
public void setB_content(String b_content) {
	this.b_content = b_content;
}

public MultipartFile getB_image() {
	return b_image;
}
public void setB_image(MultipartFile image) {
	this.b_image = image;
}

public int getB_date() {
		return b_date;
	}
	public void setB_date(int b_date) {
		this.b_date = b_date;
	}
	public long getB_time() {
		return b_time;
	}
	public void setB_time(long b_time) {
		this.b_time = b_time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

public String toString() {
	return String.format("{b_id:%s,b_title:%s,b_content:%s,b_date:%s,b_time:%s,b_image:%s}",b_id,b_title,b_content,b_date,b_time,b_image);	
}
}

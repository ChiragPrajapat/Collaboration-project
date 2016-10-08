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
@Table(name="blog")
public class Blog {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int b_id;

@NotEmpty(message="Enter valid Title")
private String b_title;

@NotEmpty(message="write blog")
private String b_content;

private String b_date;

private String b_time;

//@ManyToOne(fetch = FetchType.EAGER)
//@JoinColumn(name ="userId")
//private User user;

@Transient
private MultipartFile image;

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
public String getB_date() {
	return b_date;
}
public void setB_date(String b_date) {
	this.b_date = b_date;
}
public String getB_time() {
	return b_time;
}
public void setB_time(String b_time) {
	this.b_time = b_time;
}

public MultipartFile getImage() {
	return image;
}
public void setImage(MultipartFile image) {
	this.image = image;
}
}

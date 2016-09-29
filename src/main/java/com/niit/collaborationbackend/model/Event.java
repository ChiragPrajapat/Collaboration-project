package com.niit.collaborationbackend.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;

public class Event {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int e_id;
@NotEmpty(message="Please provide event title")
private String e_title;
@NotEmpty(message="Where is this event?")

private String e_place;
@NotEmpty(message="date??")

private String e_date;
@NotEmpty(message="what is time?")

private String e_time;
@NotEmpty(message="Please describe !!")

private String e_description;
@ManyToMany
private User user;
public int getE_id() {
	return e_id;
}
public void setE_id(int e_id) {
	this.e_id = e_id;
}
public String getE_title() {
	return e_title;
}
public void setE_title(String e_title) {
	this.e_title = e_title;
}
public String getE_place() {
	return e_place;
}
public void setE_place(String e_place) {
	this.e_place = e_place;
}
public String getE_date() {
	return e_date;
}
public void setE_date(String e_date) {
	this.e_date = e_date;
}
public String getE_time() {
	return e_time;
}
public void setE_time(String e_time) {
	this.e_time = e_time;
}
public String getE_description() {
	return e_description;
}
public void setE_description(String e_description) {
	this.e_description = e_description;
}
public String getE_contact() {
	return e_contact;
}
public void setE_contact(String e_contact) {
	this.e_contact = e_contact;
}
public String getE_email() {
	return e_email;
}
public void setE_email(String e_email) {
	this.e_email = e_email;
}
@NotEmpty(message="Please provide contact")

private String e_contact;
@NotEmpty(message="Please provide email")

private String e_email;

}

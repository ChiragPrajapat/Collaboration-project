package com.niit.collaborationbackend.model;

public class Forum {
private int f_id;
private String f_topic;

public int getF_id() {
	return f_id;
}
public void setF_id(int id) {
	this.f_id = id;
}
public String getF_topic() {
	return f_topic;
}
public void setTopic(String f_topic) {
	this.f_topic = f_topic;
}
public String toString() {
	return String.format("{f_id:%s,f_topic:%s,p_post:%s,p_location:%s,p_description:%s,p_skill_set:%s,p_date:%s,p_time:%s,p_salary:%s}",f_id,f_topic);	
}
}

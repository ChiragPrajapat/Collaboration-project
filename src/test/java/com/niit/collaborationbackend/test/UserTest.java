package com.niit.collaborationbackend.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.collaborationbackend.dao.UserDAO;
import com.niit.collaborationbackend.model.User;

public class UserTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		UserDAO userdao = (UserDAO) context.getBean("userDAO");
		User user = (User) context.getBean("user");
		user.setName("Chirag Prajapat");
		user.setAddress("NIIT,second floor,bhandarkar bhavan, borivali west, mumbai");
		user.setDob("31/03/1995");
		user.setGender("M");
		user.setContact("9970643295");
		user.setEmail("chiragprajapat95@gmail.com");
		user.setEnabled(true);
		user.setUsername("chirag");
		user.setPassword("password");
		
		userdao.addUser(user);
	}

}

package com.niit.collaborationbackend.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.niit.collaborationbackend.dao.UserDAO;
import com.niit.collaborationbackend.model.User;

public class UserTest {

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext mycontext = new AnnotationConfigApplicationContext();
		mycontext.scan("com.niit.collaborationbackend");
		mycontext.refresh();
		UserDAO userdao = (UserDAO) mycontext.getBean("userDAO");
		User user = (User) mycontext.getBean("user");
		user.setName("John kennedy");
		user.setAddress("NIIT,second floor,bhandarkar bhavan, borivali west, US");
		user.setDob("31/03/1978");
		user.setGender("M");
		user.setContact("6523959144");
		user.setEmail("chiragjohn@gmail.com");
		user.setEnabled(true);
		user.setUsername("john");
		user.setPassword("password");
		
		userdao.addUser(user);
		System.out.println(userdao.getAllUsers());
	}

}

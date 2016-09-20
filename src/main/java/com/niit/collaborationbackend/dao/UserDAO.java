package com.niit.collaborationbackend.dao;
import java.util.List;

import com.niit.collaborationbackend.model.User;
public interface UserDAO {
	
		public void addUser(User u);
		public User getUserByUserId(int id);
		 public List<User> getAllUsers();
		 public User getUserByUsername (String username);
	}

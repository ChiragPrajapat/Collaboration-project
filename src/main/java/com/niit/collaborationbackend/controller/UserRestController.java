package com.niit.collaborationbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationbackend.dao.UserDAO;
import com.niit.collaborationbackend.model.User;

@RestController
public class UserRestController {
@Autowired
private UserDAO userDAO;

@GetMapping("/users")
public List<User> getUsers()
{
return userDAO.getAllUsers();	
}


@GetMapping("/user/{id}")
public ResponseEntity<?> getUser(@PathVariable("id") int id)
{
User user = userDAO.getUserByUserId(id);
if (user == null)
{
	return new ResponseEntity("No user found for id " + id, HttpStatus.NOT_FOUND);
}
System.out.println(user);
return new ResponseEntity(user.toString(), HttpStatus.OK);
}
 
}
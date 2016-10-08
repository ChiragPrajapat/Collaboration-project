package com.niit.collaborationbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationbackend.dao.UserDAO;
import com.niit.collaborationbackend.model.User;

@RestController
public class UserRestController {
@Autowired
private UserDAO userDAO;


@GetMapping("users")
public ResponseEntity<List<User>> getUsers()
{
	System.out.println(userDAO.getAllUsers());
return new ResponseEntity(userDAO.getAllUsers(),HttpStatus.OK);	
}


@GetMapping("user/{id}")
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



@RequestMapping(value="user/create", method=RequestMethod.POST,consumes="application/json",produces="application/json")
public ResponseEntity<?> createUser(@RequestBody  User userdata)
{
userDAO.addUser(userdata);
System.out.println("user added : " + userdata);
return new ResponseEntity("hi", HttpStatus.OK);
}

@GetMapping("user/edit/{id}")
public ResponseEntity<?> deleteUser()
{
	System.out.println("user edit page");
	return new ResponseEntity("EDIT", HttpStatus.OK);
	}
@DeleteMapping("user/delete/{id}")
public ResponseEntity<?> deleteUser(@PathVariable("id") int id,  @RequestBody User user)
{
	user = userDAO.getUserByUserId(id);
	System.out.println("delete mapping with id :" + id);
	userDAO.deleteUser(user);
	System.out.println("user deleted : " + user );
	return new ResponseEntity("DELETE", HttpStatus.OK);
}



@PutMapping("user/edit/{id}")
public ResponseEntity<?> updateUser(@PathVariable int id ,@RequestBody User user)
{
	if ( user == null)
	{
		return new ResponseEntity("No user found for this id :" + id,HttpStatus.NOT_FOUND);
	}
	user = userDAO.updateUser(id, user);
return new ResponseEntity(user , HttpStatus.OK);	
}
}
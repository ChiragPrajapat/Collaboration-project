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
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationbackend.dao.BlogDAO;
import com.niit.collaborationbackend.model.Blog;
import com.niit.collaborationbackend.model.User;

@RestController
public class BlogController {
@Autowired
private BlogDAO blogDAO;


@GetMapping("blogs")
public ResponseEntity<List<Blog>> getBlogs()
{
	System.out.println(blogDAO.getAllBlogs());
return new ResponseEntity(blogDAO.getAllBlogs(),HttpStatus.OK);	
}


@GetMapping("blog/{id}")
public ResponseEntity<?> getBlog(@PathVariable("b_id") int id)
{	
Blog blog = blogDAO.getBlogByBlogId(id);
if (blog == null)
{
	return new ResponseEntity("No blog found for id " + id, HttpStatus.NOT_FOUND);
}
System.out.println(blog);
return new ResponseEntity(blog.toString(), HttpStatus.OK);
}



@PostMapping(value="blog/create" ,consumes="application/json",produces="application/json")
public ResponseEntity<?> createBlog(@RequestBody  Blog blog)
{
	blogDAO.addBlog(blog);

	System.out.println("blog added : " + blog );
	return new ResponseEntity(HttpStatus.OK);
	}

@DeleteMapping("blog/delete/{id}")
public ResponseEntity<?> deleteBlog(@PathVariable("id") int id,  @RequestBody Blog blog)
{
	blog = blogDAO.getBlogByBlogId(id);
	System.out.println("delete mapping with id :" + id);
	blogDAO.DeleteBlog(blog);
	System.out.println("blog deleted : " + blog );
	return new ResponseEntity("DELETE", HttpStatus.OK);
}



@PutMapping("blog/edit/{id}")
public ResponseEntity<?> updateBlog(@PathVariable int id ,@RequestBody Blog blog)
{
	if ( blog == null)
	{
		return new ResponseEntity("No blog found for this id :" + id,HttpStatus.NOT_FOUND);
	}
//	blog = blogDAO.updateBlog(id, blog);
return new ResponseEntity(blog , HttpStatus.OK);	
}
}
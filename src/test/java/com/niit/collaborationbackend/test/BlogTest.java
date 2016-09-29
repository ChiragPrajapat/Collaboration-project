package com.niit.collaborationbackend.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborationbackend.dao.BlogDAO;
import com.niit.collaborationbackend.model.Blog;

public class BlogTest {

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext mycontext = new AnnotationConfigApplicationContext();
		mycontext.scan("com.niit.collaborationbackend");
		mycontext.refresh();
		BlogDAO blogdao = (BlogDAO) mycontext.getBean("blogDAO");
		Blog blog = (Blog) mycontext.getBean("blog");
		blog.setB_title("GitHub Upload");
		blog.setB_content("there are few steps to upload on gitHub. clone , add , commit and push");
		blog.setB_date("21/03/1995");
		blog.setB_time("21:26:12");
		
		blogdao.addBlog(blog);
	}

}

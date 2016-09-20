package com.niit.collaborationbackend.dao;
import java.util.List;

import com.niit.collaborationbackend.model.Blog;
public interface BlogDAO {
	
		public void addBlog(Blog u);
		public Blog getBlogByBlogId(int id);
		 public List<Blog> getAllBlogs();
		 public Blog getBlogByBlogname (String Title);
	}

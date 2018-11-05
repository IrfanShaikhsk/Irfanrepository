package com.niit.DAO;

import java.util.List;

import com.niit.Model.BlogComment;

public interface BlogCommentDao {
	void addBlogComment(BlogComment blogComment );
	List<BlogComment> getBlogComments(int blogPostId);
}

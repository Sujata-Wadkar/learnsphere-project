package com.learnSphere.services;

import java.util.List;

import com.learnSphere.entity.Comments;

public interface commentService {
	
	String addComment(Comments comment);

	List<Comments> commentList();
}

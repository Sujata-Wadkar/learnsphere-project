package com.learnSphere.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnSphere.entity.Comments;
import com.learnSphere.repository.CommentRepository;

@Service
public class CommentServiceImplementation implements commentService {

	@Autowired
	CommentRepository comRepo;
	@Override
	public List<Comments> commentList() {
		// TODO Auto-generated method stub
		return comRepo.findAll();
	}
	@Override
	public String addComment(Comments comment) {
		// TODO Auto-generated method stub
		comRepo.save(comment);
		return "comment added";
	}

}

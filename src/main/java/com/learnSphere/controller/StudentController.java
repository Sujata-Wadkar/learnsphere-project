package com.learnSphere.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RequestMapping;
import com.learnSphere.entity.Lesson;
import com.learnSphere.services.StudentService;
import com.learnSphere.services.commentService;

@Controller



public class StudentController {

	@Autowired
	StudentService studservice;
	
	
	@PostMapping("/gotolesson")
	public String myLesson(@RequestParam("lessonId") int lessonId,
			Model model) {
		
	Lesson lesson=studservice.getLesson(lessonId);
	lesson.setLinks(lesson.getLinks().replace("watch?v=", "embed/"));
	model.addAttribute("lesson", lesson);
	
	System.out.println(lesson);
		return "myLesson";
	}
	
}

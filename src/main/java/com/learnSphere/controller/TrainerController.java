package com.learnSphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lesson;
import com.learnSphere.services.TrainerService;
@Controller
public class TrainerController {
	@Autowired
	TrainerService tservice;
	@PostMapping("/addcourse")
	 public String addCourse(@RequestParam("courseId") int courseId,
			 @RequestParam("courseName") String courseName,
			 @RequestParam ("coursePrice") int coursePrice)
	{
		
		Course course=new Course();
		course.setCourseId(courseId);
		course.setCourseName(courseName);
		course.setCoursePrice(coursePrice);
		tservice.addCourse(course);
		 
		 return "redirect:/";
		
	 }
	@PostMapping("/addlesson")
	public String addLesson(@RequestParam("courseId") int courseId,
			@RequestParam("lessonId") int lessonId,
			@RequestParam("lessonName") String lessonName,
			@RequestParam("lessonTopics")String lessonTopics, 
			@RequestParam("videoTopic") String videoTopic) {
		Course course=tservice.getCourse(courseId);
		Lesson lesson=new Lesson(lessonId,lessonName,lessonTopics,videoTopic,course);
		tservice.addLesson(lesson);
		course.getLessons().add(lesson);
		
		return"redirect:/";
	}
	@GetMapping("/showcourses")
	public String showcourses(Model model) {
		
		List<Course> courseList=tservice.courseList();
		model.addAttribute("courseList", courseList);
		//System.out.println(courseList);
		return "courses";
	}
}

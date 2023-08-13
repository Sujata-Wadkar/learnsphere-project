package com.learnSphere.services;

import java.util.List;

import com.learnSphere.entity.Course;
import com.learnSphere.entity.Lesson;

public interface TrainerService {

	public String addCourse(Course c);
	
	public String addLesson(Lesson l);
	public Course getCourse( int courseId);
	
	public List<Course> courseList();
}

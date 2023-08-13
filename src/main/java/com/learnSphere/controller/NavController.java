package com.learnSphere.controller;



	import java.util.List;

	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;


	@Controller
	@RequestMapping
	public class NavController {
	
		@GetMapping("/")
		public String getindex() {
			return "index";
		}
		
		@GetMapping("/login")
		public String getAdd() {
			return "login";
		}
		@GetMapping("/register")
		public String getupdate() {
			return "register";
		}
		
		@GetMapping("/studenthome")
	    public String getStudentHome() {
	        return "studenthome";
	    }
	    
	    @GetMapping("/trainerhome")
	    public String getTrainerHome() {
	        return "trainerhome";
	    }
	    @GetMapping("/course")
		public String getAddCourse() {
			return "createcourse";
		}
	    @GetMapping("/lesson")
		public String getAddLesson() {
			return "addlesson";
		}
	    @GetMapping("/courses")
		public String getCourses() {
			return "courses";
		}
	    @GetMapping("/mycourses")
		public String getMyCourses() {
			return "mycourse";
		}
	    @GetMapping("/buycourses")
		public String getBuyCourses() {
			return "purchase";
		}
	    @GetMapping("/demoLesson")
		public String demoLesson() {
			return "demoLesson";
		}
	  
	}





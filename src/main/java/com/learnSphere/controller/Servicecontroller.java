package com.learnSphere.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.learnSphere.entity.Users;
import com.learnSphere.repository.UserRepository;
import com.learnSphere.services.UserSevice;
import com.learnSphere.services.commentService;
import com.learnSphere.entity.Comments;
@Controller
public class Servicecontroller {
	@Autowired
	UserSevice uservice;
	@Autowired
	UserRepository repo;
	@Autowired
	commentService cservice;
	@PostMapping("/adduser")
	public String addUser(@RequestParam("fname") String fname,
			@RequestParam("lname") String lname,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("role") String role,
			@RequestParam("phone") String phone) {
	boolean emailExists=uservice.checkEmail(email);
			 
		if(emailExists==false) {
		Users user=new Users();
		user.setFname(fname);
		user.setLname(lname);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		user.setPhone(phone);
		
		uservice.addUser(user);
		
		System.out.println(fname+lname+email+password+role+phone);
		return "login";
		
		}
		else {
			
			System.out.println("user  is exists ");
			return "register";
		}
	}
	@PostMapping("/validate")
	public String validate(
	        @RequestParam("email") String email,
	        @RequestParam("password") String password,
	        Model model
	) {
	    boolean val = uservice.validate(email, password);

	    if (val) {
	        String role = uservice.role(email);
	        if (role.equals("trainer")) {
	        	 model.addAttribute("message", "Login successful as a trainer!");
	            return "redirect:/trainerhome";
	        } else if (role.equals("student")) {
	        	model.addAttribute("message", "Login successful as a trainer!");
	            return "redirect:/studenthome";
	        }
	    }

	    return "redirect:/login";
	}

	@PostMapping("/addcomment")
	public String comments(@RequestParam("comment")String comment,
			Model model) {
		Comments c=new Comments();
		c.setComment(comment);
		cservice.addComment(c);
		
		List<Comments> commentLists=cservice.commentList();
		
		model.addAttribute("comment", commentLists);
		return "redirect:/studenthome";
		
	}
}




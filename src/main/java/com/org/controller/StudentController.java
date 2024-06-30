package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.StudentDao;
import com.org.dto.Student;

@Controller
public class StudentController {
	@Autowired
	StudentDao dao;
	
	@PostMapping("/save_student")
	public ModelAndView saveStudent(@ModelAttribute Student studentObj) {
		 
		 ModelAndView mav = new ModelAndView("home.jsp");
	     dao.saveAndUpdateStudent(studentObj);
	     return mav;
	}
	
	@GetMapping("/update_student")
	public ModelAndView updateStudent(@RequestParam int stdId) {
		Student student = dao.fetchStudentById(stdId);
	    ModelAndView mav = new ModelAndView("add_student.jsp");
	    mav.addObject("studentObj", student);
	    return mav;
	    
	}
 
}

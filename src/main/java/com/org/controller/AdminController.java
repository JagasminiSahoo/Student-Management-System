package com.org.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.AdminDao;
import com.org.dao.StudentDao;
import com.org.dto.Admin;
import com.org.dto.Student;
import com.org.utilities.Helper;

@Controller
public class AdminController {
	
	@Autowired
	AdminDao adminDao; //to provide implementation of abstract methods by parent class
    @Autowired
	StudentDao studentdao;
//	@GetMapping("/test")
//	public ModelAndView sampleTest()
//	{
//		ModelAndView mav = new ModelAndView("");
//		adminDao.saveAndUpdate(null);
//	    System.out.println("Test Success");
//	    return mav;
//	
//	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam String email,@RequestParam String password,HttpSession session)
	{
		List<Admin> verifyAdmin = adminDao.verifyAdminByEmailAndPwd(email, password);
		if(!verifyAdmin.isEmpty()) {
			ModelAndView mav=new ModelAndView("fetch_student");
		    Admin admin = verifyAdmin.get(0);
		    session.setAttribute("adminId", admin.getId());
			return mav;
		}
		else
		{
			ModelAndView mav = new ModelAndView("login.jsp");
			mav.addObject("fail", "Invalid Email and password");
			return mav;
		}
	}
	
	@GetMapping("/add_student")
	public ModelAndView addStudent() {
		Student student = new Student();
		
		ModelAndView mav = new ModelAndView("add_student.jsp");
		
	    mav.addObject("studentObj", student);
		
	    return mav;
	}
	
	@PostMapping("/fetch_student")
	public ModelAndView fetchStudent() {
		
		ModelAndView mav = new ModelAndView("home.jsp");
		List<Student> students = studentdao.fetchAllStudents();
		mav.addObject("students", students);
		return mav;
	}
	@GetMapping("/delete_student")
	public ModelAndView deleteStudent(@RequestParam int stdId) {
		
		studentdao.removeStudentById(stdId);
		ModelAndView mav = new ModelAndView("fetching_students");
		return mav;
	}
	
	@GetMapping("/fetching_students")
    public ModelAndView fetchStudents() {
		
		ModelAndView mav = new ModelAndView("home.jsp");
		List<Student> students = studentdao.fetchAllStudents();
		mav.addObject("students", students);
		return mav;
	}
	
}

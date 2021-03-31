package com.b2b.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.b2b.dto.Approval;
import com.b2b.dto.User;
import com.b2b.service.ApprovalService;
import com.b2b.service.LoginService;

@Controller
//@SessionAttributes({"currentId","userName", "userType"})
public class LoginController {

	@Autowired
	private LoginService loginservice;

	@Autowired
	private ApprovalService approval;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage(Locale local, Model model) {
		//TO REDIRECT TO THE LOGIN CONTROLLER WHICH WILL THEN REDIRECT TO THE LOGIN PAGE AND CHECK IF SESSION EXISTS OR NOT
		return "redirect:/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView userLogin(HttpServletRequest request) {
		//CHECK IF THE USER SESSION EXISTS OR NOT
		String userType = (String) request.getSession().getAttribute("userType");
		if (userType == null) {
			ModelAndView mav = new ModelAndView("login");
			return mav;
		}
		else 
		{
			//String userType = (String) request.getSession().getAttribute("userType");
			if(userType.equals("admin"))
			{
				ModelAndView mav = new ModelAndView("adminHome");
				List<Approval> list = approval.userList();
				mav = new ModelAndView("adminHome");
				mav.addObject("ilist", list);
				return mav;
			}
			else if (userType.equals("pharmacy")) 
			{
				ModelAndView mav = new ModelAndView("pharmacyHome");
				return mav;
			}
			else if (userType.equals("manufacturer")) 
			{
				ModelAndView mav = new ModelAndView("manufacturerHome");
				return mav;
			}
			else 
			{
				ModelAndView mav = new ModelAndView("login");
				return mav;
			}
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView userValidation(@Validated User user,  HttpServletRequest request) {
		//TRY CATCH BLOCK TO CHECK IF THE USER EXISTS OR NOT, OTHERWISE HANDLE NULL POINTER EXCEPTION
		try
		{

			//ROLE BASED LOGIN CODE AND SETTING UP SESSION OBJECT
			ModelAndView mav = new ModelAndView("login");

			User user1 = loginservice.getUserType(user);
			String userType = user1.getUserType().toString();

			if(userType.equals("admin"))
			{
				List<Approval> list = approval.userList();
				mav = new ModelAndView("adminHome");
				mav.addObject("ilist", list);
				long adminId = loginservice.getAdminId(user1);
				request.getSession().setAttribute("currentId", adminId);
			}
			else if(userType.equals("pharmacy"))
			{
				long pharId = loginservice.getPharId(user1);
				mav = new ModelAndView("pharmacyHome");
				mav.addObject("currentId", pharId);
				request.getSession().setAttribute("currentId", pharId);
			}
			else if(userType.equals("manufacturer"))
			{
				long manuId = loginservice.getManuId(user1);
				mav = new ModelAndView("manufacturerHome");
				mav.addObject("currentId", manuId);
				request.getSession().setAttribute("currentId", manuId);
			}

			String userName = user.getUserName().toString();
			request.getSession().setAttribute("userName", userName);
			request.getSession().setAttribute("userType", userType);

			return mav;
		}
		catch (Exception e) {
			ModelAndView mav = new ModelAndView("login");
			return mav;
		}
	}	
}
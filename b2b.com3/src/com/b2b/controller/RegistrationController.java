package com.b2b.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.b2b.dto.Approval;
import com.b2b.service.ApprovalService;

@Controller
public class RegistrationController {

	private static final String UPLOAD_DIRECTORY = "resources/images";

	@Autowired
	private ApprovalService approvalService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerationPage(Locale locale, Model model) {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView afterRegistrationPage(@Validated Approval approval, Model model,@RequestParam CommonsMultipartFile file,HttpSession session) {
		try
		{
			//IMAGE INSERTION IN DATABASE CODE
			ServletContext context = session.getServletContext();  
			String path = context.getRealPath(UPLOAD_DIRECTORY);  
			String filename = file.getOriginalFilename();  
			System.out.println(path+"\\"+filename);

			String license = path+"\\"+filename;
			approval.setLicense(filename);

			byte[] bytes = file.getBytes();  
			BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream( new File(path + File.separator + filename)));  
			stream.write(bytes);  
			stream.flush();  
			stream.close();

			//return new ModelAndView("register");
			approvalService.insertUser(approval);
			//return "register";
			return new ModelAndView("register");
		}
		catch(Exception e)
		{
			//return "login";
			return new ModelAndView("login");
		}
	}

	@RequestMapping(value="/check_avail",method = RequestMethod.GET)
	@ResponseBody
	public String isUsername(@RequestParam String tempName)
	{
		//CODE FOR AJAX CALL TO CHECK IF THE USERNAME IS AVAILABLE OR NOT
		if(approvalService.isUsername(tempName))
			return "Username already exists";
		else
			return "Username is available";
	}

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public String createAccount(@RequestParam("tempName") String tempName, @RequestParam("tempType") String tempType, HttpSession session) {
		try
		{
			approvalService.insertIntoRespectiveTable(tempName, tempType);
			return "redirect:/login";
		}
		catch(Exception e)
		{
			System.out.println(e);
			return "redirect:/login";
		}
	}

	@RequestMapping(value = "/rejectAccount", method = RequestMethod.POST)
	public String rejectAccount(@RequestParam("tempName") String tempName, @RequestParam("tempType") String tempType, HttpSession session) {
		try
		{
			approvalService.rejectAccount(tempName, tempType);
			return "redirect:/login";
		}
		catch(Exception e)
		{
			System.out.println(e);
			return "redirect:/login";
		}
	}
}

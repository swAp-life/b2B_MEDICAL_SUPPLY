package com.b2b.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.b2b.dto.Approval;
import com.b2b.dto.Orders;
import com.b2b.dto.Pharmacy;
import com.b2b.dto.Product;
import com.b2b.dto.ProductManufacturer;
import com.b2b.service.OrderService;
import com.b2b.service.ProductService;
import com.b2b.service.UpdateDetails;

@Controller
//@SessionAttributes({"currentId","userName"})
//@SessionAttributes("userName")
public class PharmacyController {


	@Autowired
	private Pharmacy pharmacy;

	@Autowired
	private UpdateDetails updatedetails;

	@Autowired
	private ProductService productservice;

	@Autowired
	private OrderService orderservice;

	@RequestMapping(value = "/pharmacyHomePage", method = RequestMethod.GET)
	public String pharmacyHomePage(HttpServletRequest request) {
		String userType = (String) request.getSession().getAttribute("userType");
		if(userType == null)
		{
			return "login";
		}
		else 
		{
			return "pharmacyHome";
		}
	}

	@RequestMapping(value = "/pharmacyDetailsPage", method = RequestMethod.GET)
	public ModelAndView pharmacyDetailsPage(HttpServletRequest request, Model model) {
		String userType = (String) request.getSession().getAttribute("userType");
		if(userType == null)
		{
			ModelAndView mav = new ModelAndView("login");
			return mav;
		}
		else 
		{
			long pharId = (long) request.getSession().getAttribute("currentId");
			ModelAndView mav = new ModelAndView("pharmacyDetails");
			pharmacy = updatedetails.getPharmacy(pharId);
			//pharmacy = updatedetails.getPharmacy(pharId);
			mav.addObject("pharName", pharmacy.getPharName());
			mav.addObject("pharPass", pharmacy.getPharPass());
			mav.addObject("pharAddress", pharmacy.getPharAddress());
			mav.addObject("pharPhoneNo", pharmacy.getPharPhoneNo());
			mav.addObject("pharMailId", pharmacy.getPharMailId());
			return mav;	
		}
	}

	@RequestMapping(value = "/pharmacyDetailsPage", method = RequestMethod.POST)
	public String pharmacyDetailsPagePost(@Validated Pharmacy pharmacy, Model model) {

		//pharmacy.setPharName();
		updatedetails.updatePharmacy(pharmacy);
		return "pharmacyHome";
	}

	@RequestMapping(value = "/pharmacyOrderDetailsPage", method = RequestMethod.GET)
	public ModelAndView pharmacyOrderDetailsPageGet(HttpServletRequest request, Model model) {
		String userType = (String) request.getSession().getAttribute("userType");
		if(userType == null)
		{
			ModelAndView mav = new ModelAndView("login");
			return mav;
		}
		else 
		{
			ModelAndView mav = new ModelAndView("pharmacyOrderDetails");
			String pharName = (String) request.getSession().getAttribute("userName"); 
			List<Orders> orders = orderservice.getPharOrderDetails(pharName);
			mav.addObject("ilist", orders);
			return mav;


		}
	}

	@RequestMapping(value = "/pharmacyBrowseProducts", method = RequestMethod.GET)
	public ModelAndView pharmacyBrowseProductsGet(HttpServletRequest request) {
		String userType = (String) request.getSession().getAttribute("userType");
		if(userType == null)
		{
			ModelAndView mav = new ModelAndView("login");
			return mav;
		}
		else
		{
			ModelAndView mav = new ModelAndView("pharmacyBrowseProducts");
			List<ProductManufacturer> productsAndManufacturers = productservice.getProductsAndManufacturers();
			mav.addObject("ilist", productsAndManufacturers);
			return mav;
		}
	}

	@RequestMapping(value = "/pharmacyBuyProduct", method = RequestMethod.POST)
	public String pharmacyBuyProduct(@Validated Product product,HttpServletRequest request, Model model) {
		long pharId = (long) request.getSession().getAttribute("currentId");
		orderservice.addOrder(product, pharId);
		return "redirect:/pharmacyOrderDetailsPage";
	}
}

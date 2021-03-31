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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.b2b.dto.Manufacturer;
import com.b2b.dto.Orders;
import com.b2b.dto.Product;
import com.b2b.dto.ProductManufacturer;
import com.b2b.service.OrderService;
import com.b2b.service.ProductService;
import com.b2b.service.UpdateDetails;

@Controller
//@SessionAttributes({"currentId","userName"})
//@SessionAttributes("userName")
public class ManufacturerController {

	@Autowired
	private Manufacturer manufacturer;

	@Autowired
	private UpdateDetails updatedetails;

	@Autowired
	private ProductService productservice;

	@Autowired
	private OrderService orderservice;

	@RequestMapping(value = "/manufacturerHomePage", method = RequestMethod.GET)
	public String manufacturerHomePage(HttpServletRequest request, Model model) {
		String userType = (String) request.getSession().getAttribute("userType");
		if(userType == null)
		{
			return "login";
		}
		else
		{
			return "manufacturerHome";
		}
	}

	@RequestMapping(value = "/manufacturerDetailsPage", method = RequestMethod.GET)
	public ModelAndView manufacturerDetailsPageGet(HttpServletRequest request) {
		String userType = (String) request.getSession().getAttribute("userType");
		if(userType == null)
		{
			ModelAndView mav = new ModelAndView("login");
			return mav;
		}
		else 
		{
			long manuId = (long) request.getSession().getAttribute("currentId");
			ModelAndView mav = new ModelAndView("manufacturerDetails");
			manufacturer = updatedetails.getManufacturer(manuId);
			mav.addObject("manuName", manufacturer.getManuName());
			mav.addObject("manuPass", manufacturer.getManuPass());
			mav.addObject("manuAddr", manufacturer.getManuAddr());
			mav.addObject("manuPhoneNo", manufacturer.getManuPhoneNo());
			mav.addObject("manuMailId", manufacturer.getManuMailId());
			return mav;
		}
	}

	@RequestMapping(value = "/manufacturerDetailsPage", method = RequestMethod.POST)
	public String manufacturerDetailsPagePost(@Validated Manufacturer manufacturer, Model model) {
		updatedetails.updateManufacturer(manufacturer);
		return "manufacturerHome";
	}

	@RequestMapping(value = "/manufacturerOrderDetailsPage", method = RequestMethod.GET)
	public ModelAndView manufacturerOrderDetailsPageGet(HttpServletRequest  request, Model model) {
		String userType = (String) request.getSession().getAttribute("userType");
		if(userType == null)
		{
			ModelAndView mav = new ModelAndView("login");
			return mav;
		}
		else
		{
			ModelAndView mav = new ModelAndView("manufacturerOrderDetails");
			String manuName = (String) request.getSession().getAttribute("userName"); 
			List<Orders> orders = orderservice.getManuOrderDetails(manuName);
			mav.addObject("ilist", orders);
			return mav;


		}
	}

	@RequestMapping(value = "/manufacturerBrowseProducts", method = RequestMethod.GET)
	public ModelAndView manufacturerBrowseProductsGet(HttpServletRequest request) {
		String userType = (String) request.getSession().getAttribute("userType");
		if(userType == null)
		{
			ModelAndView mav = new ModelAndView("login");
			return mav;
		}
		else
		{
			long currentId = (long) request.getSession().getAttribute("currentId");
			ModelAndView mav = new ModelAndView("manufacturerProducts");
			List<ProductManufacturer> products = productservice.getProducts(currentId);
			mav.addObject("ilist", products);
			return mav;
		}
	}

	@RequestMapping(value = "/manufacturerAddProduct", method = RequestMethod.GET)
	public String manufacturerAddProduct(HttpServletRequest  request, Model model) {
		String userType = (String) request.getSession().getAttribute("userType");
		if(userType == null)
		{
			return "login";
		}
		else 
		{
			return "manufacturerAddProduct";	
		}
	}

	@RequestMapping(value = "/manufacturerAddProduct", method = RequestMethod.POST)
	public String manufacturerAddProductPost(@Validated Product product,HttpServletRequest  request) {
		long currentId = (long) request.getSession().getAttribute("currentId");
		product.setManuId(currentId);
		productservice.addProduct(product);
		//return "manufacturerProducts";
		return "redirect:/manufacturerBrowseProducts";
	}

	@RequestMapping(value = "/manufacturerUpdateProduct", method = RequestMethod.GET)
	public ModelAndView manufacturerUpdateProduct(HttpServletRequest  request, @RequestParam("prodId") long prodId) {
		String userType = (String) request.getSession().getAttribute("userType");
		if(userType == null)
		{
			ModelAndView mav = new ModelAndView("login");
			return mav;
		}
		else 
		{
			//System.out.println(request.getAttribute("prodId"));

			ModelAndView mav = new ModelAndView("manufacturerUpdateProduct");
			Product product = productservice.getProductByProdId(prodId);
			mav.addObject(product);
			return mav;	
		}
	}

	@RequestMapping(value = "/manufacturerUpdateProduct", method = RequestMethod.POST)
	public String manufacturerUpdateProductPost(@Validated Product product, HttpServletRequest  request) {
		//long manuId = (long) request.getSession().getAttribute("currentId");
		//product.setProdId(prodId);
		productservice.updateProduct(product);
		return "redirect:/manufacturerBrowseProducts";
	}

	@RequestMapping(value = "/manufacturerDeleteProduct", method = RequestMethod.POST)
	public String manufacturerDeleteProductPost(HttpServletRequest  request, @RequestParam("prodId") long prodId) {
		//long manuId = (long) request.getSession().getAttribute("currentId");
		//product.setProdId(prodId);
		productservice.deleteProduct(prodId);
		return "redirect:/manufacturerBrowseProducts";
	}

}
//@RequestParam("prodId") long prodId , @RequestParam("prodCost") long prodCost , @RequestParam("prodQuantity") long prodQuantity
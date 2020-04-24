package com.SpringMVCBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.SpringMVCBoot.dao.AlienRepository;
import com.SpringMVCBoot.model.Alien;

@Controller
public class HomeController //Dispatcher servlet or Front Controller
{
	@Autowired
	AlienRepository repo; // it will look for the object of AlienRepository which has all the CRUD methods(spring-data-jpa)
	
	@RequestMapping("/")		//calls the index page
	public String home() 
	{
		return "addAlien";		
	}
	
	@RequestMapping("add")
	public ModelAndView add(@RequestParam("num1") int a,@RequestParam("num2") int b)
	{
//		int a=Integer.parseInt(request.getParameter("num1"));
//		int b=Integer.parseInt(request.getParameter("num2"));
		
		ModelAndView mv= new ModelAndView();
		mv.setViewName("result");
 		int result= a+b;
		
//		HttpSession session= request.getSession();
 		mv.addObject("result",result);
//		session.setAttribute("result", result);
		return mv;
	}

	@RequestMapping("addAlien")
	public String addAlien(@ModelAttribute Alien a) 
	{
		repo.save(a);						//to save 
		return "displayAliens";
	}
	
	@GetMapping("getAllAliens")
	public String getAllAliens(Model m)
	{
		m.addAttribute("result",repo.findAll()); // method of JpaRepository to get all as a list(spring-data-jpa)
		return "displayAliens";
	}
	
	@GetMapping("getAlienById")
	public String getAlienById(@RequestParam int aid,Model m) 
	{
		m.addAttribute("result", repo.getOne(aid));	// to get single item
		return "displayAliens";
	}
	
	@GetMapping("getAlienByName")
	public String getAlienByName(@RequestParam String aname,Model m) 
	{
//		m.addAttribute("result", repo.findByAname(aname));	// to get single item , using Query DSL=Domail specific language
		m.addAttribute("result", repo.findAlienbyName(aname)); // to get single item , using our own jpa query
		return "displayAliens";
	}
}

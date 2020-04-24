package com.SpringMVCBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringMVCBoot.dao.AlienRepository;
import com.SpringMVCBoot.model.Alien;

@RestController			// When we want to communicate with rest api services
public class AlienController 
{
	@Autowired
	private AlienRepository repository;
	
	
//	@GetMapping("Aliens")			//for fetching the Aliens from POSTMAN
	@GetMapping(path = "Aliens", produces = {"application/xml"}) // sends only XML format even the client wants some other format(to return only JSON "application/json")
//	@ResponseBody					//we have to mention that we are sending actual data not a .JSP name as we usually do( only when we don't use @RestController)
	public List<Alien> getAliens() 
	{
		return repository.findAll();	// It will return the list as it is so that we get the data in JSON format(Converted by JACKSON inbuilt in boot)
	}
	
	@GetMapping("Alien/{aid}")
	public Optional<Alien> getAlien(@PathVariable("aid") int aid) //path variable is the variable name received from client-side as{aid}
	{
		Optional<Alien> alien = repository.findById(aid);
		return alien;
	}
	
//	@PostMapping("Alien")
//	public Alien addAlien(@RequestBody Alien alien)
//	{
//		repository.save(alien);
//		return alien;
//	}
	
		
	@PostMapping(path = "Alien", consumes = {"application/json"}) // receives only JSON format even the client wants some other format(to receive only XML "application/xml")
	public Alien addAlien(@RequestBody Alien alien)				 //@RequestBode Covert JSON into java object
	{
		repository.save(alien);
		return alien;
	}
}

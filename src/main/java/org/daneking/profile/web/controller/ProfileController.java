package org.daneking.profile.web.controller;

import org.daneking.profile.domain.person.Person;
import org.daneking.profile.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	@Autowired
	private PersonRepository repository;
	
	public void setRepository(PersonRepository repository) {
		this.repository = repository;
	}
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String loadAdd(Model model){
		logger.info("Get Request to edit");
		model.addAttribute("person", new Person());
		return "person";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String save(@Validated Person person, Model model){
		logger.info("Save Person");
		//Post Redirect Pattern to prevent double submits
		return "redirect:/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listPeople(){
		logger.info("List Person");
		return "list";
	}
}


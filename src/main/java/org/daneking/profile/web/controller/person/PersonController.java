package org.daneking.profile.web.controller.person;

import org.daneking.profile.domain.person.Person;
import org.daneking.profile.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController {
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	@Autowired
	private PersonService service;
	

	public void setService(PersonService service) {
		this.service = service;
	}

	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String loadAdd(Model model){
		logger.info("Get Request to edit");
		model.addAttribute("person", new Person());
		return "person";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String save(@Validated Person person){
		logger.info("Saving a person");
		Person persistedEntity=service.save(person);
		//Versify persons was saved
		Assert.notNull(persistedEntity);
		logger.info("Save Person");
		//Post Redirect Pattern to prevent double submits
		return "redirect:/list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listPeople(Model model){
		logger.info("List Person");
		Iterable<Person> people=service.findAll();
		model.addAttribute("personList", people);
		return "list";
	}
}


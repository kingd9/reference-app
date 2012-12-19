package org.profile.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {
	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@RequestMapping(value="/edit/", method=RequestMethod.GET)
	public String loadEdit(Model model){
		logger.info("Get Request to edit");
		model.addAttribute("person", new Person());
		return "profile";
	}
	@RequestMapping(value="/edit/", method=RequestMethod.POST)
	public String loadEdit(Person person, Model model){
		return "profile";
	}
}


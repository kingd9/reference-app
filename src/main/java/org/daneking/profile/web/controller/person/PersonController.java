package org.daneking.profile.web.controller.person;

import java.util.Iterator;

import org.daneking.profile.domain.person.Person;
import org.daneking.profile.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonController {
	private static final String REDIRECT = "redirect:";
	private static final String PERSON_URL = "/person/";
	private static final String PERSON_ADD_URL = "/person/add";
	private static final String PERSON_EDIT_URL = "/person/edit";
	private static final String PERSON_LIST_URL = "/person/list";
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService service;

	public void setService(final PersonService service) {
		this.service = service;
	}

	@RequestMapping(value = PERSON_URL + "{id}", method = RequestMethod.GET)
	public String findPerson(@PathVariable final Long id, final Model model) {
		final Person person = service.findOne(id);
		LOGGER.info("Find Person to Edit");
		return addPerson(model, person);
	}

	@RequestMapping(value = PERSON_ADD_URL, method = RequestMethod.GET)
	public String loadAdd(final Model model) {
		LOGGER.info("Get Request to add");
		return addPerson(model, new Person());
	}

	private String addPerson(final Model model, final Person person) {
		model.addAttribute("person", person);
		return "add";
	}

	@RequestMapping(value = { PERSON_ADD_URL, PERSON_URL + "{id}" }, method = RequestMethod.POST)
	public String save(@Validated final Person person) {
		LOGGER.info("Saving a person");
		final Person persistedEntity = service.save(person);
		// Verify persons was saved
		Assert.notNull(persistedEntity);
		LOGGER.info("Save Person");
		// Post Redirect Pattern to prevent double submits
		return REDIRECT + PERSON_LIST_URL;
	}

	@RequestMapping(value = PERSON_LIST_URL, method = RequestMethod.GET)
	public String listPeople(final Model model) {
		LOGGER.info("List Person");
		final Iterable<Person> people = service.findAll();
		return listPeople(model, people);
	}

	@RequestMapping(value = PERSON_LIST_URL + "{filter}", method = RequestMethod.GET)
	public String listPeople(@PathVariable final String filter, final Model model) {
		// TODO:Throw not implemented exception
		LOGGER.info("Filtered List Person");
		// TODO:Create filtered list
		return listPeople(model, new Iterable<Person>() {

			@Override
			public Iterator<Person> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}

	/**
	 * Given a filtered or unfiltered list forwards to view
	 * 
	 * @param model
	 * @param people
	 * @return view name of list
	 */
	private String listPeople(final Model model, final Iterable<Person> people) {
		model.addAttribute("personList", people);
		return "list";
	}
}

package org.daneking.profile.web.controller.person;

import java.util.Iterator;

import org.daneking.profile.domain.person.Person;
import org.daneking.profile.service.PersonService;
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
	private static final String PERSON_DETAIL_URL = "/person/{id}";
	private static final String PERSON_ADD_URL = "/person/add/";
	private static final String PERSON_EDIT_URL = "/person/edit/";
	private static final String PERSON_LIST_URL = "/person/list/";
	private static final String PERSON_DELETE_URL = "/person/delete/";
	// private static final Logger LOGGER =
	// LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonService service;

	public void setService(final PersonService service) {
		this.service = service;
	}

	@RequestMapping(value = PERSON_EDIT_URL + "{id}", method = RequestMethod.GET)
	public String loadEdit(@PathVariable final Long id, final Model model) {
		final Person person = service.findOne(id);
		// LOGGER.info("Find Person to Edit");
		return add(model, person);
	}

	@RequestMapping(value = PERSON_ADD_URL, method = RequestMethod.GET)
	public String loadAdd(final Model model) {
		// LOGGER.info("Get Request to add");
		return add(model, new Person());
	}

	private String add(final Model model, final Person person) {
		model.addAttribute("person", person);
		return "add";
	}

	@RequestMapping(value = { PERSON_ADD_URL, PERSON_EDIT_URL + "{id}" }, method = RequestMethod.POST)
	public String save(@Validated final Person person) {
		// LOGGER.info("Saving a person");
		final Person persistedEntity = service.save(person);
		// Verify persons was saved
		Assert.notNull(persistedEntity);
		// LOGGER.info("Save Person");
		// Post Redirect Pattern to prevent double submits
		return REDIRECT + PERSON_LIST_URL;
	}

	@RequestMapping(value = PERSON_LIST_URL, method = RequestMethod.GET)
	public String loadList(final Model model) {
		// LOGGER.info("List Person");
		final Iterable<Person> people = service.findAll();
		return list(model, people);
	}

	@RequestMapping(value = PERSON_LIST_URL + "{filter}", method = RequestMethod.GET)
	public String filteredList(@PathVariable final String filter, final Model model) {
		// TODO:Throw not implemented exception
		// LOGGER.info("Filtered List Person");
		// TODO:Create filtered list
		return list(model, new Iterable<Person>() {

			@Override
			public Iterator<Person> iterator() {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}

	/**
	 * Given a filtered or unfiltered list and forwards to view
	 * 
	 * @param model
	 * @param people
	 * @return view name of list
	 */
	private String list(final Model model, final Iterable<Person> people) {
		model.addAttribute("personList", people);
		return "list";
	}

	@RequestMapping(value = PERSON_DELETE_URL + "{id}", method = RequestMethod.GET)
	public String deleteById(@PathVariable final Long id, final Model model) {
		service.delete(id);
		return REDIRECT + PERSON_LIST_URL;
	}

	@RequestMapping(value = PERSON_DETAIL_URL, method = RequestMethod.GET)
	public String details(@PathVariable final Long id, final Model model) {
		Person person = service.findOne(id);
		model.addAttribute("person", person);
		return "detail";
	}

}

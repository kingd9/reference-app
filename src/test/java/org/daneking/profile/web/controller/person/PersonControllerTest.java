package org.daneking.profile.web.controller.person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.daneking.profile.domain.person.Person;
import org.daneking.profile.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;

public class PersonControllerTest {
	private PersonController controller;
	private PersonService service;

	@Before
	public void setUp() throws Exception {
		controller = new PersonController();
		service = mock(PersonService.class);
	}

	@Test
	public void testloadAddGetRequestReturnsProfileView() {
		ExtendedModelMap model = new ExtendedModelMap();
		assertEquals("add", controller.loadAdd(model));

	}

	@Test
	public void testSavePostRequestSavesPersonReturnsListView() {
		final Person person = new Person();
		when(service.save(person)).thenReturn(person);
		controller.setService(service);
		assertEquals("redirect:/person/list", controller.save(person));
	}

	@Test
	public void testFailureToSaveThrowsError() {
		final Person person = new Person();
		boolean hasError = false;
		controller.setService(service);
		try {
			controller.save(person);
		} catch (IllegalArgumentException e) {
			hasError = true;
		}
		assertTrue(hasError);

	}

	@Test
	public void testFindPersonReturnsAddView() {
		controller.setService(service);
		assertEquals("add", controller.findPerson(1L, new ExtendedModelMap()));

	}

	@Test
	public void testListGetRequestListView() {
		controller.setService(service);
		assertEquals("list", controller.listPeople(new ExtendedModelMap()));

	}

	@Test
	public void testFilterListReturnsListView() {
		controller.setService(service);
		assertEquals("list", controller.listPeople("filter", new ExtendedModelMap()));

	}

}

package org.daneking.profile.web.controller.person;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.daneking.profile.domain.person.Person;
import org.daneking.profile.service.PersonService;
import org.daneking.profile.web.controller.person.PersonController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import static org.mockito.Mockito.*;

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
		String view = controller.loadAdd(model);
		assertEquals("person", view);

	}

	@Test
	public void testSavePostRequestSavesPersonReturnsListView() {
		Person person = new Person();
		when(service.save(person)).thenReturn(person);
		controller.setService(service);
		String view = controller.save(person);
		assertEquals("redirect:/list", view);

	}
	@Test
	public void testFailureToSaveThrowsError() {
		Person person = new Person();
		boolean hasError=false;
		controller.setService(service);
		try {
			controller.save(person);
		} catch (IllegalArgumentException e) {
			hasError=true;
		}
		assertTrue(hasError);

	}
	@Test
	public void testListGetRequestListView() {
		controller.setService(service);
		String view = controller.listPeople(new ExtendedModelMap());
		assertEquals("list", view);

	}

}

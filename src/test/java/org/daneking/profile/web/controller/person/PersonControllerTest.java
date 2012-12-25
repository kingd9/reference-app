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
	private static final long MOCK_ID = 1L;
	private PersonController controller;
	private PersonService service;

	@Before
	public void setUp() throws Exception {
		controller = new PersonController();
		service = mock(PersonService.class);
		controller.setService(service);
	}

	@Test
	public void testloadAddGetRequestReturnsProfileView() {
		assertEquals("add", controller.loadAdd(new ExtendedModelMap()));

	}

	@Test
	public void testSavePostRequestSavesPersonReturnsListView() {
		final Person person = new Person();
		when(service.save(person)).thenReturn(person);
		assertEquals("redirect:/person/list/", controller.save(person));
	}

	@Test
	public void testFailureToSaveThrowsError() {
		boolean hasError = false;
		try {
			controller.save(new Person());
		} catch (IllegalArgumentException e) {
			hasError = true;
		}
		assertTrue(hasError);

	}

	@Test
	public void testFindReturnsAddView() {
		assertEquals("add", controller.loadEdit(1L, new ExtendedModelMap()));
	}

	@Test
	public void testLoadListAddsPersonToModel() {
		ExtendedModelMap model = new ExtendedModelMap();
		controller.loadEdit(MOCK_ID, model);
		assertTrue(model.containsKey("person"));

	}

	@Test
	public void testLoadListGetRequestListView() {
		assertEquals("list", controller.loadList(new ExtendedModelMap()));

	}

	@Test
	public void testLoadListAddsListToModel() {
		ExtendedModelMap model = new ExtendedModelMap();
		controller.loadList(model);
		assertTrue(model.containsKey("personList"));

	}

	@Test
	public void testFilterListReturnsListView() {
		assertEquals("list", controller.filteredList("filter", new ExtendedModelMap()));

	}

	@Test
	public void testDeleteRedirectToListView() {
		assertEquals("redirect:/person/list/", controller.deleteById(1L, new ExtendedModelMap()));

	}

	// Detail Tests
	@Test
	public void testDetailsReturnsDetailView() {
		assertEquals("detail", controller.details(1L, new ExtendedModelMap()));
	}

	@Test
	public void testDetailAddsPersonToModel() {
		ExtendedModelMap model = new ExtendedModelMap();
		controller.details(MOCK_ID, model);
		assertTrue(model.containsKey("person"));

	}

}

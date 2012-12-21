package org.daneking.profile.service;

import org.daneking.profile.common.annotations.AppService;
import org.daneking.profile.domain.person.Person;
import org.daneking.profile.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
@AppService
public class PersonService {
	@Autowired
	private PersonRepository personRepository;

	public PersonRepository getPersonRepository() {
		return personRepository;
	}

	public void setPersonRepository(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public <S extends Person> S save(S entity) {
		return personRepository.save(entity);
	}

	public <S extends Person> Iterable<S> save(Iterable<S> entities) {
		return personRepository.save(entities);
	}

	public Person findOne(Long id) {
		return personRepository.findOne(id);
	}

	public boolean exists(Long id) {
		return personRepository.exists(id);
	}

	public Iterable<Person> findAll() {
		return personRepository.findAll();
	}

	public Iterable<Person> findAll(Iterable<Long> ids) {
		return personRepository.findAll(ids);
	}

	public long count() {
		return personRepository.count();
	}

	public void delete(Long id) {
		personRepository.delete(id);
	}

	public void delete(Person entity) {
		personRepository.delete(entity);
	}

	public void delete(Iterable<? extends Person> entities) {
		personRepository.delete(entities);
	}

	public void deleteAll() {
		personRepository.deleteAll();
	}


}

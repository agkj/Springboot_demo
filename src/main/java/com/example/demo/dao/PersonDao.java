package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

public interface PersonDao {

	
	int insertPerson(UUID id, Person person);
	
	default int insertPerson(Person person) {
		
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
		
	}
	
	//search the database to find whether a person has the given ID
	List<Person> selectAllPeople();
	
	
	Optional<Person> selectPersonByID(UUID id);	
	
	int deletePerson(UUID id);
	
	int updatePerson(UUID id, Person person);
	
	
}

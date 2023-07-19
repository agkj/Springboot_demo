package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;


@Repository("fakeDao") // a place where things are being stored
public class FakePersonDataAccessService implements PersonDao{
	
	private static List<Person> DB = new ArrayList<>();
	
	@Override
	public int insertPerson(UUID id, Person person) {
		
		DB.add(new Person(id, person.getName()));
		return 1;
	}

	@Override
	public List<Person> selectAllPeople() {
		
		return DB;
	}

	@Override //search the database to find whether a person has the given ID
	public Optional<Person> selectPersonByID(UUID id) {
		
		return DB.stream().filter(person ->person.getId()
				.equals(id))
				.findFirst();
	}

	@Override
	public int deletePerson(UUID id) {
		
		Optional<Person> personMaybe = selectPersonByID(id);
		
		if(personMaybe.isEmpty()) return 0;
		
		DB.remove(personMaybe.get());
		return 1; 
		
	}

	@Override
	public int updatePerson(UUID id, Person personUpdate) {
		
		return selectPersonByID(id)
				.map(person -> {
					int indexOfPersonToUpdate = DB.indexOf(person);
					if (indexOfPersonToUpdate>= 0) {
						DB.set(indexOfPersonToUpdate, new Person(id, personUpdate.getName()));
						return 1;
					}
					return 0;
				}) 
				.orElse(0);
		
		
		
	}

}
 
package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

public class PersonDataAccessService implements PersonDao {

	@Override
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Person> selectAllPeople() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Person> selectPersonByID(UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public int deletePerson(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

}

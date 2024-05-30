package com.app.busybuzz.services.imp;

import com.app.busybuzz.models.Person;
import com.app.busybuzz.repositories.PersonRepository;
import com.app.busybuzz.services.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceIMP implements IPersonService {


    PersonRepository personRepository;

    public PersonServiceIMP(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Optional<Person> findOneById(Integer id) {
        return personRepository.findById(id);
    }
}

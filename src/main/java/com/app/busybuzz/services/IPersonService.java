package com.app.busybuzz.services;

import com.app.busybuzz.models.Person;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IPersonService {


    Optional<Person> findOneById(Integer id);
}

package com.example;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import com.example.model.Person;
import com.example.repository.PersonRepository;

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @Inject
    PersonRepository repository;

    @GET
    public List<Person> list() {
        return repository.listAll();
    }

    @POST
    @Transactional
    public Person add(Person person) {
        repository.persist(person);
        return person;
    }
}

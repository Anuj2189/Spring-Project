package com.example.demo.controller;

import com.example.demo.entities.Person;
import com.example.demo.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepo;

    @GetMapping
    public List<Person> listAll() {
        return personRepo.findAll();
    }

    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return personRepo.save(person);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        person.setId(id);
        return personRepo.save(person);
    }

    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personRepo.deleteById(id);
    }
}

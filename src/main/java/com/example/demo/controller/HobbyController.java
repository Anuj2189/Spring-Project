package com.example.demo.controller;

import com.example.demo.entities.Hobby;
import com.example.demo.entities.Person;
import com.example.demo.repositories.HobbyRepository;
import com.example.demo.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/hobbies")
public class HobbyController {

    @Autowired
    private HobbyRepository hobbyRepo;

    @Autowired
    private PersonRepository personRepo;

    @PostMapping("/{personId}")
    public Hobby addHobby(@PathVariable Long personId, @RequestBody Hobby hobby) {
        Person person = personRepo.findById(personId).orElseThrow();
        hobby.setPerson(person);
        return hobbyRepo.save(hobby);
    }

    @PutMapping("/{id}")
    public Hobby updateHobby(@PathVariable Long id, @RequestBody Hobby hobby) {
        Hobby existing = hobbyRepo.findById(id).orElseThrow();
        existing.setName(hobby.getName());
        return hobbyRepo.save(existing);
    }

    @DeleteMapping("/{id}")
    public void deleteHobby(@PathVariable Long id) {
        hobbyRepo.deleteById(id);
    }

    @GetMapping("/search")
    public List<Hobby> findByName(@RequestParam String name) {
        return hobbyRepo.findByName(name);
    }
}
package com.example.demo.repositories;

import com.example.demo.entities.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
    List<Hobby> findByName(String name);
}
package com.example.jpa.repositories;

import com.example.jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    List<Author> findAllByFirstName(String fn);
    List<Author> findAllByFirstNameIgnoreCase(String fn);
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstName);
}

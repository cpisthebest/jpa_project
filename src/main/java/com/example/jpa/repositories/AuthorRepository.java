package com.example.jpa.repositories;

import com.example.jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    @Modifying
    @Transactional
    @Query("update Author a set a.age=:age where a.id=:id")
    void updateAuthor(int id,int age);
    @Modifying
    @Transactional
    @Query("update Author a set a.age=:age")
    void updateAllAges(int age);
    List<Author> findByNamedQuery(@Param("age") int age);
    @Modifying
    @Transactional
    void updateNamedQuery(@Param("age") int age);
    List<Author> findAllByFirstName(String fn);
    List<Author> findAllByFirstNameIgnoreCase(String fn);
    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstName);
}

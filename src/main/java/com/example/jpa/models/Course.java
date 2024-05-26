package com.example.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Course extends BaseEntity{
//    @Id
//    @GeneratedValue
//    private Integer id;
    private String name;
    private String description;
    @ManyToMany
    @JoinTable(
            name="authors_courses",
            joinColumns={
                    @JoinColumn(name="course_id"),
            },
            inverseJoinColumns={
                    @JoinColumn(name="author_id")
            }

    )
    private List<Author> authors;
    @OneToMany(mappedBy="course")
    private List<Section> sections;
}
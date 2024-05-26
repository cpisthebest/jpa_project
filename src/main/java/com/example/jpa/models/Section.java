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
public class Section extends BaseEntity{
//    @Id
//    @GeneratedValue
//    private Integer id;
    private String name;
    private int sectionOrder;
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
    @OneToMany(mappedBy="section")
    private List<Lecture> lectures;
}

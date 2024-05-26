package com.example.jpa.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@Entity
public class Lecture extends BaseEntity{
//    @Id
//    @GeneratedValue
//    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name="section_id")
    private Section section;
    /** Start - Unidirectional One To One relationship **/
    @OneToOne
    @JoinColumn(name="resource_id")
    /** End - Unidirectional One To One relationship **/
    private Resource resource;
}

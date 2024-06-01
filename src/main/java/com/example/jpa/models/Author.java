package com.example.jpa.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.jpa.repository.Modifying;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
//@Table(name="AUTHOR_TBL")
@AllArgsConstructor
@SuperBuilder
@NamedQueries(
        {
                @NamedQuery(
                        name="Author.findByNamedQuery",
                        query="select a from Author a where a.age > :age"
                ),

                @NamedQuery(
                        name="Author.updateNamedQuery",
                        query="update Author set age=:age"
                )
        }
)

public class Author extends BaseEntity{
    /** Start : Sequence Generator
    @Id
    @GeneratedValue(
            strategy=GenerationType.SEQUENCE,
            generator="author_sequence"
    )
    @SequenceGenerator(
            name="author_sequence",
            sequenceName="author_sequence",
            allocationSize=1
    )
    /** End : Sequence Generator **/
    /** Start : Table Generator
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    @TableGenerator(name="author_id_gen",
            pkColumnName="id_name",
            valueColumnName="id_value",
            allocationSize=1
    )
    /** End : Table Generator **/
    //private Integer id;
    @Column(name="f_name")
    private String firstName;
    private String lastName;
    @Column(unique=true,
            nullable=false)
    private String email;
    private int age;
    @Column(
            updatable=false,
            nullable=false
    )
    private LocalDateTime createdAt;
    @Column(insertable=false)
    private LocalDateTime updatedAt;
    @ManyToMany(mappedBy="authors" , fetch=FetchType.EAGER)
    private List<Course> courses;
}

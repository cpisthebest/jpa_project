package com.example.jpa.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@EqualsAndHashCode(callSuper=true)
//@PrimaryKeyJoinColumn(name="video_id")
//@DiscriminatorValue("V")
@Polymorphism(type=PolymorphismType.EXPLICIT) //to exclude sub class data from query
public class Video extends Resource{
    private int length;
}

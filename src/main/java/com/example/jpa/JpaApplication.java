package com.example.jpa;

import com.example.jpa.models.Author;
import com.example.jpa.models.Video;
import com.example.jpa.repositories.AuthorRepository;
import com.example.jpa.repositories.VideoRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository authorRepository,
			VideoRepository videoRepository
	){
		return args -> {
			Faker faker = new Faker();
			for(int i=0;i<50;i++) {
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(20,80))
						.email(faker.name().username()+"@gmail.com")
						.createdAt(LocalDateTime.now())
						.build();
				authorRepository.save(author);
			}
//			var video = Video.builder()
//					.name("CP")
//					.length(6)
//					.build();
//			videoRepository.save(video);
			var author = Author.builder()
					.id(1)
					.firstName("CP")
					.lastName("CP")
					.email("cp@gmail.com")
					.age(99999999)
					.createdAt(LocalDateTime.now())
					.build();
			authorRepository.save(author);
		};
	}
}

package com.example.jpa;

import com.example.jpa.models.Author;
import com.example.jpa.models.Video;
import com.example.jpa.repositories.AuthorRepository;
import com.example.jpa.repositories.VideoRepository;
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
//			var author = Author.builder()
//					.firstName("Chandra")
//					.lastName("Prabha")
//					.age(10000)
//					.email("cp@gmail.com")
//					.createdAt(LocalDateTime.now())
//					.build();
//			authorRepository.save(author);
			var video = Video.builder()
					.name("CP")
					.length(6)
					.build();
			videoRepository.save(video);
		};
	}
}

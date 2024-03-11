package com.jpa.JpaApp;

import com.jpa.JpaApp.models.Video;
import com.jpa.JpaApp.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaAppApplication {

	public static void main(String[] args) {


		SpringApplication.run(JpaAppApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(VideoRepository videoRepository){
		return args -> {
			var video= Video.builder()
					.name("abc")
					.length(5)
					.build();
			videoRepository.save(video);
		};
	}

}

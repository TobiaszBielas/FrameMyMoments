package com.frameMyMoments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FrameMyMomentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrameMyMomentsApplication.class, args);
	}

}

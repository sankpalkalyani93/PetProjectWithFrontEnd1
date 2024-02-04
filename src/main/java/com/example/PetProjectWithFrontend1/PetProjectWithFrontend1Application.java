package com.example.PetProjectWithFrontend1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PetProjectWithFrontend1Application {

	public static void main(String[] args) {
		SpringApplication.run(PetProjectWithFrontend1Application.class, args);
		Pet p = new Pet();
		p.setBreed("lab");
		System.out.println(p.getBreed());
	}

}

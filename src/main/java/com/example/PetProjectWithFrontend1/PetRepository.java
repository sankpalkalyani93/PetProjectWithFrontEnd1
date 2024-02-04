package com.example.PetProjectWithFrontend1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
public interface PetRepository extends JpaRepository<Pet, Long>{

}

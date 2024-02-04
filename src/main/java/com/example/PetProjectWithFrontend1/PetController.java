package com.example.PetProjectWithFrontend1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
@RequestMapping("/api/pets")
public class PetController {

	@Autowired
	private PetRepository petRepository;

	@GetMapping			// --------------- Read Operation -------------
	public List<Pet> getAllPets(){
		return petRepository.findAll();
	}
	
	@GetMapping("/{id}")		// --------------- Read Operation -------------
	public Pet getPetById(@PathVariable Long id){
		return petRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pet not found"));
	}
	
	@PostMapping		// --------------- Create Operation -----------
	public Pet createPet(@RequestBody Pet pet) {
		return petRepository.save(pet);
	}
	
	
}
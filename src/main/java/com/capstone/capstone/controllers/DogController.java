package com.capstone.capstone.controllers;

import com.capstone.capstone.models.Dog;
import com.capstone.capstone.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DogController {
    @Autowired
    DogRepository dogRepository;

    @GetMapping(value = "/dogs")
    public ResponseEntity<List<Dog>> getAllDogs(){
        return new ResponseEntity<>(dogRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/dogs/{id}")
    public ResponseEntity getDog(@PathVariable Long id){
        return new ResponseEntity<>(dogRepository.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/dogs/{id}")
    public ResponseEntity<Dog> deleteDog(@PathVariable Long id){
        Optional<Dog> dogToDelete = dogRepository.findById(id);
        dogRepository.delete(dogToDelete.get());
        return new ResponseEntity<>(dogToDelete.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/dogs")
    public ResponseEntity<Dog> postDog(@RequestBody Dog dog){
        dogRepository.save(dog);
        return new ResponseEntity<>(dog, HttpStatus.CREATED);
    }

    //@PutMapping <-- To complete
}

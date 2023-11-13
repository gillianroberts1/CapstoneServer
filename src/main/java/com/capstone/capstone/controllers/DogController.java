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

    @PutMapping(value = "/dogs/{id}")
    public ResponseEntity<Dog> updateDog(@RequestBody Dog updatedDog, @PathVariable Long id){
        Dog existingDog = dogRepository.findById(id).get();
        if(existingDog.getName() != null) {
            existingDog.setName(updatedDog.getName());
        }
        if(existingDog.getGender() != null) {
            existingDog.setGender(updatedDog.getGender());
        }
        if(existingDog.getBreed() != null) {
            existingDog.setBreed(updatedDog.getBreed());
        }
        if(existingDog.getUser() != null) {
            existingDog.setUser(updatedDog.getUser());
        }
        if(existingDog.getAge() != null) {
            existingDog.setAge(updatedDog.getAge());
        }
        if(existingDog.getPhotoURL() != null) {
            existingDog.setPhotoURL(updatedDog.getPhotoURL());
        }
        if(existingDog.getNeutered() != null) {
            existingDog.setNeutered(updatedDog.getNeutered());
        }
        if(existingDog.getLeash() != null) {
            existingDog.setLeash(updatedDog.getLeash());
        }
        if(existingDog.getVaccinated() != null) {
            existingDog.setVaccinated(updatedDog.getVaccinated());
        }
        if(existingDog.getRating() != null) {
            existingDog.setRating(updatedDog.getRating());
        }
//        if(existingDog.getWalkies() != null) {
//            existingDog.setWalkies(updatedDog.getWalkies());
//        }
//        if(existingDog.getGroupWalkies() != null) {
//            existingDog.setGroupWalkies(updatedDog.getGroupWalkies());
//        }
        dogRepository.save(existingDog);
        return new ResponseEntity<>(existingDog, HttpStatus.OK);
    }
}

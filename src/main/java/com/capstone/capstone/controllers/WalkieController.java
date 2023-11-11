package com.capstone.capstone.controllers;

import com.capstone.capstone.models.Walkie;
import com.capstone.capstone.repository.WalkieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WalkieController {

    @Autowired
    WalkieRepository walkieController;


    @GetMapping(value = "/walkies")
    public ResponseEntity<List<Walkie>> getALlWalkies(){
        return new ResponseEntity<>(walkieController.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/walkies/{id}")
    public ResponseEntity getWalkie(@PathVariable Long id){
        return new ResponseEntity<>(walkieController.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/walkies/{id}")                 // ADDED
    public ResponseEntity<Walkie> deleteWalkie(@PathVariable Long id) {
        Optional<Walkie> walkieToDelete = walkieController.findById(id);
        walkieController.delete(walkieToDelete.get());
        return new ResponseEntity<>(walkieToDelete.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/walkies")
    public ResponseEntity<Walkie> postWalkie(@RequestBody Walkie walkie){
        walkieController.save(walkie);
        return new ResponseEntity<>(walkie, HttpStatus.CREATED);
    }

    //@PutMapping <-- To Complete
}

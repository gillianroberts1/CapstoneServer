package com.capstone.capstone.controllers;

import com.capstone.capstone.models.Location;
import com.capstone.capstone.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationController {

    @Autowired
    LocationRepository locationRepository;


    @GetMapping(value = "/locations")
    public ResponseEntity<List<Location>> getAllLocations(){
        return new ResponseEntity<>(locationRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/locations/{id}")
    public ResponseEntity getLocation(@PathVariable Long id){
        return new ResponseEntity<>(locationRepository.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/locations/{id}")
    public ResponseEntity<Location> deleteLocation(@PathVariable Long id) {
        Optional<Location> locationToDelete = locationRepository.findById(id);
        locationRepository.delete(locationToDelete.get());
        return new ResponseEntity<>(locationToDelete.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/locations")
    public ResponseEntity<Location> postLocation(@RequestBody Location location){
        locationRepository.save(location);
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }

    //@PutMapping <-- To be Completed
}

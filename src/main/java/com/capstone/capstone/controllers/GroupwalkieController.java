package com.capstone.capstone.controllers;

import com.capstone.capstone.models.GroupWalkie;
import com.capstone.capstone.repository.GroupwalkieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GroupwalkieController {
    @Autowired
    GroupwalkieRepository groupwalkieRepository;


    @GetMapping(value = "/groupwalkies")
    public ResponseEntity<List<GroupWalkie>> getAllGroupWalkies(){
        return new ResponseEntity<>(groupwalkieRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/groupwalkies/{id}")
    public ResponseEntity getGroupWalkie(@PathVariable Long id){
        return new ResponseEntity<>(groupwalkieRepository.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/groupwalkies/{id}")
    public ResponseEntity<GroupWalkie> deleteGroupWalkie(@PathVariable Long id) {
        Optional<GroupWalkie> groupWalkieToDelete = groupwalkieRepository.findById(id);
        groupwalkieRepository.delete(groupWalkieToDelete.get());
        return new ResponseEntity<>(groupWalkieToDelete.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/groupwalkies")
    public ResponseEntity<GroupWalkie> postGroupWalkie(@RequestBody GroupWalkie groupWalkie){
        groupwalkieRepository.save(groupWalkie);
        return new ResponseEntity<>(groupWalkie, HttpStatus.CREATED);
    }

    @PutMapping(value = "/groupwalkies/{id}")
    public ResponseEntity<GroupWalkie> updateGroupWalkie(@RequestBody GroupWalkie updatedGroupWalkie, @PathVariable Long id){
        GroupWalkie existingGroupWalkie = groupwalkieRepository.findById(id).get();
        if(updatedGroupWalkie.getName() != null) {
            existingGroupWalkie.setName(updatedGroupWalkie.getName());
        }
        if(updatedGroupWalkie.getDate() != null) {
            existingGroupWalkie.setDate(updatedGroupWalkie.getDate());
        }
        if(updatedGroupWalkie.getDistance() != null) {
            existingGroupWalkie.setDistance(updatedGroupWalkie.getDistance());
        }
        if(updatedGroupWalkie.getDuration() != null) {
            existingGroupWalkie.setDuration(updatedGroupWalkie.getDuration());
        }
        if(updatedGroupWalkie.getUsers() != null) {
            existingGroupWalkie.setUsers(updatedGroupWalkie.getUsers());
        }
        groupwalkieRepository.save(existingGroupWalkie);
        return new ResponseEntity<>(existingGroupWalkie, HttpStatus.OK);
    }
}

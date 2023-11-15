package com.capstone.capstone.controllers;

import com.capstone.capstone.models.NotificationDto;
import com.capstone.capstone.models.User;
import com.capstone.capstone.models.Notification;
import com.capstone.capstone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/users/uid/{uid}")
    public ResponseEntity<User> getUserByUid(@PathVariable String uid){
        User user = userRepository.findByUid(uid);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/users/{id}/favourites/{favId}")
    public ResponseEntity<User> addFavouriteToUser(@PathVariable Long id, @PathVariable Long favId){
        Optional<User> userOptional = userRepository.findById(id);
        Optional<User> favUserOptional = userRepository.findById(favId);
        if(userOptional.isPresent() && favUserOptional.isPresent()) {
            User user = userOptional.get();
            User favUser = favUserOptional.get();
            user.addFavourite(favUser);
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/users/{id}/favourites/{favUserId}")
    public ResponseEntity<User> removeFavouriteFromUser(@PathVariable Long id, @PathVariable Long favUserId){
        Optional<User> userOptional = userRepository.findById(id);
        Optional<User> favUserOptional = userRepository.findById(favUserId);

        if(userOptional.isPresent() && favUserOptional.isPresent()) {
            User user = userOptional.get();
            User favUser = favUserOptional.get();

            if (user.getFavourites().contains(favUser)) {
                user.removeFavourite(favUser);
                userRepository.save(user);
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        Optional<User> userToDelete = userRepository.findById(id);
        userRepository.delete(userToDelete.get());
        return new ResponseEntity<>(userToDelete.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/users", consumes = {"application/xml","application/json"})
    public ResponseEntity<User> createUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

//    @PostMapping(value = "/users/{id}/notifications")
//    public ResponseEntity<User> addNotificationToUser(@PathVariable Long id, @RequestBody Notification notification){
//        Optional<User> userOptional = userRepository.findById(id);
//        if(userOptional.isPresent()) {
//            User user = userOptional.get();
//            user.addNotification(notification);
//            userRepository.save(user);
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @PostMapping(value = "/users/{id}/notifications")
    public ResponseEntity<User> addNotificationToUser(@PathVariable Long id, @RequestBody NotificationDto notificationDto){
        Optional<User> userOptional = userRepository.findById(id);
        Optional<User> senderOptional = userRepository.findById(notificationDto.getSenderId());

        if(userOptional.isPresent() && senderOptional.isPresent()) {
            User user = userOptional.get();
            User sender = senderOptional.get();

            Notification notification = new Notification(notificationDto.getEntries(), user, sender);
            user.addNotification(notification);
            userRepository.save(user);

            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User updatedUser, @PathVariable Long id){
        User existingUser = userRepository.findById(id).get();
        if(updatedUser.getAge() != null) {
            existingUser.setAge(updatedUser.getAge());
        }
        if(updatedUser.getGender() != null) {
            existingUser.setGender(updatedUser.getGender());
        }
        if(updatedUser.getArea() != null) {
            existingUser.setArea(updatedUser.getArea());
        }
        if(updatedUser.getFirstName() != null) {
            existingUser.setFirstName(updatedUser.getFirstName());
        }
        if(updatedUser.getLastName() != null) {
            existingUser.setLastName(updatedUser.getLastName());
        }
        if(updatedUser.getDogs() != null) {
            existingUser.setDogs(updatedUser.getDogs());
        }
        if(updatedUser.getGroupWalkies() != null) {
            existingUser.setGroupWalkies(updatedUser.getGroupWalkies());
        }
        if(updatedUser.getWalkies() != null) {
            existingUser.setWalkies(updatedUser.getWalkies());
        }
        if(updatedUser.getPhotoURL() != null) {
            existingUser.setPhotoURL(updatedUser.getPhotoURL());
        }
        if(updatedUser.getTotalDistance() != null) {
            existingUser.setTotalDistance(updatedUser.getTotalDistance());
        }
        userRepository.save(existingUser);
        return new ResponseEntity<>(existingUser, HttpStatus.OK);
    }
}

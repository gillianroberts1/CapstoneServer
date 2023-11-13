package com.capstone.capstone.components;


import com.capstone.capstone.enums.Area;
import com.capstone.capstone.enums.Breed;
import com.capstone.capstone.enums.GlasgowPark;
import com.capstone.capstone.models.*;
import com.capstone.capstone.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;

//@Profile("!test")
//@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DogRepository dogRepository;

    @Autowired
    GroupwalkieRepository groupwalkieRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    WalkieRepository walkieRepository;

    @Autowired
    NotificationRepository notificationRepository;

    public  DataLoader(){
    }

    public  void run(ApplicationArguments args){
        User user1 = new User("John", "Doe", "johndoe@gmail.com");
        userRepository.save(user1);
        User user2 = new User("Mary", "Johnson", "maryjohnson@gmail.com");
        userRepository.save(user2);
        User user3 = new User("James", "Brown", "jamesbrown@gmail.com");
        userRepository.save(user3);
        User user4 = new User("Lisa", "Miller", "lisamiller@gmail.com");
        userRepository.save(user4);
        User user5 = new User("Sarah", "Davis", "sarahdavis@gmail.com");
        userRepository.save(user5);
        User user6 = new User("Michael", "Wilson", "michaelwilson@gmail.com");
        userRepository.save(user6);
        User user7 = new User("Emily", "Martinez", "emilymartinez@gmail.com");
        userRepository.save(user7);
        User user8 = new User("William", "Mule", "williammule@gmail.com");
        userRepository.save(user8);
        User user9 = new User("Olivia", "Anderson", "oliviaanderson@gmail.com");
        userRepository.save(user9);
        User user10 = new User("David", "Johnson", "davidjohnson@gmail.com");
        userRepository.save(user10 );


        Dog dog1 = new Dog("Becky", "female", Breed.CHIHUAHUA, user1);
        dogRepository.save(dog1);
        Dog dog2 = new Dog("Max", "male", Breed.LABRADOR, user1);
        dogRepository.save(dog2);
        Dog dog3 = new Dog("Bella", "female", Breed.BULLDOG, user3);
        dogRepository.save(dog3);
        Dog dog4 = new Dog("Rocky", "male", Breed.GOLDENRETRIEVER, user4);
        dogRepository.save(dog4);
        Dog dog5 = new Dog("Lucy", "female", Breed.POMERANIAN, user5);
        dogRepository.save(dog5);
        Dog dog6 = new Dog("Charlie", "male", Breed.GERMANSHEPHERD, user6);
        dogRepository.save(dog6);
        Dog dog7 = new Dog("Daisy", "female", Breed.DACHSHUND, user7);
        dogRepository.save(dog7);
        Dog dog8 = new Dog("Cooper", "male", Breed.BEAGLE, user8);
        dogRepository.save(dog8);
        Dog dog9 = new Dog("Lola", "female", Breed.POODLE, user9);
        dogRepository.save(dog9);
        Dog dog10 = new Dog("Tucker", "male", Breed.ROTTWEILER, user10);
        dogRepository.save(dog10);


        Location location1 = new Location(GlasgowPark.BARROWLAND);
        locationRepository.save(location1);
        Location location2 = new Location(GlasgowPark.BOTANIC);
        locationRepository.save(location2);
        Location location3 = new Location(GlasgowPark.ALEXANDRA);
        locationRepository.save(location3);
        Location location4 = new Location(GlasgowPark.GLASGOWGREEN);
        locationRepository.save(location4);
        Location location5 = new Location(GlasgowPark.QUEENS);
        locationRepository.save(location5);
        Location location6 = new Location(GlasgowPark.KELVINGROVE);
        locationRepository.save(location6);
        Location location7 = new Location(GlasgowPark.NEWLANDSK);
        locationRepository.save(location7);
        Location location8 = new Location(GlasgowPark.MAXWELL);
        locationRepository.save(location8);
        Location location9 = new Location(GlasgowPark.RIVERVIEW);
        locationRepository.save(location9);
        Location location10 = new Location(GlasgowPark.SPRINGBURN);
        locationRepository.save(location10);


        Walkie walkie1 = new Walkie("21-11-2023", location1);
        walkie1.addUser(user1);
        walkie1.addUser(user2);
        walkieRepository.save(walkie1);
        Walkie walkie2 = new Walkie("03-12-2023", location2);
        walkie2.addUser(user3);
        walkieRepository.save(walkie2);
        Walkie walkie3 = new Walkie("01-01-2024", location3);
        walkieRepository.save(walkie3);
        Walkie walkie4 = new Walkie("10-01-2024", location4);
        walkieRepository.save(walkie4);

        GroupWalkie groupWalkie1 = new GroupWalkie("Puppy Walk", location1, "12-11-2023", 2.1, 60);
        groupwalkieRepository.save(groupWalkie1);
        GroupWalkie groupWalkie2 = new GroupWalkie("Big Dog Walk", location3, "22-11-2023", 3.1, 60);
        groupwalkieRepository.save(groupWalkie2);
        GroupWalkie groupWalkie3 = new GroupWalkie("Winky Walk", location2, "26-11-2023", 4.1, 60);
        groupwalkieRepository.save(groupWalkie3);

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("Location", "Kelvingrove");
        map1.put("Date", "Tomorrow");
        map1.put("Message", "Hey! Would you like to go on a walk with me tomorrow?");
        Notification park = new Notification(map1);


        user1.addDog(dog1);
        user1.addDog(dog2);
        user1.addWalkie(walkie1);
        user1.addGropuWalkie(groupWalkie1);
        user1.addNotification(park);
        userRepository.save(user1);

        user2.addDog(dog3);
        user2.addWalkie(walkie2);
        user2.addGropuWalkie(groupWalkie2);
        userRepository.save(user2);

        user3.addDog(dog4);
        user3.addWalkie(walkie3);
        user3.addGropuWalkie(groupWalkie3);
        userRepository.save(user3);

        user4.addWalkie(walkie4);
        user4.addDog(dog5);
        userRepository.save(user4);

        dog1.addWalkie(walkie1);
        dogRepository.save(dog1);
//
        dog2.addWalkie(walkie2);
        dogRepository.save(dog2);
//
        dog3.addWalkie(walkie3);
        dogRepository.save(dog3);
//
        dog4.addWalkie(walkie4);
        dogRepository.save(dog4);

        groupWalkie1.addUser(user1);
        groupWalkie1.addUser(user2);
        groupWalkie1.addDog(dog1);
        groupWalkie1.addDog(dog2);
        groupwalkieRepository.save(groupWalkie1);
        groupWalkie2.addUser(user3);
        groupWalkie2.addDog(dog3);
        groupwalkieRepository.save(groupWalkie2);
        groupWalkie3.addUser(user4);
        groupWalkie3.addUser(user5);
        groupWalkie3.addUser(user6);
        groupWalkie3.addDog(dog4);
        groupWalkie3.addDog(dog5);
        groupwalkieRepository.save(groupWalkie3);



    }

}

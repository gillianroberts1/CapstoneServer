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

@Profile("!test")
@Component
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
        User user2 = new User("William", "Mule", "williammule@gmail.com");
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
        User user8 = new User("Mary", "Johnson", "maryjohnson@gmail.com");
        userRepository.save(user8);
        User user9 = new User("Olivia", "Anderson", "oliviaanderson@gmail.com");
        userRepository.save(user9);
        User user10 = new User("David", "Johnson", "davidjohnson@gmail.com");
        userRepository.save(user10 );
        User user11 = new User("Emmanuel", "Barinia", "debion@gmail.com");
        userRepository.save(user11);
        User user12 = new User("Adrianna", "Gladkowska", "adusia@gmail.com");
        userRepository.save(user12);
        User user13 = new User("Daniel", "Woods", "daniel@gmail.com");
        userRepository.save(user13);
        User user14 = new User("Samantha", "Gillies", "sam@gmail.com");
        userRepository.save(user14);
        User user15 = new User("Gillian", "Roberts", "gilly@hotmail.com");
        userRepository.save(user15);
        User user16 = new User("Ibrahim", "Abubakar", "ibrahim@gmail.com");
        userRepository.save(user16);
        User user17 = new User("Cameron", "Lochran", "cameron@gmail.com");
        userRepository.save(user17);


        Dog dog1 = new Dog("Becky", "female", "Chihuahua", user1);
        dog1.setRating(3);
        dogRepository.save(dog1);
        Dog dog2 = new Dog("Max", "male", "Labrador", user1);
        dog2.setRating(4);
        dogRepository.save(dog2);
        Dog dog3 = new Dog("Bella", "female", "Bulldog", user3);
        dog3.setRating(1);
        dogRepository.save(dog3);
        Dog dog4 = new Dog("Rocky", "male", "Golden Retriever", user4);
        dog4.setRating(5);
        dogRepository.save(dog4);
        Dog dog5 = new Dog("Lucy", "female", "Pomeranian", user5);
        dog2.setRating(4);
        dogRepository.save(dog5);
        Dog dog6 = new Dog("Charlie", "male", "German Shepherd", user6);
        dog6.setRating(3);
        dogRepository.save(dog6);
        Dog dog7 = new Dog("Daisy", "female", "Dachshund", user7);
        dog7.setRating(3);
        dogRepository.save(dog7);
        Dog dog8 = new Dog("Cooper", "male", "Beagle", user8);
        dog8.setRating(5);
        dogRepository.save(dog8);
        Dog dog9 = new Dog("Lola", "female", "Poodle", user9);
        dog9.setRating(2);
        dogRepository.save(dog9);
        Dog dog10 = new Dog("Tucker", "male", "Rottweiler", user10);
        dog10.setRating(5);
        dogRepository.save(dog10);
        Dog dog11 = new Dog("Nala", "female", "Staffie", user11);
        dog11.setRating(4);
        dogRepository.save(dog11);
        Dog dog12 = new Dog("Carmen", "female", "Chihuahua", user15);
        dog12.setRating(5);
        dogRepository.save(dog12);
        Dog dog13 = new Dog("Lilly", "female", "Shih Tzu", user14);
        dog13.setRating(4);

        dog11.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/dogs%2FIMG_1326.jpeg?alt=media&token=97f97956-11e3-4392-b4ac-1af29bbf5364");
        dogRepository.save(dog11);
        dog12.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/dogs%2FIMG_5069.jpeg?alt=media&token=40d79016-76ce-4850-9f9a-08c4d6e28f43");
        dogRepository.save(dog12);
        dog13.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/dogs%2FIMG_2249.jpg?alt=media&token=a101c0c8-45d6-42dd-8c36-5769818d283a");
        dogRepository.save(dog13);
        dog1.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/carmen?alt=media&token=b2e9b1a0-e8b3-469a-839e-b07978b4e324");
        dogRepository.save(dog1);
        dog2.setPhotoURL("https://images.unsplash.com/photo-1561495376-dc9c7c5b8726?q=80&w=3022&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        dogRepository.save(dog2);
        dog3.setPhotoURL("https://images.unsplash.com/photo-1568315056770-f4a63027dcd3?q=80&w=4000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        dogRepository.save(dog3);
        dog4.setPhotoURL("https://www.indiantrailanimalhospital.com/sites/default/files/styles/large/public/golden-retriever-dog-breed-info.jpg?itok=KAq2A33j");
        dogRepository.save(dog4);
        dog5.setPhotoURL("https://images.unsplash.com/photo-1587402092301-725e37c70fd8?q=80&w=2752&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        dogRepository.save(dog5);
        dog6.setPhotoURL("https://images.unsplash.com/photo-1605725657590-b2cf0d31b1a5?q=80&w=2624&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        dogRepository.save(dog6);
        dog7.setPhotoURL("https://images.unsplash.com/photo-1567430768147-1cecada89aa7?q=80&w=2468&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        dogRepository.save(dog7);
        dog8.setPhotoURL("https://plus.unsplash.com/premium_photo-1663127048434-84db6f90f08d?q=80&w=2635&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");
        dogRepository.save(dog8);
        dog9.setPhotoURL("https://images.unsplash.com/photo-1581562324420-eff2f5aaa4b5?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8cG9vZGxlfGVufDB8fDB8fHww");
        dogRepository.save(dog9);
        dog10.setPhotoURL("https://images.unsplash.com/photo-1598819849325-f0152d605b08?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8cm90dHdlaWxlcnxlbnwwfHwwfHx8MA%3D%3D");
        dogRepository.save(dog10);


//        Location location1 = new Location(GlasgowPark.BARROWLAND);
//        locationRepository.save(location1);
//        Location location2 = new Location(GlasgowPark.BOTANIC);
//        locationRepository.save(location2);
//        Location location3 = new Location(GlasgowPark.ALEXANDRA);
//        locationRepository.save(location3);
//        Location location4 = new Location(GlasgowPark.GLASGOWGREEN);
//        locationRepository.save(location4);
//        Location location5 = new Location(GlasgowPark.QUEENS);
//        locationRepository.save(location5);
//        Location location6 = new Location(GlasgowPark.KELVINGROVE);
//        locationRepository.save(location6);
//        Location location7 = new Location(GlasgowPark.NEWLANDSK);
//        locationRepository.save(location7);
//        Location location8 = new Location(GlasgowPark.MAXWELL);
//        locationRepository.save(location8);
//        Location location9 = new Location(GlasgowPark.RIVERVIEW);
//        locationRepository.save(location9);
//        Location location10 = new Location(GlasgowPark.SPRINGBURN);
//        locationRepository.save(location10);


//        Walkie walkie1 = new Walkie("21-11-2023", "Maxwell");
//        walkie1.addUser(user1);
//        walkie1.addUser(user2);
//        walkieRepository.save(walkie1);
//        Walkie walkie2 = new Walkie("03-12-2023", "Springburn");
//        walkie2.addUser(user3);
//        walkieRepository.save(walkie2);
//        Walkie walkie3 = new Walkie("01-01-2024", "Kelvingrove");
//        walkieRepository.save(walkie3);
//        Walkie walkie4 = new Walkie("10-01-2024", "Queens Park");
//        walkieRepository.save(walkie4);

        GroupWalkie groupWalkie1 = new GroupWalkie("Puppy Walk", "Glasgow Green", "2023-11-22T11:30", 2.1, 60);
        groupwalkieRepository.save(groupWalkie1);
        GroupWalkie groupWalkie2 = new GroupWalkie("Big Dog Walk", "Kelvinbridge", "2023-12-10T16:15", 3.1, 60);
        groupwalkieRepository.save(groupWalkie2);
        GroupWalkie groupWalkie3 = new GroupWalkie("Winky Walk", "Queens Park", "2023-12-22T13:15", 4.1, 60);
        groupwalkieRepository.save(groupWalkie3);


        user1.addDog(dog1);
        user1.addDog(dog2);
        user1.setPhotoURL("https://images.unsplash.com/photo-1590086782957-93c06ef21604?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8Z3V5JTIwcG9ydHJhaXR8ZW58MHx8MHx8fDA%3D");
        user1.addGropuWalkie(groupWalkie1);
        user1.setAge(28);
        user1.setGender("Male");
        user1.setArea("Glasgow South");
        user1.setTotalDistance(29);
        userRepository.save(user1);

        user2.addDog(dog3);
        user2.addGropuWalkie(groupWalkie2);
        user2.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/John1699794348928?alt=media&token=3ea87b06-be9e-4a46-b46e-0a01ce05fccb");
        user2.setAge(28);
        user2.setGender("Male");
        user2.setArea("Glasgow North");
        user2.setTotalDistance(49);
        userRepository.save(user2);

        user3.addDog(dog4);
        user3.addGropuWalkie(groupWalkie3);
        user3.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/John1699819163699?alt=media&token=f7118e25-74f6-4b27-8e7e-9d79bb5b22b7");
        user3.setAge(25);
        user3.setGender("Male");
        user3.setArea("Glasgow East");
        user3.setTotalDistance(87);
        userRepository.save(user3);

        user4.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/Mary1699794434729?alt=media&token=bb898480-1ef0-41f2-aa09-d470662dbe97");
        user4.addDog(dog5);
        user4. setAge(29);
        user4.setGender("Female");
        user4.setArea("Glasgow West");
        user4.setTotalDistance(2);
        userRepository.save(user4);

        user5.setPhotoURL("https://content.fortune.com/wp-content/uploads/2015/04/purdie-vaughns-photo.jpeg?w=1440&q=75");
        user5.addDog(dog6);
        user5.setAge(31);
        user5.setGender("Female");
        user5.setArea("Glasgow South");
        user5.setTotalDistance(67);
        userRepository.save(user5);

        user6.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/Michael1699795013298?alt=media&token=023ea120-4d02-4e1e-aa6c-b0649cfaedcf");
        user6.addDog(dog7);
        user6.setAge(29);
        user6.setGender("Male");
        user6.setArea("Glasgow North");
        user5.setTotalDistance(26);
        userRepository.save(user6);

        user7.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/rachel1699879897797?alt=media&token=c5a1372c-658b-4ddb-8542-d9c22c522a26");
        user7.addDog(dog8);
        user7.setAge(24);
        user7.setArea("Female");
        user7.setArea("Glasgow East");
        user5.setTotalDistance(129);
        userRepository.save(user7);

        user8.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/stephanie1699880471562?alt=media&token=d65ec56b-1a6f-4ec7-b034-630406da1bd5");
        user8.addDog(dog9);
        user8.setAge(33);
        user8.setArea("Glasgow West");
        user8.setGender("Female");
        user5.setTotalDistance(42);
        userRepository.save(user8);

        user9.setPhotoURL("https://images.squarespace-cdn.com/content/v1/5db436e571d345740a743f83/1586646363791-T6T8WHU7GRG0VNI9Y256/Me%2Bn%2Bb.jpg?format=2500w");
        user9.addDog(dog10);
        user9.setAge(19);
        user9.setGender("Female");
        user9.setArea("Glasgow South");
        user5.setTotalDistance(81);
        userRepository.save(user9);

        user10.setPhotoURL("https://static.independent.co.uk/2023/05/18/10/pets.jpg?quality=75&width=990&crop=3%3A2%2Csmart&auto=webp");
        user10.setAge(28);
        user10.setArea("Glasgow North");
        user10.setGender("Male");
        user5.setTotalDistance(29);
        userRepository.save(user10);

        user11.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/DSCF3264-Enhanced-RD.jpg?alt=media&token=8b99a70f-749e-47f2-b40c-54d134f76073");
        user11.setAge(33);
        user11.setUid("qksfnDH8OLdoUKcYSAs6RWKJoRP2");
        user11.setGender("Male");
        user11.setArea("Falkirk");
        user5.setTotalDistance(43);
        userRepository.save(user11);

        user12.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/Adrianna1699745447467?alt=media&token=87e4ace0-d184-4452-b5e1-8d37e0e2c838");
        user12.setAge(21);
        user12.setUid("yoNMOJRj7YSPsS8gv6m0n1TP2722");
        user12.setArea("Falkirk");
        user12.setGender("Female");
        user5.setTotalDistance(34);
        userRepository.save(user12);

        user13.setUid("fWFzKIUu8beKiZjAUqPftSifUfJ3");
        user13.setAge(27);
        user13.setPhotoURL("https://www.unitedagents.co.uk/sites/default/files/thumbnails/image/guybolton-photo-deadline.jpg");
        user13.setGender("Male");
        user13.setArea("Glasgow East");
        user5.setTotalDistance(78);
        userRepository.save(user13);

        user14.setUid("lVteD5IvwUSIeIBBGjwNW87m6383");
        user14.setAge(21);
        user14.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/Samantha1700055289266?alt=media&token=2a4c9a3a-f5c0-44d7-beec-f2b4a5da491c");
        user14.setGender("Female");
        user14.setArea("Kilmarnock");
        user5.setTotalDistance(241);
        userRepository.save(user14);

        user15.setUid("iUU2g1k4lAMmtJBhS7twOZo5lX43");
        user15.setAge(21);
        user15.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/Gillian1700055477272?alt=media&token=4d3fc8a0-c980-45fb-91e3-23ec5e9ea758");
        user15.setArea("Glasgow South");
        user15.setGender("Female");
        user5.setTotalDistance(91);
        userRepository.save(user15);

        user16.setAge(18);
        user16.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/IMG_0614.jpg?alt=media&token=873ba9a1-0c28-4edf-b7d2-cd7522b80df5");
        user16.setArea("Birmingham :(");
        user16.setGender("Male");
        user5.setTotalDistance(48);
        userRepository.save(user16);

        user17.setAge(19);
        user17.setPhotoURL("https://firebasestorage.googleapis.com/v0/b/chat-84fb4.appspot.com/o/IMG_6722.jpg?alt=media&token=5dfbc1e4-eba2-41f2-86ff-c358493445a5");
        user17.setArea("Glasgow East");
        user5.setTotalDistance(0);
        userRepository.save(user17);

        groupWalkie1.addUser(user1);
        groupWalkie1.addUser(user2);
        groupWalkie1.addUser(user7);
        groupWalkie1.addUser(user8);
        groupWalkie1.setPhotoURL("https://images.unsplash.com/photo-1622050956578-94fd044a0ada?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OHx8a2VsdmluZ3JvdmUlMjBwYXJrfGVufDB8fDB8fHww");
        groupwalkieRepository.save(groupWalkie1);
        groupWalkie2.addUser(user3);
        groupWalkie2.addUser(user9);
        groupWalkie2.addUser(user10);
        groupWalkie2.setPhotoURL("https://images.unsplash.com/photo-1564409972016-2825589beaed?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8UXVlZW5zJTIwUGFyayUyMGdsYXNnb3d8ZW58MHx8MHx8fDA%3D");
        groupwalkieRepository.save(groupWalkie2);
        groupWalkie3.addUser(user4);
        groupWalkie3.addUser(user5);
        groupWalkie3.addUser(user6);
        groupWalkie3.setPhotoURL("https://images.unsplash.com/photo-1642251940454-86335f9dc133?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTV8fGdsYXNnb3clMjBwYXJrfGVufDB8fDB8fHww");
        groupwalkieRepository.save(groupWalkie3);
    }

}

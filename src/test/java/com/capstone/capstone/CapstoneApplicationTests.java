package com.capstone.capstone;

import com.capstone.capstone.enums.Area;
import com.capstone.capstone.enums.Breed;
import com.capstone.capstone.enums.GlasgowPark;
import com.capstone.capstone.models.*;
import com.capstone.capstone.repository.*;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class CapstoneApplicationTests {

	@Autowired
	DogRepository dogRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	WalkieRepository walkieRepository;

	@Autowired
	GroupwalkieRepository groupwalkieRepository;

	@Autowired
	NotificationRepository notificationRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void canCreateUserAndSave(){
//		User john = new User("John", "Doe", "johndoe@gmail.com");
//		userRepository.save(john);
//	}
//
//	@Test
//	public void canCreateDogAndSave(){
//		User john = new User("John", "Doe", "johndoe@gmail.com");
//		userRepository.save(john);
//		Dog gaston = new Dog("Gaston", "male", "DOBERMAN", john);
//		dogRepository.save(gaston);
//
//	}
//
//	@Test
//	public void canAssignDogToUser(){
//		User john = new User("John", "Doe", "johndoe@gmail.com");
//		Dog gaston = new Dog("Gaston", "male", "DOBERMAN", john);
//		john.addDog(gaston);
//		userRepository.save(john);
//	}
//
//
//	@Test
//	public void canCreateLocationAndAddUserAndDogAndSave(){
//		Location kelvingrove = new Location(GlasgowPark.KELVINGROVE);
//		locationRepository.save(kelvingrove);
//		User john = new User("John", "Doe", "johndoe@gmail.com");
//		userRepository.save(john);
//		Dog gaston = new Dog("Gaston", "male", "DOBERMAN", john);
//		dogRepository.save(gaston);
//	}
//
//	@Test
//	public void canCreateWalkieAndAddDogAndUserAndSave(){
//		User john = new User("John", "Doe", "johndoe@gmail.com");
//		userRepository.save(john);
//		Dog gaston = new Dog("Gaston", "male", "DOBERMAN", john);
//		dogRepository.save(gaston);
//		john.addDog(gaston);
//		userRepository.save(john);
//		Location queensPark = new Location(GlasgowPark.QUEENS);
//		locationRepository.save(queensPark);
//		Walkie stroll = new Walkie("07/11/23", "QueensPark");
//		walkieRepository.save(stroll);
//		stroll.addUser(john);
////		stroll.addDog(gaston);
//		walkieRepository.save(stroll);
//	}

	 @Test
	 public void canSendNotificationsToUser(){
		User john = new User("John", "Doe", "johndoe@gmail.com");
		User mary = new User("Mary", "Doe", "marydoe@gmail.com");
	 	userRepository.save(john);
		 userRepository.save(mary);
	 	 HashMap<String, String> map = new HashMap<>();
	 	 map.put("Location", "Kelvingrove");
	 	 map.put("Date", "Tomorrow");
	 	 map.put("Message", "Hey! Would you like to go on a walk with me tomorrow?");
	 	 Notification park = new Notification(map, john, mary);
	 	 notificationRepository.save(park);

	 	john.addNotification(park);
	 	userRepository.save(john);
	 }





}

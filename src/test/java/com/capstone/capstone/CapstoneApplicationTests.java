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

	@Test
	public void canCreateUserAndSave(){
		User john = new User("John", "Doe", "johndoe@gmail.com");
		userRepository.save(john);
	}

	@Test
	public void canCreateDogAndSave(){
		User john = new User("John", "Doe", "johndoe@gmail.com");
		userRepository.save(john);
		Dog gaston = new Dog("Gaston", "male", Breed.DOBERMAN, john);
		dogRepository.save(gaston);

	}

	@Test
	public void canAssignDogToUser(){
		User john = new User("John", "Doe", "johndoe@gmail.com");
		Dog gaston = new Dog("Gaston", "male", Breed.DOBERMAN, john);
		john.addDog(gaston);
		userRepository.save(john);
	}


	@Test
	public void canCreateLocationAndAddUserAndDogAndSave(){
		Location kelvingrove = new Location(GlasgowPark.KELVINGROVE);
		locationRepository.save(kelvingrove);
		User john = new User("John", "Doe", "johndoe@gmail.com");
		userRepository.save(john);
		Dog gaston = new Dog("Gaston", "male", Breed.DOBERMAN, john);
		dogRepository.save(gaston);
	}

	@Test
	public void canCreateWalkieAndAddDogAndUserAndSave(){
		User john = new User("John", "Doe", "johndoe@gmail.com");
		userRepository.save(john);
		Dog gaston = new Dog("Gaston", "male", Breed.DOBERMAN, john);
		dogRepository.save(gaston);
		john.addDog(gaston);
		userRepository.save(john);
		Location queensPark = new Location(GlasgowPark.QUEENS);
		locationRepository.save(queensPark);
		Walkie stroll = new Walkie("07/11/23", queensPark);
		walkieRepository.save(stroll);
		stroll.addUser(john);
		stroll.addDog(gaston);
		walkieRepository.save(stroll);
	}

	@Test
	public void canSendNotificationsToUser(){
		User john = new User("John", "Doe", "johndoe@gmail.com");
		userRepository.save(john);
//		MultiValuedMap<String, String> notifications = new ArrayListValuedHashMap<>();
//		notifications.put("John", "Park");
//		notifications.put("John", "Glasgow");
//		john.setNotifications(notifications);
		Notification park = new Notification("Glasgow", "Park", john);
		notificationRepository.save(park);

		john.addNotification(park);
		userRepository.save(john);
	}





}

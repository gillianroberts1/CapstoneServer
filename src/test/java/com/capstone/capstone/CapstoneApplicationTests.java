package com.capstone.capstone;

import com.capstone.capstone.enums.Area;
import com.capstone.capstone.enums.Breed;
import com.capstone.capstone.enums.GlasgowPark;
import com.capstone.capstone.models.Dog;
import com.capstone.capstone.models.Location;
import com.capstone.capstone.models.User;
import com.capstone.capstone.models.Walkie;
import com.capstone.capstone.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

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

	@Test
	void contextLoads() {
	}

//	@Test
//	public void canCreateUserAndSave(){
//		User john = new User("John", "Something", 30, "male", Area.WEST);
//		userRepository.save(john);
//	}
//
//	@Test
//	public void canCreateDogAndSave(){
//		User john = new User("John", "Something", 30, "male", Area.WEST);
//		userRepository.save(john);
//		Dog gaston = new Dog("Gaston", "male", Breed.DOBERMAN, john);
//		dogRepository.save(gaston);
//
//	}
//
//	@Test
//	public void canAssignDogToUser(){
//		User john = new User("John", "Something", 30, "male", Area.WEST);
//		Dog gaston = new Dog("Gaston", "male", Breed.DOBERMAN, john);
//		john.addDog(gaston);
//		userRepository.save(john);
//	}
//
//
//	@Test
//	public void canCreateLocationAndAddUserAndDogAndSave(){
//		Location kelvingrove = new Location(GlasgowPark.KELVINGROVE);
//		locationRepository.save(kelvingrove);
//		User john = new User("John", "Something", 30, "male", Area.WEST);
//		userRepository.save(john);
//		Dog gaston = new Dog("Gaston", "male", Breed.DOBERMAN, john);
//		dogRepository.save(gaston);
//		kelvingrove.addUser(john);
//		kelvingrove.addDog(gaston);
//		locationRepository.save(kelvingrove);
//	}
//
//	@Test
//	public void canCreateWalkieAndAddDogAndUserAndSave(){
//		User john = new User("John", "Something", 30, "male", Area.WEST);
//		userRepository.save(john);
//		Dog gaston = new Dog("Gaston", "male", Breed.DOBERMAN, john);
//		dogRepository.save(gaston);
//		john.addDog(gaston);
//		userRepository.save(john);
//		Location queensPark = new Location(GlasgowPark.QUEENS);
//		locationRepository.save(queensPark);
//		Walkie stroll = new Walkie("07/11/23", queensPark);
//		walkieRepository.save(stroll);
//		stroll.addUser(john);
//		stroll.addDog(gaston);
//		walkieRepository.save(stroll);
//	}

	@Test
	public void canAddMultipleDogsToUser(){
		User john = new User("John", "Doe", "johnjohn@gmail.com");
		userRepository.save(john);

		Dog Sam = new Dog("Samwise", "Male", Breed.LABRADOR, john);
//		john.addDog(Sam);
		Dog Max = new Dog("Maxwell", "Female", Breed.BEAGLE, john);
//		john.addDog(Max);
		userRepository.save(john);

//		assertEquals(1, john.getDogs().size());

	}





}

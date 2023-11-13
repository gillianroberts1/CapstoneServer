package com.capstone.capstone.models;

import com.capstone.capstone.enums.Breed;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.Incubating;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="dogs")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;
    @Column(name="gender")
    private String gender;
    @Column(name ="breed")
    private String breed;
    @Column(name = "age")
    private Integer age;
    @Column(name = "photoURL")
    private String photoURL;
    @Column(name="neutered")
    private Boolean neutered;
    @Column(name="leash")
    private  Boolean leash;
    @Column(name="vaccinated")
    private  Boolean vaccinated;
    @Column(name = "rating")
    private Integer rating;

    @JsonIgnoreProperties({"dogs"})
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    @JsonIgnoreProperties({"dogs"})
//    @ManyToMany
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinTable(
//            name = "dogs_walkies",
//            joinColumns ={@JoinColumn(name = "dog_id", nullable = false, updatable = false)},
//            inverseJoinColumns =  {@JoinColumn(name = "walkie_id", nullable = false, updatable = false)}
//    )
//    private List<Walkie> walkies;
//
//    @JsonIgnoreProperties({"dogs"})
//    @ManyToMany
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinTable(
//            name = "dogs_groupWalkies",
//            joinColumns ={@JoinColumn(name = "dog_id", nullable = false, updatable = false)},
//            inverseJoinColumns =  {@JoinColumn(name = "groupWalkie_id", nullable = false, updatable = false)}
//    )
//    private List<GroupWalkie> groupWalkies;

    public Dog(String name, String gender, String breed, User user) {
        this.name = name;
        this.gender = gender;
        this.breed = breed;
        this.user = user;
        this.age = 0;
        this.photoURL = null;
        this.neutered = false;
        this.leash = false;
        this.vaccinated = false;
        this.rating = 0;
//        this.walkies = new ArrayList<Walkie>();
//        this.groupWalkies = new ArrayList<GroupWalkie>();
    }

    public Dog() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Boolean getNeutered() {
        return neutered;
    }

    public void setNeutered(Boolean neutered) {
        this.neutered = neutered;
    }

    public Boolean getLeash() {
        return leash;
    }

    public void setLeash(Boolean leash) {
        this.leash = leash;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

//    public List<Walkie> getWalkies() {
//        return walkies;
//    }
//
//    public void setWalkies(List<Walkie> walkies) {
//        this.walkies = walkies;
//    }
//
//    public List<GroupWalkie> getGroupWalkies() {
//        return groupWalkies;
//    }
//
//    public void setGroupWalkies(List<GroupWalkie> groupWalkies) {
//        this.groupWalkies = groupWalkies;
//    }
//
//    public void addWalkie(Walkie walkie) {
//        this.walkies.add(walkie);
//    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}

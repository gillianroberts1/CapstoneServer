package com.capstone.capstone.models;

import com.capstone.capstone.enums.Area;
import com.fasterxml.jackson.annotation.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private  String firstName;

    @Column(name = "last_name")
    private  String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;

    @Column(name = "photoURL")
    private String photoURL;

    @Column(name = "total_distance")
    private int totalDistance;

    @Column(name = "gender")
    private String gender;

    @Column(name = "area")
    private Area area;

    @Column(name = "uid")
    private String uid;

    @JsonIgnoreProperties({"users"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "users_walkies",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "walkie_id", nullable = false, updatable = false)}
    )
    private List<Walkie> walkies;

    @JsonIgnoreProperties({"users"})
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "users_groupWalkies",
            joinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "groupWalkie_id", nullable = false, updatable = false)}
    )
    private List<GroupWalkie> groupWalkies;

    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "user")
    private List<Dog> dogs;

    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Favourite> favourites;

    public User(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.photoURL = null;
        this.age = 0;
        this.uid = null;
        this.gender = null;
        this.area = null;
        this.totalDistance = 0;
        this.walkies = new ArrayList<Walkie>();
        this.groupWalkies = new ArrayList<GroupWalkie>();
        this.dogs = new ArrayList<Dog>();
        this.favourites = new ArrayList<Favourite>();
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Walkie> getWalkies() {
        return walkies;
    }

    public void setWalkies(List<Walkie> walkies) {
        this.walkies = walkies;
    }

    public List<GroupWalkie> getGroupWalkies() {
        return groupWalkies;
    }

    public void setGroupWalkies(List<GroupWalkie> groupWalkies) {
        this.groupWalkies = groupWalkies;
    }

    public void addGropuWalkie(GroupWalkie groupWalkie){
        this.groupWalkies.add(groupWalkie);
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public List<Favourite> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<Favourite> favourites) {
        this.favourites = favourites;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void addDog(Dog dog){
        this.dogs.add(dog);
    }

    public void addWalkie(Walkie walkie){
        this.walkies.add(walkie);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
}



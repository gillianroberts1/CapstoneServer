package com.capstone.capstone.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groupWalkies")
public class GroupWalkie {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private String date;

    @Column(name = "distance")
    private Double distance;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "location")
    private String location;


    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "groupWalkies_users",
            joinColumns ={@JoinColumn(name = "groupWalkie_id", nullable = false, updatable = false)},
            inverseJoinColumns =  {@JoinColumn(name = "user_id", nullable = false, updatable = false)}
    )
    private List<User> users;

//    @JsonIgnoreProperties({"groupWalkies"})
//    @JsonIgnore
//    @ManyToMany
//    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
//    @JoinTable(
//            name = "groupWalkies_dogs",
//            joinColumns ={@JoinColumn(name = "groupWalkie_id", nullable = false, updatable = false)},
//            inverseJoinColumns =  {@JoinColumn(name = "dog_id", nullable = false, updatable = false)}
//    )
//    private List<Dog> dogs;

//    @JsonIgnoreProperties({"groupWalkies"})
//    @ManyToOne
//    @JoinColumn(name = "location_id", nullable = false)
//    private Location location;

    public GroupWalkie(String name, String location, String date, Double distance, Integer duration) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.distance = distance;
        this.duration = duration;
        this.users = new ArrayList<User>();
//        this.dogs = new ArrayList<Dog>();
    }

    public GroupWalkie() {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    //    public List<Dog> getDogs() {
//        return dogs;
//    }
//
//    public void setDogs(List<Dog> dogs) {
//        this.dogs = dogs;
//    }



    public void addUser(User user){
        this.users.add(user);
    }

//    public void addDog(Dog dog){
//        this.dogs.add(dog);
//    }


}

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
@Table(name = "walkies")
public class Walkie {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private String date;

    @JsonIgnoreProperties({"walkies"})
    @JsonBackReference
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "walkies_users",
            joinColumns ={@JoinColumn(name = "walkie_id", nullable = false, updatable = false)},
            inverseJoinColumns =  {@JoinColumn(name = "user_id", nullable = false, updatable = false)}
    )
    private List<User> users;

    @JsonIgnore
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "walkies_dogs",
            joinColumns ={@JoinColumn(name = "walkie_id", nullable = false, updatable = false)},
            inverseJoinColumns =  {@JoinColumn(name = "dog_id", nullable = false, updatable = false)}
    )
    private List<Dog> dogs;

    @JsonIgnoreProperties({"walkies"})
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    public Walkie(String date, Location location) {
        this.date = date;
        this.location = location;
        this.users = new ArrayList<User>();
        this.dogs = new ArrayList<Dog>();
    }

    public Walkie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(List<Dog> dogs) {
        this.dogs = dogs;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public void addDog(Dog dog){
        this.dogs.add(dog);
    }

    public void addLocation(Location location){
        this.location = location;
    }
}

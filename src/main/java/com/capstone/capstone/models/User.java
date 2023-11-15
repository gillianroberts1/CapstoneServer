package com.capstone.capstone.models;

import com.capstone.capstone.enums.Area;
import com.fasterxml.jackson.annotation.*;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "users")
@JsonIdentityInfo(
  generator = ObjectIdGenerators.PropertyGenerator.class, 
  property = "id")
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
    private Integer age;

    @Column(name = "photoURL")
    private String photoURL;

    @Column(name = "total_distance")
    private Integer totalDistance;

    @Column(name = "gender")
    private String gender;

    @Column(name = "area")
    private String area;

    @Column(name = "uid")
    private String uid;

    @ManyToMany
    @JoinTable(
    name = "favourites",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "favourite_user_id")
    )
    private List<User> favourites;

    // @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    // @JoinColumn(name = "user_id")
    // private List<Notification> notifications = new ArrayList<>();

    @JsonIgnoreProperties({"user"})
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Notification> notifications = new ArrayList<>();

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
        this.notifications = new ArrayList<Notification>();
        this.walkies = new ArrayList<Walkie>();
        this.groupWalkies = new ArrayList<GroupWalkie>();
        this.dogs = new ArrayList<Dog>();
        this.favourites = new ArrayList<User>();
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Integer totalDistance) {
        this.totalDistance = totalDistance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
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


    public List<User> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<User> favourites) {
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

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public void addNotification(Notification notification){
        this.notifications.add(notification);
        notification.setUser(this);
    }

    public void addFavourite(User user){
        this.favourites.add(user);
    }

    public void removeNotification(Notification notification) {
        this.notifications.remove(notification);
        notification.setUser(null);
    }

    public void removeFavourite(User favUser) {
        this.favourites.remove(favUser);
        favUser.getFavourites().remove(this);

    }
}



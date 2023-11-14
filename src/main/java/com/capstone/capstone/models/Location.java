package com.capstone.capstone.models;

import com.capstone.capstone.enums.GlasgowPark;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name="park")
    private GlasgowPark glasgowPark;

//    @JsonBackReference
//    @OneToMany(mappedBy = "location")
//    private List<Walkie> walkies;

//    @JsonIgnore
//    @OneToMany(mappedBy = "location")
//    private List<GroupWalkie> groupWalkies;

    public Location(GlasgowPark glasgowPark) {
        this.glasgowPark = glasgowPark;
//        this.walkies = new ArrayList<Walkie>();
//        this.groupWalkies = new ArrayList<GroupWalkie>();
    }

    public Location(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return glasgowPark.getName();
    }

    public String getArea() {
        return glasgowPark.getArea();
    }

    public String getDifficulty(){
        return glasgowPark.getDifficulty();
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
}

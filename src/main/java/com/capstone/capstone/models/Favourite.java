package com.capstone.capstone.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "favourites")
public class Favourite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JsonIgnoreProperties({"favourites"})
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;

    public Favourite(Long id, User user) {
        this.id = id;
//        this.user = user;
    }

    public Favourite() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}

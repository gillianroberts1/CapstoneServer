package com.capstone.capstone.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@Entity
//@Table(name = "watchlist")
public class WatchList {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<GroupWalkie> groupWalkies;

    public WatchList() {
        this.groupWalkies = new ArrayList<GroupWalkie>();
    }

    public List<GroupWalkie> getGroupWalkies() {
        return groupWalkies;
    }

    public void setGroupWalkies(List<GroupWalkie> groupWalkies) {
        this.groupWalkies = groupWalkies;
    }
}

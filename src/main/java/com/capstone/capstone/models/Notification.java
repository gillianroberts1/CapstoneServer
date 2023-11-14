package com.capstone.capstone.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties({"notifications"})
    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @JsonIgnoreProperties({"notifications"})
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ElementCollection
    @CollectionTable(name = "notification_entries", joinColumns = @JoinColumn(name = "notification_id"))
    @MapKeyColumn(name = "entry_key")
    @Column(name = "entry_value")
    private Map<String, String> entries = new HashMap<>();

    public Notification(Map<String, String> entries, User user, User sender) {
        this.entries = entries;
        this.user = user;
        this.sender = sender;
    }

    public Notification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<String, String> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, String> entries) {
        this.entries = entries;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

}

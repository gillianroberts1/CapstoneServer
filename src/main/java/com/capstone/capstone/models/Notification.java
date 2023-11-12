package com.capstone.capstone.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "notification_key")
    private String key;

    @Column(name = "notification_value")
    private String value;

    @JsonIgnoreProperties({"dogs"})
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Notification(String key, String value, User user) {
        this.key = key;
        this.value = value;
        this.user = user;
    }

    public Notification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

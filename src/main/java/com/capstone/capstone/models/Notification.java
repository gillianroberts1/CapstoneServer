package com.capstone.capstone.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "notification_entries", joinColumns = @JoinColumn(name = "notification_id"))
    @MapKeyColumn(name = "entry_key")
    @Column(name = "entry_value")
    private Map<String, String> entries = new HashMap<>();

    public Notification(Map<String, String> entries) {
        this.entries = entries;
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
}

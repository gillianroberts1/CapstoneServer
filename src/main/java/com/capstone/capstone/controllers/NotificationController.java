package com.capstone.capstone.controllers;

import com.capstone.capstone.models.Notification;
import com.capstone.capstone.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class NotificationController {

    @Autowired
    private NotificationRepository notificationRepository;

    @GetMapping(value = "/notifications")
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @GetMapping("/notifications/{id}")
    public Notification getNotificationById(@PathVariable Long id) {
        return notificationRepository.findById(id).orElse(null);
    }

    @PostMapping(value = "/notifications")
    public Notification createNotification(@RequestBody Notification notification) {
        return notificationRepository.save(notification);
    }
}
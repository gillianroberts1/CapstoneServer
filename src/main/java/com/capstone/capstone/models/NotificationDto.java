package com.capstone.capstone.models;

import java.util.Map;

public class NotificationDto {
    private Long senderId;
    private Long userId;
    private Map<String, String> entries;

    public NotificationDto(Long senderId, Long userId, Map<String, String> entries) {
        this.senderId = senderId;
        this.userId = userId;
        this.entries = entries;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Map<String, String> getEntries() {
        return entries;
    }

    public void setEntries(Map<String, String> entries) {
        this.entries = entries;
    }
}



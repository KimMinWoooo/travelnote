package com.example.member.client;

import lombok.Data;

@Data
public class TripResponse {
    private String tripId;
    private String title;
    private String description;
    // 필요한 다른 필드들 추가
} 
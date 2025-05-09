package com.example.member.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class TripServiceClient {
    
    private final RestClient restClient;
    private final String tripServiceUrl;
    
    public TripServiceClient(RestClient.Builder restClientBuilder,
                           @Value("${trip.service.url}") String tripServiceUrl) {
        this.restClient = restClientBuilder.build();
        this.tripServiceUrl = tripServiceUrl;
    }
    
    public TripResponse getTripDetails(String tripId) {
        return restClient.get()
                .uri(tripServiceUrl + "/api/trips/{tripId}", tripId)
                .retrieve()
                .body(TripResponse.class);
    }
    
    // 필요한 다른 메서드들 추가
} 
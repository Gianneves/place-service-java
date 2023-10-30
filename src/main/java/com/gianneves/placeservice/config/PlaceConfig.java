package com.gianneves.placeservice.config;

import com.gianneves.placeservice.domain.PlaceRepository;
import com.gianneves.placeservice.domain.PlaceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlaceConfig {
    @Bean
    PlaceService placeService(PlaceRepository placeRepository) {
        return new PlaceService(placeRepository);
    }
}

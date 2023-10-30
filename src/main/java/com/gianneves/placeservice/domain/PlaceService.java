package com.gianneves.placeservice.domain;

import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class PlaceService {
    @Autowired
    private PlaceRepository placeRepository;

    public Mono<Place> create(Place place) {
        return placeRepository.save(place);
    }
}

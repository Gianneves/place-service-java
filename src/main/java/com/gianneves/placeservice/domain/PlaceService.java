package com.gianneves.placeservice.domain;

import com.gianneves.placeservice.api.PlaceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public Mono<Place> create(PlaceRequest placeRequest) {
        var place = new Place(null, placeRequest.name(), placeRequest.slug(), placeRequest.state(), placeRequest.createdAt(), placeRequest.updatedAt());
        return placeRepository.save(place);
    }
}

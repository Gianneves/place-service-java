package com.gianneves.placeservice.domain;

import com.gianneves.placeservice.api.PlaceRequest;
import com.github.slugify.Slugify;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepository placeRepository;
    private Slugify slg;

    public PlaceService(PlaceRepository placeRepository) {

        this.placeRepository = placeRepository;
        this.slg = Slugify.builder().build();
    }

    public Mono<Place> create(PlaceRequest placeRequest) {
        var place = new Place(null, placeRequest.name(), slg.slugify(placeRequest.name()), placeRequest.state(), placeRequest.createdAt(), placeRequest.updatedAt());
        return placeRepository.save(place);
    }
}

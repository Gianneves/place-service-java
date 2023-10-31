package com.gianneves.placeservice.web;

import com.gianneves.placeservice.api.PlaceResponse;
import com.gianneves.placeservice.domain.Place;

public class PlaceMapper {
    public static PlaceResponse fromPlaceToResponse(Place place) {
        return new PlaceResponse(place.name(), place.slug(),
                place.state(), place.createdAt(), place.updatedAt());
    }
}

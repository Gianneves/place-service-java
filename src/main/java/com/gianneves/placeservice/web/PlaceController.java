package com.gianneves.placeservice.web;

import com.gianneves.placeservice.api.PlaceRequest;
import com.gianneves.placeservice.api.PlaceResponse;
import com.gianneves.placeservice.domain.Place;
import com.gianneves.placeservice.domain.PlaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest request) {
        var placeResponse = placeService.create(request).map(PlaceMapper::fromPlaceToResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<PlaceResponse>> getById(@PathVariable("id") Long id) {
        return placeService.getById(id)
                .map(place -> ResponseEntity.ok(PlaceMapper.toResponse(place)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}

package com.dental.controller;

import com.dental.DTO.AppReviewDTO;
import com.dental.entities.AppReview;
import com.dental.services.AppReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.UUID;

@RestController
@RequestMapping("/api/reviews")
public class AppReviewController {

    private final AppReviewService appReviewService;

    @Autowired
    public AppReviewController(AppReviewService appReviewService) {
        this.appReviewService = appReviewService;
    }

    @PostMapping(
            path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> addReview(@RequestParam UUID appointmentId, @RequestBody String content) {
        AppReview addedReview = appReviewService.addReview(appointmentId, content);
        if (addedReview == null) {
            return new ResponseEntity<>("Appointment not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(addedReview, HttpStatus.CREATED);
    }
}

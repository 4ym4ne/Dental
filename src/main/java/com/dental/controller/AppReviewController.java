package com.dental.controller;

import com.dental.DTO.AppReviewDTO;
import com.dental.entities.AppReview;
import com.dental.services.AppReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/reviews")
public class AppReviewController {

    private final AppReviewService appReviewService;

    @Autowired
    public AppReviewController(AppReviewService appReviewService) {
        this.appReviewService = appReviewService;
    }

    @PostMapping("/add")
    public ResponseEntity<AppReview> addReview(@RequestParam UUID appointmentId, @RequestBody String content) {
        AppReview addedReview = appReviewService.addReview(appointmentId, content);

        return new ResponseEntity<>(addedReview, HttpStatus.CREATED);
    }
}

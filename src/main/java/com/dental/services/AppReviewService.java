package com.dental.services;

import com.dental.entities.AppReview;
import com.dental.entities.Appointment;
import com.dental.repositories.AppointmentRepository;
import com.dental.repositories.AppReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class AppReviewService {

    private final AppReviewRepository appReviewRepository;
    private final AppointmentRepository appointmentRepository;

    private final AppointmentsService appointmentsService;

    @Autowired
    public AppReviewService(AppReviewRepository appReviewRepository, AppointmentRepository appointmentRepository, AppointmentsService appointmentsService) {
        this.appReviewRepository = appReviewRepository;
        this.appointmentRepository = appointmentRepository;
        this.appointmentsService = appointmentsService;
    }

    public AppReview addReview(UUID appointmentId, String content) {
        // Assuming you have a method to find an appointment by ID in the appointmentRepository
        Appointment appointment = appointmentRepository.findById(appointmentId).orElse(null);

        // Create a new review
        AppReview review = new AppReview();
        review.setAppointments(appointment);
        review.setContent(content);
        review.setReviewTime(LocalDate.now());

        // Save the review
        return appReviewRepository.save(review);
    }
}


package com.dental.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "app_reviews")
public class AppReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "review_id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointments_id")
    private Appointment appointments;

    @Column(name = "content", length = Integer.MAX_VALUE)
    private String content;

    @Column(name = "review_time")
    private LocalDate reviewTime;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Appointment getAppointments() {
        return appointments;
    }

    public void setAppointments(Appointment appointments) {
        this.appointments = appointments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(LocalDate reviewTime) {
        this.reviewTime = reviewTime;
    }

}
package com.dental.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link com.dental.entities.AppReview}
 */
public class AppReviewDTO implements Serializable {
    private final UUID id;
    private final AppointmentDTO appointments;
    private final String content;
    private final LocalDate reviewTime;

    public AppReviewDTO(UUID id, AppointmentDTO appointments, String content, LocalDate reviewTime) {
        this.id = id;
        this.appointments = appointments;
        this.content = content;
        this.reviewTime = reviewTime;
    }

    public AppReviewDTO() {
        this.id = null;
        this.appointments = null;
        this.content = null;
        this.reviewTime = null;
    }

    public UUID getId() {
        return id;
    }

    public AppointmentDTO getAppointments() {
        return appointments;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getReviewTime() {
        return reviewTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppReviewDTO entity = (AppReviewDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.appointments, entity.appointments) &&
                Objects.equals(this.content, entity.content) &&
                Objects.equals(this.reviewTime, entity.reviewTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appointments, content, reviewTime);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "appointments = " + appointments + ", " +
                "content = " + content + ", " +
                "reviewTime = " + reviewTime + ")";
    }
}
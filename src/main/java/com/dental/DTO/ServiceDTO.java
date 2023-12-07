package com.dental.DTO;

import com.dental.entities.Services;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link Services}
 */
public class ServiceDTO {
    private final UUID id;
    private final String servicename;
    private final String description;
    private final Integer duration;
    private final BigDecimal cost;

    public ServiceDTO(UUID id, String servicename, String description, Integer duration, BigDecimal cost) {
        this.id = id;
        this.servicename = servicename;
        this.description = description;
        this.duration = duration;
        this.cost = cost;
    }

    public UUID getId() {
        return id;
    }

    public String getServicename() {
        return servicename;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDuration() {
        return duration;
    }

    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceDTO entity = (ServiceDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.servicename, entity.servicename) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.duration, entity.duration) &&
                Objects.equals(this.cost, entity.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, servicename, description, duration, cost);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "servicename = " + servicename + ", " +
                "description = " + description + ", " +
                "duration = " + duration + ", " +
                "cost = " + cost + ")";
    }
}
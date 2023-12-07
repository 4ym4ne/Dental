package com.dental.DTO;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * DTO for {@link com.dental.entities.Appointment}
 */
public class AppointmentDTO implements Serializable {
    private final UUID id;
    private final PatientDTO patientid;
    private final DentistDTO dentistid;
    private final Instant appointmentdatetime;
    private final String status;
    private final String notes;
    private final ServiceDTO serviceid;

    public AppointmentDTO(UUID id, PatientDTO patientid, DentistDTO dentistid, Instant appointmentdatetime, String status, String notes, ServiceDTO serviceid) {
        this.id = id;
        this.patientid = patientid;
        this.dentistid = dentistid;
        this.appointmentdatetime = appointmentdatetime;
        this.status = status;
        this.notes = notes;
        this.serviceid = serviceid;
    }

    public UUID getId() {
        return id;
    }

    public PatientDTO getPatientid() {
        return patientid;
    }

    public DentistDTO getDentistid() {
        return dentistid;
    }

    public Instant getAppointmentdatetime() {
        return appointmentdatetime;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public ServiceDTO getServiceid() {
        return serviceid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppointmentDTO entity = (AppointmentDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.patientid, entity.patientid) &&
                Objects.equals(this.dentistid, entity.dentistid) &&
                Objects.equals(this.appointmentdatetime, entity.appointmentdatetime) &&
                Objects.equals(this.status, entity.status) &&
                Objects.equals(this.notes, entity.notes) &&
                Objects.equals(this.serviceid, entity.serviceid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientid, dentistid, appointmentdatetime, status, notes, serviceid);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "patientid = " + patientid + ", " +
                "dentistid = " + dentistid + ", " +
                "appointmentdatetime = " + appointmentdatetime + ", " +
                "status = " + status + ", " +
                "notes = " + notes + ", " +
                "serviceid = " + serviceid + ")";
    }
}
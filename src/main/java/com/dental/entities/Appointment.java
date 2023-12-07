package com.dental.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "appointments" , schema = "public")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointmentid", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientid")
    private Patient patientid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentistid")
    private Dentist dentistid;

    @Column(name = "appointmentdatetime")
    private Instant appointmentdatetime;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serviceid")
    private Services serviceid;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Patient getPatientid() {
        return patientid;
    }

    public void setPatientid(Patient patientid) {
        this.patientid = patientid;
    }

    public Dentist getDentistid() {
        return dentistid;
    }

    public void setDentistid(Dentist dentistid) {
        this.dentistid = dentistid;
    }

    public Instant getAppointmentdatetime() {
        return appointmentdatetime;
    }

    public void setAppointmentdatetime(Instant appointmentdatetime) {
        this.appointmentdatetime = appointmentdatetime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Services getServiceid() {
        return serviceid;
    }

    public void setServiceid(Services serviceid) {
        this.serviceid = serviceid;
    }

}
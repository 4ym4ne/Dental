package com.dental.controller;

import com.dental.DTO.AppointmentDTO;
import com.dental.services.AppointmentsService;
import com.dental.services.DentistService;
import com.dental.services.PatientService;
import com.dental.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final AppointmentsService appointmentService;

    @Autowired
    public AppointmentController(AppointmentsService appointmentService) {
        this.appointmentService = appointmentService;
    }

    // Add a new appointment
    @PostMapping(
            path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AppointmentDTO> addAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO newAppointment = appointmentService.addAppointment(appointmentDTO);
        if (newAppointment != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newAppointment);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Update an existing appointment or add a new appointment if ID is not provided
    @PutMapping(
            path = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AppointmentDTO> addOrUpdateAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        AppointmentDTO updatedAppointment = appointmentService.addAppointment(appointmentDTO);
        if (updatedAppointment != null) {
            return ResponseEntity.ok(updatedAppointment);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // Get an appointment by ID
    @GetMapping(
            value = "/{appointmentId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AppointmentDTO> getAppointment(@PathVariable UUID appointmentId) {
        AppointmentDTO appointment = appointmentService.getAppointment(appointmentId);
        if (appointment != null) {
            return ResponseEntity.ok(appointment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

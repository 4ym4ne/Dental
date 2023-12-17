package com.dental.controllers;

import com.dental.DTO.PatientDTO;
import com.dental.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping(
            value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<PatientDTO> addPatient(@RequestBody PatientDTO patientDTO) {
        PatientDTO newPatient = patientService.addPatient(patientDTO);
        if (newPatient != null) {
            return ResponseEntity.ok(newPatient);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // get patient by username without exposing password using DTO
    @PostMapping(
            path = "/getByUsername/{username}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<PatientDTO> getPatientByUsername(@PathVariable String username) {
        PatientDTO patient = patientService.getPatientDTOByUsername(username);
        if (patient != null) {
            System.out.println(patient.getUsername());
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

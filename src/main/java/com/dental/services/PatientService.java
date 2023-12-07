package com.dental.services;


import com.dental.DTO.PatientDTO;
import com.dental.entities.Patient;
import com.dental.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientDTO getPatientDTOByUsername(String username) {
        Patient Patient = patientRepository.findByUsername(username);
        if (Patient != null) {
            return convertToDTO(Patient);
        } else {
            return null;
        }
    }

    public PatientDTO addPatient(PatientDTO patientDTO) {
        Patient newPatient = new Patient();
        newPatient.setUsername(patientDTO.getUsername());
        newPatient.setPasswordhash(patientDTO.getPasswordhash());
        newPatient.setFirstname(patientDTO.getFirstname());
        newPatient.setLastname(patientDTO.getLastname());
        newPatient.setEmail(patientDTO.getEmail());
        newPatient.setPhone(patientDTO.getPhone());
        newPatient.setAddress(patientDTO.getAddress());

        // Additional logic for setting patient-specific fields

        Patient savedPatient = patientRepository.save(newPatient);
        return convertToDTO(savedPatient);
    }

    private PatientDTO convertToDTO(Patient patient) {
        return new PatientDTO(
                patient.getId(),
                patient.getUsername(),
                "********",
                patient.getFirstname(),
                patient.getLastname(),
                patient.getEmail(),
                patient.getPhone(),
                patient.getAddress()
        );
    }
}


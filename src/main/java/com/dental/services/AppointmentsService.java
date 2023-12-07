package com.dental.services;

import com.dental.DTO.AppointmentDTO;
import com.dental.DTO.DentistDTO;
import com.dental.DTO.PatientDTO;
import com.dental.DTO.ServiceDTO;
import com.dental.entities.Appointment;
import com.dental.entities.Dentist;
import com.dental.entities.Patient;
import com.dental.entities.Services;
import com.dental.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AppointmentsService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentsService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public AppointmentDTO addAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = convertToEntity(appointmentDTO);
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return convertToDTO(savedAppointment);
    }

    public AppointmentDTO getAppointment(UUID appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElse(null);
        return (appointment != null) ? convertToDTO(appointment) : null;
    }

    private AppointmentDTO convertToDTO(Appointment appointment) {
        return new AppointmentDTO(
                appointment.getId(),
                // You might need to adjust this conversion based on your DTO structure
                convertPatientToDTO(appointment.getPatientid()),
                convertDentistToDTO(appointment.getDentistid()),
                appointment.getAppointmentdatetime(),
                appointment.getStatus(),
                appointment.getNotes(),
                // You might need to adjust this conversion based on your DTO structure
                convertServiceToDTO(appointment.getServiceid())
        );
    }

    private ServiceDTO convertServiceToDTO(Services service) {
        return new ServiceDTO(
                service.getId(),
                service.getServicename(),
                service.getDescription(),
                service.getDuration(),
                service.getCost()
        );
    }

    private DentistDTO convertDentistToDTO(Dentist dentist) {
        return new DentistDTO(
                dentist.getId(),
                dentist.getUsername(),
                "********",
                dentist.getFirstname(),
                dentist.getLastname(),
                dentist.getEmail(),
                dentist.getPhone(),
                dentist.getSpecialization()
        );
    }

    private PatientDTO convertPatientToDTO(Patient patient) {
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

    private Appointment convertToEntity(AppointmentDTO appointmentDTO) {
        Appointment appointment = new Appointment();
        appointment.setId(appointmentDTO.getId());
        // You might need to adjust this conversion based on your entity structure
        appointment.setPatientid(convertPatientDTOToEntity(appointmentDTO.getPatientid()));
        appointment.setDentistid(convertDentistDTOToEntity(appointmentDTO.getDentistid()));

        appointment.setAppointmentdatetime(appointmentDTO.getAppointmentdatetime());
        appointment.setStatus(appointmentDTO.getStatus());
        appointment.setNotes(appointmentDTO.getNotes());
        // You might need to adjust this conversion based on your entity structure
        appointment.setServiceid(convertServiceDTOToEntity(appointmentDTO.getServiceid()));
        return appointment;
    }

    private Services convertServiceDTOToEntity(ServiceDTO serviceDTO) {
        Services service = new Services();
        service.setServicename(serviceDTO.getServicename());
        service.setDescription(serviceDTO.getDescription());
        service.setDuration(serviceDTO.getDuration());
        service.setCost(serviceDTO.getCost());
        return service;
    }

    private Dentist convertDentistDTOToEntity(DentistDTO dentistDTO) {
        Dentist dentist = new Dentist();
        dentist.setUsername(dentistDTO.getUsername());
        dentist.setPasswordhash(dentistDTO.getPasswordhash());
        dentist.setFirstname(dentistDTO.getFirstname());
        dentist.setLastname(dentistDTO.getLastname());
        dentist.setEmail(dentistDTO.getEmail());
        dentist.setPhone(dentistDTO.getPhone());
        dentist.setSpecialization(dentistDTO.getSpecialization());
        return dentist;
    }

    private Patient convertPatientDTOToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();
        patient.setUsername(patientDTO.getUsername());
        patient.setPasswordhash(patientDTO.getPasswordhash());
        patient.setFirstname(patientDTO.getFirstname());
        patient.setLastname(patientDTO.getLastname());
        patient.setEmail(patientDTO.getEmail());
        patient.setPhone(patientDTO.getPhone());
        return patient;
    }

    // Methods to convert PatientDTO, DentistDTO, and ServiceDTO to/from entities
    // ...

    // You need to implement the conversion methods based on your entity and DTO structures
}


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
import com.dental.repositories.DentistRepository;
import com.dental.repositories.PatientRepository;
import com.dental.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AppointmentsService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DentistRepository dentistRepository;
    private final ServiceRepository serviceRepository;

    @Autowired
    public AppointmentsService(AppointmentRepository appointmentRepository, PatientRepository patientRepository,
                               DentistRepository dentistRepository, ServiceRepository serviceRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.dentistRepository = dentistRepository;
        this.serviceRepository = serviceRepository;
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

        // You might need to adjust this conversion based on your entity structure
        Patient patient = patientRepository.findById(appointmentDTO.getPatientid().getId()).orElse(null);
        appointment.setPatientid(patient);

        Dentist dentist = dentistRepository.findById(appointmentDTO.getDentistid().getId()).orElse(null);
        appointment.setDentistid(dentist);

        appointment.setAppointmentdatetime(appointmentDTO.getAppointmentdatetime());
        appointment.setStatus(appointmentDTO.getStatus());
        appointment.setNotes(appointmentDTO.getNotes());

        // You might need to adjust this conversion based on your entity structure
        Services service = serviceRepository.findById(appointmentDTO.getServiceid().getId()).orElse(null);
        appointment.setServiceid(service);

        return appointment;
    }

}


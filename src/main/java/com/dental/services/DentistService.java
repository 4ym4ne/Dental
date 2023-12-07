package com.dental.services;

import com.dental.DTO.DentistDTO;
import com.dental.entities.Dentist;
import com.dental.repositories.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DentistService {

    private final DentistRepository dentistRepository;

    @Autowired
    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    //Fetch dentist by username without password
    public DentistDTO getDentistDTOByUsername(String username) {
        Dentist dentist = dentistRepository.findDentistsByUsername(username);
        if (dentist != null) {
            return convertToDTO(dentist);
        } else {
            return null;
        }
    }

    public DentistDTO addDentist(DentistDTO dentistDTO) {
        // Convert DentistDTO to Dentist entity
        Dentist newDentist = new Dentist();
        newDentist.setUsername(dentistDTO.getUsername());
        newDentist.setPasswordhash(dentistDTO.getPasswordhash());
        newDentist.setFirstname(dentistDTO.getFirstname());
        newDentist.setLastname(dentistDTO.getLastname());
        newDentist.setEmail(dentistDTO.getEmail());
        newDentist.setPhone(dentistDTO.getPhone());
        newDentist.setSpecialization(dentistDTO.getSpecialization());

        // Save the new dentist
        Dentist savedDentist = dentistRepository.save(newDentist);

        // Convert the saved Dentist entity back to DentistDTO
        return convertToDTO(savedDentist);
    }

    private DentistDTO convertToDTO(Dentist dentist) {
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
}

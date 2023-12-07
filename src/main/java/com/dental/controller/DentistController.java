package com.dental.controller;

import com.dental.DTO.DentistDTO;
import com.dental.services.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dentitsts")
public class DentistController {

    private final DentistService dentistService;

    @Autowired
    public DentistController(DentistService dentistService) {
        this.dentistService = dentistService;
    }

    /*
    * Get dentist by username without exposing password using DTO
    * */
    @GetMapping(
            path = "/getByUsername",
            consumes = MediaType.TEXT_PLAIN_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<DentistDTO> getDentistByUsername(@RequestBody String username) {
        DentistDTO dentist = dentistService.getDentistDTOByUsername(username);

        if (dentist != null) {
            System.out.println(dentist.getUsername());
            return ResponseEntity.ok(dentist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*
     * {
            "username": "newDentist",
            "passwordhash": "hashedPassword",
            "firstname": "New",
            "lastname": "Dentist",
            "email": "new.dentist@example.com",
            "phone": "1234567890",
            "specialization": "General Dentist"
        }
    * */
    @PostMapping(
            value = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<DentistDTO> addDentist(@RequestBody DentistDTO dentistDTO) {
        DentistDTO newDentist = dentistService.addDentist(dentistDTO);
        if (newDentist != null) {
            return ResponseEntity.ok(newDentist);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


}

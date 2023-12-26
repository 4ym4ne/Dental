package com.dental.controller;

import com.dental.DTO.ServiceDTO;
import com.dental.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/services")
public class ServicesController {

    private final ServiceService serviceService;

    @Autowired
    public ServicesController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    // Get all services
    @GetMapping(
            path = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<ServiceDTO>> getAllServices() {
        List<ServiceDTO> services = serviceService.getAllServices();
        return ResponseEntity.ok(services);
    }

    // Add a new service
    @PostMapping(
            path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ServiceDTO> addService(@RequestBody ServiceDTO serviceDTO) {
        ServiceDTO newService = serviceService.addService(serviceDTO);
        if (newService != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(newService);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteService(@RequestBody ServiceDTO serviceDTO) {
        UUID serviceId = serviceDTO.getId();
        if (serviceId != null) {
            boolean deleted = serviceService.deleteServiceById(serviceId);
            if (deleted) {
                String successMessage = "Service with ID: " + serviceId + " was deleted.";
                return ResponseEntity.ok(successMessage);
            }
        }
        String errorMessage = "Error deleting service with ID: " + serviceId;
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorMessage);
    }
}

package com.dental.services;

import com.dental.DTO.ServiceDTO;
import com.dental.entities.Services;
import com.dental.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceService {

    private final ServiceRepository servicesRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.servicesRepository = serviceRepository;
    }


    public List<ServiceDTO> getAllServices() {
        List<Services> services = servicesRepository.findAll();
        return services.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ServiceDTO addService(ServiceDTO serviceDTO) {
        Services newService = convertToEntity(serviceDTO);
        Services savedService = servicesRepository.save(newService);
        return convertToDTO(savedService);
    }

    private ServiceDTO convertToDTO(Services service) {
        return new ServiceDTO(
                service.getId(),
                service.getServicename(),
                service.getDescription(),
                service.getDuration(),
                service.getCost()
        );
    }

    private Services convertToEntity(ServiceDTO serviceDTO) {
        Services service = new Services();
        service.setServicename(serviceDTO.getServicename());
        service.setDescription(serviceDTO.getDescription());
        service.setDuration(serviceDTO.getDuration());
        service.setCost(serviceDTO.getCost());
        return service;
    }


}

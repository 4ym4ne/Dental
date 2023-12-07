package com.dental.repositories;

import com.dental.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DentistRepository extends JpaRepository<Dentist, UUID> {
    Dentist findDentistsByUsername(String username);
}
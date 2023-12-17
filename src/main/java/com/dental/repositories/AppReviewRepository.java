package com.dental.repositories;

import com.dental.entities.AppReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppReviewRepository extends JpaRepository<AppReview, UUID> {
}
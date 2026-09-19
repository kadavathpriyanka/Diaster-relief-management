package com.disasterrelief.repository;
import com.disasterrelief.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmergencyRequestRepository extends JpaRepository<EmergencyRequest, Long> { long countByStatus(RequestStatus status); }

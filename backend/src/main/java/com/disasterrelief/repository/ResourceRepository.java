package com.disasterrelief.repository;
import com.disasterrelief.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ResourceRepository extends JpaRepository<Resource, Long> { long countByStatus(com.disasterrelief.model.ResourceStatus status); }

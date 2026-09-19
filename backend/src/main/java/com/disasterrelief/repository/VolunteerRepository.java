package com.disasterrelief.repository;
import com.disasterrelief.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface VolunteerRepository extends JpaRepository<Volunteer, Long> { boolean existsByEmail(String email); java.util.Optional<Volunteer> findByEmail(String email); }

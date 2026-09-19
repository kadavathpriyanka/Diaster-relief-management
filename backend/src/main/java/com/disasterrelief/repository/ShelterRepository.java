package com.disasterrelief.repository;
import com.disasterrelief.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface ShelterRepository extends JpaRepository<Shelter, Long> {
 long countByStatus(com.disasterrelief.model.ShelterStatus status);
 @Query("select coalesce(sum(s.capacity), 0) from Shelter s") long totalCapacity();
 @Query("select coalesce(sum(s.currentOccupancy), 0) from Shelter s") long totalOccupancy();
}

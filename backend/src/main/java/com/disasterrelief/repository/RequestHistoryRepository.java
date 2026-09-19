package com.disasterrelief.repository;
import java.util.List;
import com.disasterrelief.model.RequestHistory;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RequestHistoryRepository extends JpaRepository<RequestHistory, Long> { List<RequestHistory> findByRequestIdOrderByChangedAtAsc(Long requestId); }

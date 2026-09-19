package com.disasterrelief.model;

import java.time.Instant;
import jakarta.persistence.*;

@Entity
@Table(name = "request_history")
public class RequestHistory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(optional = false) @JoinColumn(name = "request_id") private EmergencyRequest request;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private RequestStatus status;
    @Column(nullable = false) private String note;
    @Column(nullable = false, updatable = false) private Instant changedAt = Instant.now();
    public RequestHistory(){} public RequestHistory(EmergencyRequest r, RequestStatus s, String n){request=r;status=s;note=n;}
    public Long getId(){return id;} public EmergencyRequest getRequest(){return request;} public RequestStatus getStatus(){return status;} public String getNote(){return note;} public Instant getChangedAt(){return changedAt;}
}

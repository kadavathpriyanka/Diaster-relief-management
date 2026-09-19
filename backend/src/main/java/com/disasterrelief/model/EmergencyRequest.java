package com.disasterrelief.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "emergency_requests")
public class EmergencyRequest {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false) private String requesterName;
    @Column(nullable = false) private String contactNumber;
    @Column(nullable = false) private String location;
    @Column(nullable = false) private String requestType;
    @Column(nullable = false, length = 2000) private String description;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private Priority priority;
    @Column(nullable = false) private int peopleAffected;
    @Column(nullable = false) private LocalDateTime requestDateTime;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private RequestStatus status = RequestStatus.PENDING;
    public Long getId(){return id;} public String getRequesterName(){return requesterName;} public void setRequesterName(String v){requesterName=v;} public String getContactNumber(){return contactNumber;} public void setContactNumber(String v){contactNumber=v;} public String getLocation(){return location;} public void setLocation(String v){location=v;} public String getRequestType(){return requestType;} public void setRequestType(String v){requestType=v;} public String getDescription(){return description;} public void setDescription(String v){description=v;} public Priority getPriority(){return priority;} public void setPriority(Priority v){priority=v;} public int getPeopleAffected(){return peopleAffected;} public void setPeopleAffected(int v){peopleAffected=v;} public LocalDateTime getRequestDateTime(){return requestDateTime;} public void setRequestDateTime(LocalDateTime v){requestDateTime=v;} public RequestStatus getStatus(){return status;} public void setStatus(RequestStatus v){status=v;}
}

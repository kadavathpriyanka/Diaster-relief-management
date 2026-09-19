package com.disasterrelief.model;

import jakarta.persistence.*;

@Entity
@Table(name = "shelters")
public class Shelter {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false) private String name;
    @Column(nullable = false) private String location;
    @Column(nullable = false) private int capacity;
    @Column(nullable = false) private int currentOccupancy;
    @Column(nullable = false) private String contactPerson;
    @Column(nullable = false) private String contactNumber;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private ShelterStatus status = ShelterStatus.ACTIVE;
    @Transient public int getAvailableSpaces(){return capacity-currentOccupancy;}
    public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;} public String getLocation(){return location;} public void setLocation(String v){location=v;} public int getCapacity(){return capacity;} public void setCapacity(int v){capacity=v;} public int getCurrentOccupancy(){return currentOccupancy;} public void setCurrentOccupancy(int v){currentOccupancy=v;} public String getContactPerson(){return contactPerson;} public void setContactPerson(String v){contactPerson=v;} public String getContactNumber(){return contactNumber;} public void setContactNumber(String v){contactNumber=v;} public ShelterStatus getStatus(){return status;} public void setStatus(ShelterStatus v){status=v;}
}

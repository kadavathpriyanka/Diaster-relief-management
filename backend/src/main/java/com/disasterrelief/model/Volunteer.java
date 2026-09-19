package com.disasterrelief.model;

import jakarta.persistence.*;

@Entity
@Table(name = "volunteers")
public class Volunteer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false) private String fullName;
    @Column(nullable = false) private int age;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private Gender gender;
    @Column(nullable = false, unique = true) private String email;
    @Column(nullable = false) private String phone;
    @Column(nullable = false) private String address;
    @Column(nullable = false) private String skills;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private VolunteerStatus availability = VolunteerStatus.AVAILABLE;
    @Column(nullable = false) private String emergencyContact;
    public Long getId() { return id; } public String getFullName() { return fullName; } public void setFullName(String v) { fullName=v; }
    public int getAge() { return age; } public void setAge(int v) { age=v; } public Gender getGender() { return gender; } public void setGender(Gender v) { gender=v; }
    public String getEmail() { return email; } public void setEmail(String v) { email=v; } public String getPhone() { return phone; } public void setPhone(String v) { phone=v; }
    public String getAddress() { return address; } public void setAddress(String v) { address=v; } public String getSkills() { return skills; } public void setSkills(String v) { skills=v; } public VolunteerStatus getAvailability() { return availability; } public void setAvailability(VolunteerStatus v) { availability=v; } public String getEmergencyContact() { return emergencyContact; } public void setEmergencyContact(String v) { emergencyContact=v; }
}

package com.disasterrelief.model;

import jakarta.persistence.*;

@Entity
@Table(name = "resources")
public class Resource {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false) private String name;
    @Column(nullable = false) private String category;
    @Column(nullable = false) private int quantity;
    @Column(nullable = false) private String unit;
    private String location;
    @Enumerated(EnumType.STRING) @Column(nullable = false) private ResourceStatus status = ResourceStatus.AVAILABLE;
    public Long getId(){return id;} public String getName(){return name;} public void setName(String v){name=v;} public String getCategory(){return category;} public void setCategory(String v){category=v;} public int getQuantity(){return quantity;} public void setQuantity(int v){quantity=v;} public String getUnit(){return unit;} public void setUnit(String v){unit=v;} public String getLocation(){return location;} public void setLocation(String v){location=v;} public ResourceStatus getStatus(){return status;} public void setStatus(ResourceStatus v){status=v;}
}

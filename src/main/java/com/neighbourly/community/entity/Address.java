package com.neighbourly.community.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue
    private Long addressId;
    private String houseNumber;
    private String flatNumber;
    private String floorNumber;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}

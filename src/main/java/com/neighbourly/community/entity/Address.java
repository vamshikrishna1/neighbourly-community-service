package com.neighbourly.community.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    private String houseNumber;
    private String flatNumber;
    private String floorNumber;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}

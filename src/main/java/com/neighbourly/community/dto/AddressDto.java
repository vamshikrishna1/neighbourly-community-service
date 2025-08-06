package com.neighbourly.community.dto;

import lombok.Data;

@Data
public class AddressDto {
    private String houseNumber;
    private String flatNumber;
    private String floorNumber;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
}

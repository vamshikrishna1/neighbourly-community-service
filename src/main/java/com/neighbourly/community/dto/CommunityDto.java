package com.neighbourly.community.dto;

import lombok.Data;

@Data
public class CommunityDto {
    private Long communityId;
    private String name;
    private String description;
    private AddressDto address;
    private String builder;
    private String createdBy;
}

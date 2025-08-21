package com.neighbourly.community.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommunityDto {
    private Long communityId;
    private String name;
    private String description;
    private AddressDto address;
    private String builder;

    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
}

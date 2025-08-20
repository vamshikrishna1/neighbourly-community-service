package com.neighbourly.community.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Community {
    @Id
    @GeneratedValue
    private Long communityId;
    private String name;
    private String description;
    @Embedded
    private Address address;
    private String builder;
    private String createdBy;
}

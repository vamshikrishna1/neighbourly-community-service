package com.neighbourly.community.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class HeaderInfo {
    private String uuid;
    private String userId;
}

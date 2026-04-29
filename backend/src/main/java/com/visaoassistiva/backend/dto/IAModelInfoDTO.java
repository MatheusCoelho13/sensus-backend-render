package com.visaoassistiva.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record IAModelInfoDTO(
        Boolean loaded,
        @JsonProperty("model_path") String modelPath,
        String device
) {}

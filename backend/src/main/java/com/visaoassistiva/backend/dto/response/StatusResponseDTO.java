package com.visaoassistiva.backend.dto.response;

public record StatusResponseDTO(
        String backend,
        String iaService,
        String modeloIA,
        Long timestamp
) {}
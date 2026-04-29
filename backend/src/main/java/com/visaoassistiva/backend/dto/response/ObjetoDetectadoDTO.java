package com.visaoassistiva.backend.dto.response;

import java.util.List;

public record ObjetoDetectadoDTO(
        String nome,
        String distancia,
        Boolean isClose,
        String lado,
        List<Double> bbox,
        Double confidence
) {}

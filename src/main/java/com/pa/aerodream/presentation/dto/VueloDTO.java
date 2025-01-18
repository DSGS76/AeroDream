package com.pa.aerodream.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

public record VueloDTO(
        @JsonProperty("ciudadOrigen") Optional<String> ciudadOrigen,
        @JsonProperty("ciudadDestino") Optional<String> ciudadDestino,
        @JsonProperty("fecha") Optional<LocalDate> fecha,
        @JsonProperty("horaSalida") Optional<LocalTime> horaSalida,
        @JsonProperty("aerolinea") Optional<String> aerolinea
) {
}

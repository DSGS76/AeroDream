package com.pa.aerodream.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record ClienteDTO(
        @JsonProperty("nombre") Optional<String> nombre,
        @JsonProperty("correo") Optional<String> correo,
        @JsonProperty("telefono") Optional<String> telefono
) {
}

package com.pa.aerodream.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pa.aerodream.persistence.entity.Reserva;

import java.util.List;
import java.util.Optional;

public record ClienteDTO(
        @JsonProperty("nombre") Optional<String> nombre,
        @JsonProperty("correo") Optional<String> correo,
        @JsonProperty("telefono") Optional<String> telefono,
        @JsonProperty("reservas") Optional<List<Reserva>> reservas
) {
}

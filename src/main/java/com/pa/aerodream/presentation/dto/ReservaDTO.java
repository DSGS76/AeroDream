package com.pa.aerodream.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pa.aerodream.persistence.entity.Cliente;
import com.pa.aerodream.persistence.entity.Vuelo;
import com.pa.aerodream.persistence.entity.enums.EnumClase;

import java.util.Optional;

public record ReservaDTO(
        @JsonProperty("asiento") Optional<String> asiento,
        @JsonProperty("estadoPago") Optional<Boolean> estadoPago,
        @JsonProperty("clase") Optional<EnumClase> clase,
        @JsonProperty("cliente") Optional<Cliente> cliente,
        @JsonProperty("vuelo") Optional<Vuelo> vuelo
) {
}

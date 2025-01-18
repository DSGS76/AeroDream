package com.pa.aerodream.presentation.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public record ReservaDTO(
        @JsonProperty("cliente") Optional<String> cliente,
        @JsonProperty("vuelo") Optional<String> vuelo,
        @JsonProperty("ticket") Optional<String> ticket
) {
}

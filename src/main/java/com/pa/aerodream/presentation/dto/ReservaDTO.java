package com.pa.aerodream.presentation.dto;

import com.pa.aerodream.persistence.entity.Cliente;
import com.pa.aerodream.persistence.entity.Vuelo;
import com.pa.aerodream.persistence.entity.enums.EnumClase;

public record ReservaDTO(Long id,
                         String asiento,
                         Boolean estadoPago,
                         EnumClase clase,
                         Cliente cliente,
                         Vuelo vuelo
) {
}

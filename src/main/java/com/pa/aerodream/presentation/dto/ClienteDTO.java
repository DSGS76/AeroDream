package com.pa.aerodream.presentation.dto;

import java.util.List;
import java.util.Optional;

public record ClienteDTO(Long id,
                         String nombre,
                         String correo,
                         String telefono,
                         List<ReservaDTO> reservas
) {
}

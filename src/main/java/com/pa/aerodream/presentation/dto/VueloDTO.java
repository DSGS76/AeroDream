package com.pa.aerodream.presentation.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record VueloDTO(Long id,
                       String ciudadOrigen,
                       String ciudadDestino,
                       LocalDate fecha,
                       LocalTime horaSalida,
                       String aerolinea,
                       String aeropuertoOrigen,
                       String aeropuertoDestino,
                       Double precioBase
) {
}

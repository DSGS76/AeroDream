package com.pa.aerodream.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@ToString(of = {"id","ciudadOrigen","ciudadDestino","fecha", "horaSalida",
                "aerolinea", "aeropuertoOrigen", "aeropuertoDestino", "precioBase"})
public class Vuelo {

    @Id
    @Column(name = "idVuelo", nullable = false, unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String ciudadOrigen;
    private String ciudadDestino;
    private LocalDate fecha;
    private LocalTime horaSalida;
    private String aerolinea;
    private String aeropuertoOrigen;
    private String aeropuertoDestino;
    private Double precioBase;

    /*
     * Relacion bidireccional uno a muchos [vuelo (1) <--> reserva(n)], un vuelo tiene varias reservas,
     * y uno o varias reservas pertenecen unicamente a un vuelo
     */
    @OneToMany(mappedBy = "vuelo")
    @JsonIgnore
    private List<Reserva> reservas = new ArrayList<>();

    public Vuelo(String ciudadOrigen, String ciudadDestino, LocalDate fecha, LocalTime horaSalida,
                 String aerolinea, String aeropuertoOrigen, String aeropuertoDestino, Double precioBase) {
        super();
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.aerolinea = aerolinea;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.precioBase = precioBase;
    }

    public void addReserva(Reserva reserva) {
        reservas.add(reserva);
        reserva.setVuelo(this);
    }

}

package com.pa.aerodream.persistence.entity;

import com.pa.aerodream.persistence.entity.enums.EnumClase;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Entity
@NoArgsConstructor
@ToString(of = {
        "id"
})
@AllArgsConstructor
@Builder
public class Reserva implements Serializable {

    @Id
    @Column(name = "idReserva",nullable = false,unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String asiento;
    private Boolean estadoPago;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private EnumClase clase;

    /*
     * Relacion bidireccional uno a muchos [cliente (1) <--> reserva(n)], un cliente se presenta en varias reservas,
     * y uno o varias reservas pertenecen unicamente a un cliente
     * La entidad "dueña" de la relacion es la que contendrá la clave foránea, en este caso reserva
     */
    @ManyToOne
    @JoinColumn(name = "id_clienteFK")
    @Setter
    private Cliente cliente;

    /*
     * Relacion bidireccional uno a muchos [vuelo (1) <--> reserva(n)], un vuelo se presenta en varias reservas,
     * y uno o varias reservas pertenecen unicamente a un vuelo
     * La entidad "dueña" de la relacion es la que contendrá la clave foránea, en este caso reserva
     */
    @ManyToOne
    @JoinColumn(name = "id_vueloFK")
    @Setter
    private Vuelo vuelo;

}

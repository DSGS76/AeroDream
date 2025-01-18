package com.pa.aerodream.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Builder
@AllArgsConstructor
@ToString(exclude = {
        "reservas"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente {

    @Id
    @Column(name = "idCliente", nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String nombre;
    @Setter
    private String correo;
    @Setter
    private String telefono;

    /*
     * Relacion bidireccional uno a muchos [cliente (1) <--> reserva(n)], un cliente tiene varias reservas,
     * y uno o varias reservas pertenecen unicamente a un cliente
     */
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Reserva> reservas = new ArrayList<>();

    /*
     * Relacion unidireccional uno a uno [cliente(1) --> usuario(1)], un cliente tiene un usuario,
     * y un usuario pertenecen unicamente a un cliente
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_userFK", nullable = false,unique = true)
    private UserEntity user;

    public Cliente() {
    }

    public void addReserva(Reserva reserva) {
        this.reservas.add(reserva);
        reserva.setCliente(this);
    }

}

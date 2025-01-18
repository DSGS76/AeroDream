package com.pa.aerodream.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
@ToString(of = {"id","precio","asiento"})
public class Ticket implements Serializable {

    @Id
    @Column(name = "idTicket", nullable = false, unique = true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Double precio;
    private String asiento;

    @OneToOne(mappedBy = "ticket")
    private Reserva reserva;

}

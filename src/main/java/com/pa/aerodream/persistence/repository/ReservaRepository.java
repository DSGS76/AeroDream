package com.pa.aerodream.persistence.repository;

import com.pa.aerodream.persistence.entity.Reserva;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    boolean existsByCliente_User_Username(String username);

    List<Reserva> findReservasByCliente_User_Username(String username);

    Object findReservasById(Long id);

    Object findReservaById(Long id);

    @Modifying
    @Transactional
    Integer deleteReservaById(Long id);
}

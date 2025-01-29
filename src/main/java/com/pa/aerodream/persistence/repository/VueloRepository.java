package com.pa.aerodream.persistence.repository;

import com.pa.aerodream.persistence.entity.Vuelo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long> {

    @Modifying
    @Transactional
    Integer deleteVueloById(Long id);

}

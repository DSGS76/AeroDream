package com.pa.aerodream.services;

import com.pa.aerodream.persistence.entity.Vuelo;
import com.pa.aerodream.persistence.repository.VueloRepository;
import com.pa.aerodream.presentation.dto.ReservaDTO;
import com.pa.aerodream.presentation.dto.VueloDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class VueloService {

    private final VueloRepository vueloRepository;

    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    public List<VueloDTO> searchVuelos() {
        List<VueloDTO> vuelos = new ArrayList<>();
        List<Vuelo> vueloSearch = vueloRepository.findAll();
        for (Vuelo r: vueloSearch) {
            VueloDTO vuelo = mapToDTO(r);
            vuelos.add(vuelo);
        }
        return vuelos;
    }

    public void eliminarVuelo(Long idVuelo) {
        vueloRepository.deleteVueloById(idVuelo);
    }

    private VueloDTO mapToDTO(Vuelo vuelo) {
        return new VueloDTO(vuelo.getId(), vuelo.getCiudadOrigen(), vuelo.getCiudadDestino(),
                            vuelo.getFecha(), vuelo.getHoraSalida(), vuelo.getAerolinea(),
                            vuelo.getAeropuertoOrigen(), vuelo.getAeropuertoDestino(), vuelo.getPrecioBase());
    }

}

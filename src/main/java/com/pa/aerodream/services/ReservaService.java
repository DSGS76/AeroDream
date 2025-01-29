package com.pa.aerodream.services;

import com.pa.aerodream.persistence.entity.Cliente;
import com.pa.aerodream.persistence.entity.Vuelo;
import com.pa.aerodream.persistence.repository.ReservaRepository;
import com.pa.aerodream.presentation.dto.ClienteDTO;
import com.pa.aerodream.presentation.dto.ReservaDTO;
import com.pa.aerodream.persistence.entity.Reserva;
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
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<ReservaDTO> searchReservasByCliente(String username) {
        boolean perteneceCliente = reservaRepository.existsByCliente_User_Username(username);
        List<ReservaDTO> reservas = new ArrayList<>();

        if (perteneceCliente) {
            List<Reserva> reservaSearch = reservaRepository.findReservasByCliente_User_Username(username);
            for (Reserva r: reservaSearch) {
                ReservaDTO reserva = mapToDTO(r);
                reservas.add(reserva);
            }
            return reservas;
        }
        log.info("no se encontraron reservas pertenecientes al usuario");
        return reservas;
    }

    public void eliminarReserva(Long idReserva) {
        reservaRepository.deleteReservaById(idReserva);
    }

    private ClienteDTO mapToDTO(Cliente cliente) {
        List<ReservaDTO> reservas = new ArrayList<>();
        for (Reserva r: cliente.getReservas()) {
            ReservaDTO reserva = mapToDTO(r);
            reservas.add(reserva);
        }
        return new ClienteDTO(cliente.getId(), cliente.getNombre(), cliente.getCorreo(),
                              cliente.getTelefono(), reservas);
    }

    private VueloDTO mapToDTO(Vuelo vuelo) {
        return new VueloDTO(vuelo.getId(), vuelo.getCiudadOrigen(), vuelo.getCiudadDestino(),
                            vuelo.getFecha(), vuelo.getHoraSalida(), vuelo.getAerolinea(),
                            vuelo.getAeropuertoOrigen(), vuelo.getAeropuertoDestino(), vuelo.getPrecioBase());
    }

    private ReservaDTO mapToDTO(Reserva reserva) {
        return new ReservaDTO(reserva.getId(), reserva.getAsiento(), reserva.getEstadoPago(),
                              reserva.getClase(), mapToDTO(reserva.getCliente()), mapToDTO(reserva.getVuelo()));
    }

}

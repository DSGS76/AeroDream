package com.pa.aerodream.presentation.controller;

import com.pa.aerodream.persistence.entity.Reserva;
import com.pa.aerodream.persistence.repository.ReservaRepository;
import com.pa.aerodream.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping(value = Constants.Global.API_BASE_PATH + Constants.Global.API_VERSION + Constants.Reserva.RESERVA_SERVICE_PATH)
public class BookingController {

    private final ReservaRepository reservaRepository;

    public BookingController(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @GetMapping(Constants.Reserva.RESERVA_SERVICE_BOOKING)
    public String booking(Model model) {
        return "booking";
    }

    @GetMapping(Constants.Reserva.RESERVA_SERVICE_BOOKED)
    public String booked(Model model) {
        List<Reserva> reservas = reservaRepository.findAll();
        if (reservas.isEmpty()) {
            model.addAttribute("error", "No se encontraron reservas");
            return "error";
        }
        log.info(reservas.toString());
        model.addAttribute("reservas", reservas);
        return "booked";
    }

}

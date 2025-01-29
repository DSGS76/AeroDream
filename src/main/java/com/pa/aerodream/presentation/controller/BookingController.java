package com.pa.aerodream.presentation.controller;

import com.pa.aerodream.persistence.entity.Reserva;
import com.pa.aerodream.persistence.repository.ReservaRepository;
import com.pa.aerodream.presentation.dto.ReservaDTO;
import com.pa.aerodream.presentation.dto.VueloDTO;
import com.pa.aerodream.services.ReservaService;
import com.pa.aerodream.services.VueloService;
import com.pa.aerodream.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping(value = Constants.Global.API_BASE_PATH
                + Constants.Global.API_VERSION
                + Constants.Reserva.RESERVA_SERVICE_PATH)
public class BookingController {

    private final ReservaService reservaService;
    private final VueloService vueloService;

    public BookingController(ReservaService reservaService, VueloService vueloService) {
        this.reservaService = reservaService;
        this.vueloService = vueloService;
    }

    @GetMapping(Constants.Reserva.RESERVA_SERVICE_BOOKING)
    @PreAuthorize("""
                    hasAnyRole(T(com.pa.aerodream.utils.Constants$User).USER_ROLE_ADMIN,
                                T(com.pa.aerodream.utils.Constants$User).USER_ROLE_CLIENT)
                    """)
    public String booking(Model model, Authentication authentication) {
        String username = authentication.getName();
        String role = authentication.getAuthorities().iterator().next().getAuthority();
        model.addAttribute("username", username);
        model.addAttribute("role", role);
        if (role.equals("ROLE_ADMIN")) {

            model.addAttribute("error", "Solo los clientes pueden hacer reservas");
            return "error";

        } else if (role.equals("ROLE_CLIENT")) {

            List<VueloDTO> vuelos = vueloService.searchVuelos();
            model.addAttribute("vuelos", vuelos);
            return "booking";

        }

        model.addAttribute("error", "No tiene permisos para hacer reservas");
        return "error";
    }

    @GetMapping(Constants.Reserva.RESERVA_SERVICE_BOOKED)
    @PreAuthorize("""
                    hasAnyRole(T(com.pa.aerodream.utils.Constants$User).USER_ROLE_ADMIN,
                                T(com.pa.aerodream.utils.Constants$User).USER_ROLE_CLIENT)
                    """)
    public String booked(Model model, Authentication authentication) {
        String username = authentication.getName();
        String role = authentication.getAuthorities().iterator().next().getAuthority();
        model.addAttribute("username", username);
        model.addAttribute("role", role);

        if (role.equals("ROLE_ADMIN")) {

            model.addAttribute("error", "Solo los clientes pueden tener reservas");
            return "error";

        } else if (role.equals("ROLE_CLIENT")) {

            List<ReservaDTO> reservas = reservaService.searchReservasByCliente(username);
            if (reservas.isEmpty()) {
                model.addAttribute("error", "No se encontraron reservas");
                return "error";
            }
            log.info(reservas.toString());
            model.addAttribute("reservas", reservas);
            return "booked";

        }

        model.addAttribute("error", "No tiene permisos para reservas");
        return "error";
    }

    @DeleteMapping(Constants.Reserva.RESERVA_SERVICE_BOOKED + Constants.Reserva.RESERVA_SERVICE_DELETE)
    @PreAuthorize("hasRole(T(com.pa.aerodream.utils.Constants$User).USER_ROLE_CLIENT)")
    public String bookedDelete(@RequestParam Long idReserva) {
        reservaService.eliminarReserva(idReserva);
        return "redirect:" + Constants.Reserva.RESERVA_SERVICE_BOOKED;
    }

}

package com.pa.aerodream.presentation.controller;

import com.pa.aerodream.persistence.repository.VueloRepository;
import com.pa.aerodream.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping(value = Constants.Global.API_BASE_PATH + Constants.Global.API_VERSION + Constants.Vuelo.VUELO_SERVICE_PATH)
public class FlightController {

    private final VueloRepository vueloRepository;

    public FlightController(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @RequestMapping(path = Constants.Vuelo.VUELO_SERVICE_SEARCH, method = RequestMethod.GET)
    @PreAuthorize("""
                    hasAnyRole(T(com.pa.aerodream.utils.Constants$User).USER_ROLE_ADMIN,
                                T(com.pa.aerodream.utils.Constants$User).USER_ROLE_CLIENT)
                    """)
    public String flightController(Model model) {
        Map<String, Object> map = new HashMap<>();
        return "flights";
    }


}

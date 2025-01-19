package com.pa.aerodream.presentation.controller;

import com.pa.aerodream.persistence.repository.ReservaRepository;
import com.pa.aerodream.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping(value = Constants.Global.API_BASE_PATH + Constants.Global.API_VERSION)
public class HomeController {

    private final ReservaRepository reservaRepository;

    public HomeController(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @RequestMapping(path = Constants.Global.API_HOME, method = RequestMethod.GET)
    public String homeController(Model model) {
        Map<String, Object> map = new HashMap<>();
        return "home";
    }

}

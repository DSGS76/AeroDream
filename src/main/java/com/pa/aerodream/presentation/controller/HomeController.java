package com.pa.aerodream.presentation.controller;

import com.pa.aerodream.persistence.repository.ReservaRepository;
import com.pa.aerodream.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping(path = Constants.Global.API_BASE_PATH
                + Constants.Global.API_VERSION)
public class HomeController {

    private final ReservaRepository reservaRepository;

    public HomeController(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @RequestMapping(path = Constants.Global.API_HOME, method = RequestMethod.GET)
    @PreAuthorize("""
                    hasAnyRole(T(com.pa.aerodream.utils.Constants$User).USER_ROLE_ADMIN,
                                T(com.pa.aerodream.utils.Constants$User).USER_ROLE_CLIENT)
                    """)
    public String homeController(Model model, Authentication authentication) {

        String username = authentication.getName();
        String role = authentication.getAuthorities().iterator().next().getAuthority();

        model.addAttribute("username", username);
        model.addAttribute("role", role);
        return "home";
    }

}

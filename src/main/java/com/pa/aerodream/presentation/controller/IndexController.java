package com.pa.aerodream.presentation.controller;

import com.pa.aerodream.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = Constants.Global.API_BASE_PATH + Constants.Global.API_VERSION)
public class IndexController {

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String indexController(Model model) {
        Map<String, Object> map = new HashMap<>();
        return "index";
    }

}

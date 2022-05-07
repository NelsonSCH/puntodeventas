package com.analistas.ventas.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = { "/", "/home" })
    public String verHome(Model model) {
        model.addAttribute("titulo", "Gestión de Punto de Ventas - Dashboard");
        
        return "home";
    }
}

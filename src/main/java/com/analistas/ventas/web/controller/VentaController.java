 package com.analistas.ventas.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @GetMapping(value = { "/listado" })
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de ventas");
        
        return "ventas/listado";
    }
}

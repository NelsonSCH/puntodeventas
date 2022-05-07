package com.analistas.ventas.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @GetMapping(value = { "/listado" })
    public String verProducto(Model model) {
        model.addAttribute("titulo", "Listado de productos");
        
        return "productos/listado";
    }
}

package com.analistas.ventas.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/proveedores")
public class ProveedorController {

    @GetMapping(value = { "/listado" })
    public String verProveedores(Model model) {
        model.addAttribute("titulo", "Listado de proveedores");
        
        return "proveedores/listado";
    }
}
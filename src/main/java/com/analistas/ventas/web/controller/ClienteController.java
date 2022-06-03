package com.analistas.ventas.web.controller;

import javax.validation.Valid;

import com.analistas.ventas.model.entities.Cliente;
import com.analistas.ventas.model.service.IClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    IClienteService clienteService;

    @GetMapping(value = { "/listado" })
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteService.buscarTodo());
        return "clientes/listado";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("titulo", "Nuevo cliente");
        model.addAttribute("cliente", new Cliente());
        
        return "clientes/form";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes redirect){
        
        //Verificar si hay errores:
        if(result.hasErrors()){
            model.addAttribute("danger", "Datos erróneos");
            return "clientes/form";
        }

        
        return"redirect:/clientes/listado";
    }
}
package com.analistas.ventas.web.controller;

import javax.validation.Valid;

import com.analistas.ventas.model.entities.Producto;
import com.analistas.ventas.model.service.IProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/productos")
@SessionAttributes("producto")
public class ProductoController {

    @Autowired
    IProductoService productoService;

    @GetMapping("/listado")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de productos");
        model.addAttribute("productos", productoService.buscarTodo());
        
        return "productos/listado";
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute("titulo", "Nuevo producto");
        model.addAttribute("producto", new Producto());
        
        return "productos/form";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable("id") long id, Model model){
        Producto producto = productoService.BuscarPorId(id);
        model.addAttribute("producto", producto);
        return "productos/form";
    }

    

    @PostMapping("/guardar")
    public String guardar(@Valid Producto producto, BindingResult result, Model model, RedirectAttributes redirect){
        
        //Verificar si hay errores:
        if(result.hasErrors()){
            model.addAttribute("danger", "Datos erróneos");
            return "productos/form";
        }

        //Construir los mensajes flash
        if(producto.getId()== null||producto.getId() == 0)
            redirect.addFlashAttribute("success", "Producto guardado");
        else
            redirect.addFlashAttribute("info", "Producto Modificado");

        //Guardar el producto
        productoService.guardar(producto);

        return"redirect:/productos/listado";
    }

    @GetMapping("/borrar/{id}")
    public String archivar(@PathVariable Long id, RedirectAttributes redirect){

        Producto producto = productoService.BuscarPorId(id);
       redirect.addFlashAttribute("warning", "Producto eliminado...");

       producto.setActivo(!producto.isActivo());
       productoService.guardar(producto);

        return"redirect:/productos/listado";
    }
}

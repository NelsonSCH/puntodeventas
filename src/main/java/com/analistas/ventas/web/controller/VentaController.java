 package com.analistas.ventas.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.analistas.ventas.model.entities.LineaVenta;
import com.analistas.ventas.model.entities.Producto;
import com.analistas.ventas.model.entities.Venta;
import com.analistas.ventas.model.service.IProductoService;
import com.analistas.ventas.model.service.IVentaService;


@Controller
@RequestMapping("/ventas")
@SessionAttributes("venta")
public class VentaController {


    @Autowired
    IVentaService ventaService;

    @Autowired
    IProductoService productoService;

    @GetMapping(value = { "/listado" })
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de ventas");
        model.addAttribute("ventas", ventaService.buscarTodo());
        return "ventas/listado";
    }

    @GetMapping({"/nueva"})
    public String nuevaVenta(Model model){

        Venta venta = new Venta();
        model.addAttribute("venta",venta);
        return "ventas/form"; 
    }

    @PostMapping("/guardar")
    public String guardar (@Valid Venta venta, BindingResult result,
                           @RequestParam (name = "item_id[]", required = true) List<String> itemId,
                           @RequestParam (name = "cantidad[]", required = true) List<String> cantidad,
                            Model model, RedirectAttributes flash, SessionStatus status){

        //Verificar errores...
        if(result.hasErrors()){
            model.addAttribute("danger", "Corrija los errores...");
            return "ventas/form";
        }

        if(itemId == null || itemId.size() == 0){
            model.addAttribute("Warning", "Añadir productos a la venta...");
            return"ventas/form";
        }
        // Si no hay errores...
        LineaVenta linea;
        Producto producto;

        //Crear las lineas de la venta...
        for(int i = 0; i < itemId.size(); i++){

            linea = new LineaVenta();
            Long id = Long.parseLong(itemId.get(i));
            int cant = Integer.parseInt(cantidad.get(i));
            producto = productoService.BuscarPorId(id);
            
            linea.setProducto(producto);
            linea.setCantidad(cant);
            venta.addLinea(linea);
        }

        //Guardar la venta
        ventaService.guardar(venta);
        status.setComplete();
        flash.addFlashAttribute("success", "Venta registrada...");

        return "redirect:/ventas/listado";
    }

    @GetMapping(value = "/buscar-productos/{criterio}", produces = {"application/json"})
    public @ResponseBody List<Producto> cargarProductos(@PathVariable("criterio")String criterio){
        return productoService.buscarPor(criterio);
    }
}

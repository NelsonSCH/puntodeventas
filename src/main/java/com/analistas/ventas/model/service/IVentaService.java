package com.analistas.ventas.model.service;

import java.util.List;
import com.analistas.ventas.model.entities.Venta;

public interface IVentaService {
    
    public List<Venta>buscarTodo();

    public Venta buscarPorId(Long id);

    public void guardar(Venta venta);
}

package com.analistas.ventas.model.service;

import java.util.List;

import com.analistas.ventas.model.entities.Producto;

public interface IProductoService {
    public List<Producto> buscarTodo();

    public List<Producto> buscarPor(String criterio);
    
    public Producto BuscarPorId(Long id);

    public void guardar(Producto producto);
    
}

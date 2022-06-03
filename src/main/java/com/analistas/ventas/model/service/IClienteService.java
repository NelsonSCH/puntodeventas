package com.analistas.ventas.model.service;

import java.util.List;

import com.analistas.ventas.model.entities.Cliente;

public interface IClienteService {
    public List<Cliente> buscarTodo();

    public List<Cliente> buscarPor(String criterio);
    
    public Cliente BuscarPorId(Long id);

    public void guardar(Cliente cliente);
    
}

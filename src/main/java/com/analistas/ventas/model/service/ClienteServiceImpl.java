package com.analistas.ventas.model.service;

import java.util.List;

import com.analistas.ventas.model.entities.Cliente;
import com.analistas.ventas.model.repository.IClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl  implements IClienteService{

    //Forma tradicional es:
    // PClienteRepositoryImpl clienteRepo= new IClienteRepository();
    //DI (Dependence Injection) - IO(Inversion de control)
    //Principio de HolyWood(No me llames .... Yo te llamaré)
    @Autowired
    IClienteRepository clienteRepo;
 
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> buscarTodo() {
        return clienteRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> buscarPor(String criterio) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente BuscarPorId(Long id) {
        return clienteRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void guardar(Cliente cliente) {
        clienteRepo.save(cliente);
    }
    
}

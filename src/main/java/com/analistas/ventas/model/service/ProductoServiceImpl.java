package com.analistas.ventas.model.service;

import java.util.List;

import com.analistas.ventas.model.entities.Producto;
import com.analistas.ventas.model.repository.IProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl  implements IProductoService{

    //Forma tradicional es:
    // ProductoRepositoryImpl productoRepo= new IProductoRepository();
    //DI (Dependence Injection) - IO(Inversion de control)
    //Principio de HolyWood(No me llames .... Yo te llamaré)
    @Autowired
    IProductoRepository productoRepo;
 
    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarTodo() {
        return productoRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> buscarPor(String criterio) {

        return productoRepo.findByCriteria(criterio);
    }

    @Override
    @Transactional(readOnly = true)
    public Producto BuscarPorId(Long id) {
        return productoRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void guardar(Producto producto) {
        productoRepo.save(producto);
    }
    
}

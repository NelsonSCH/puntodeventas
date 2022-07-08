package com.analistas.ventas.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.analistas.ventas.model.entities.Venta;
import com.analistas.ventas.model.repository.IVentaRepository;

@Service
public class VentaServiceImpl implements IVentaService {

    @Autowired
    IVentaRepository ventaRepo;

    @Override
    @Transactional(readOnly = true)
    public List<Venta> buscarTodo() {
        return ventaRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Venta buscarPorId(Long id) {
        return ventaRepo.findById(id).orElse(null);
    }

    @Override
    public void guardar(Venta venta) {
       ventaRepo.save(venta);
        
    }
    
}

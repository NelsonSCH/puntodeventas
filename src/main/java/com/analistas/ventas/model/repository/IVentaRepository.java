package com.analistas.ventas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.analistas.ventas.model.entities.Venta;

public interface IVentaRepository extends JpaRepository<Venta,Long> {
    
}

package com.analistas.ventas.model.repository;

import com.analistas.ventas.model.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long>  {
    
}

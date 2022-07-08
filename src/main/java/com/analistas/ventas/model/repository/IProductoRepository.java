package com.analistas.ventas.model.repository;

import com.analistas.ventas.model.entities.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductoRepository extends JpaRepository<Producto, Long>  {
    
    //Equivalente en SQL:
    //Select * from productos where codigo_barras = ? or  descripcion like %?% and act = 1;
    @Query("Select p from Producto p where  p.codigoBarras like p.codigoBarras or p.descripcion like %:criterio%"
    + " and p.activo = true")
    List<Producto> findByCriteria(@Param("criterio")String criterio);
}

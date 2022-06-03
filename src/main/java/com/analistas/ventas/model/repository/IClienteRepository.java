package com.analistas.ventas.model.repository;

import com.analistas.ventas.model.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long>  {
    
}

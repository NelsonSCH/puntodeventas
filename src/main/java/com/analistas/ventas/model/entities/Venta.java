package com.analistas.ventas.model.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name ="ventas")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int numeroFactura;

    @NotNull(message="La fecha es requerida...")
    @DateTimeFormat(pattern ="dd/MM/yyyy HH:mm z")
    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Size(max = 65, message = "La descripción no debe superar los 65 caracteres")
    private String descripcion;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ventaId")
    private List<LineaVenta> lineas;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;
  

    
    public Venta() {
        lineas = new ArrayList<>();
        fechaHora = LocalDateTime.now();
        descripcion = "-";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<LineaVenta> getLineas() {
        return lineas;
    }

    public void setLinea(List<LineaVenta> lineas) {
        this.lineas = lineas;
        
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    //
    public void addLinea(LineaVenta linea) {
        lineas.add(linea);
    }

    public double getTotal()
    {
        double total = 0.0d;

        for(LineaVenta ln: lineas)
        {
            total += ln.getImporte();
        }
        return total;
    }
}

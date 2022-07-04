package com.analistas.ventas.model.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name="productos")
@Where(clause = "act = true")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cod_bar", length = 13)
    private String codigoBarras;

    @NotBlank(message = "La descripción es requerida... ")
    @Size(max = 65)
    private String descripcion;

    @NotNull(message = "El precio es requerido...")
    @NumberFormat(pattern = "#,##0.00", style = Style.CURRENCY)
    private BigDecimal precio;

    @NotNull(message = "El stock es requerido...")
    @Min(value = 1, message = "El stock no puede ser 0")
    private int stock;

    @Column(name = "url_img", length = 500)
    private String linkImagen;

    @Column(name = "act", columnDefinition =  "bit default 1")
    private boolean activo;

    public Producto() {
        activo = true;
    }


    public Producto(Long id, String codigoBarras, String descripcion, BigDecimal precio, int stock, String linkImagen, boolean activo) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.linkImagen = linkImagen;
        this.activo = activo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getLinkImagen() {
        return linkImagen;
    }

    public void setLinkImagen(String linkImagen) {
        this.linkImagen = linkImagen;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Producto [activo=" + activo + ", codigoBarras=" + codigoBarras + ", descripcion=" + descripcion
                + ", id=" + id + ", linkImagen=" + linkImagen + ", precio=" + precio + ", stock=" + stock + "]";
    }
    
}
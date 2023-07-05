package com.onvent.gestionProducto.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String stock;
    private Double precio;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "catalogo_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Catalogo catalogo;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Catalogo getCatalogo() {
        return catalogo;
    }
    
    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }
}

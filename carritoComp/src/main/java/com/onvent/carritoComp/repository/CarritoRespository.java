package com.onvent.carritoComp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onvent.carritoComp.entity.Carrito;

public interface CarritoRespository extends JpaRepository <Carrito, Integer>{
    
}

package com.onvent.gestionProducto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onvent.gestionProducto.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{


}
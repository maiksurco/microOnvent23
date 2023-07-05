package com.onvent.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onvent.pedido.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
    
}

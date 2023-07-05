package com.onvent.pedido.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.onvent.pedido.entity.DetallePedido;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long>{
    
}

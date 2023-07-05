package com.onvent.pedido.service;

import java.util.List;

import com.onvent.pedido.entity.DetallePedido;

public interface DetallePedidoService {
    List<DetallePedido> getAllDetallesPedido();
    DetallePedido getDetallePedidoById(Long id);
    DetallePedido createDetallePedido(DetallePedido detallePedido);
    DetallePedido updateDetallePedido(Long id, DetallePedido detallePedido);
    void deleteDetallePedido(Long id);
}

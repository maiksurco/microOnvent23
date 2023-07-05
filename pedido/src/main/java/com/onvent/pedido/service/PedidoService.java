package com.onvent.pedido.service;

import com.onvent.pedido.entity.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> getAllPedidos();
    Pedido getPedidoById(Integer id);
    Pedido createPedido(Pedido pedido);
    Pedido updatePedido(Integer id, Pedido pedido);
    void deletePedido(Integer id);
}


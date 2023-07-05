package com.onvent.pedido.service.impl;

import com.onvent.pedido.entity.Pedido;
import com.onvent.pedido.repository.PedidoRepository;
import com.onvent.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    @Autowired
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido getPedidoById(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @Override
    public Pedido createPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido updatePedido(Integer id, Pedido pedido) {
        Pedido existingPedido = pedidoRepository.findById(id).orElse(null);
        if (existingPedido != null) {
            // Actualizar los atributos del pedido existente con los valores proporcionados
            existingPedido.setUsua_id(pedido.getUsua_id());
            existingPedido.setFecha(pedido.getFecha());
            existingPedido.setEstado(pedido.getEstado());
            existingPedido.setTotal(pedido.getTotal());
            existingPedido.setEmail(pedido.getEmail());

            // Guardar los cambios en la base de datos
            return pedidoRepository.save(existingPedido);
        }
        return null;
    }

    @Override
    public void deletePedido(Integer id) {
        pedidoRepository.deleteById(id);
    }
}

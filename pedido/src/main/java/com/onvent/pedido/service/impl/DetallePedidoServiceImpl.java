package com.onvent.pedido.service.impl;

import com.onvent.pedido.entity.DetallePedido;
import com.onvent.pedido.repository.DetallePedidoRepository;
import com.onvent.pedido.service.DetallePedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;

    @Autowired
    public DetallePedidoServiceImpl(DetallePedidoRepository detallePedidoRepository) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    @Override
    public List<DetallePedido> getAllDetallesPedido() {
        return detallePedidoRepository.findAll();
    }

    @Override
    public DetallePedido getDetallePedidoById(Long id) {
        return detallePedidoRepository.findById(id).orElse(null);
    }

    @Override
    public DetallePedido createDetallePedido(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @Override
    public DetallePedido updateDetallePedido(Long id, DetallePedido detallePedido) {
        DetallePedido existingDetallePedido = detallePedidoRepository.findById(id).orElse(null);
        if (existingDetallePedido != null) {
            // Actualizar los atributos del detalle pedido existente con los valores proporcionados
            existingDetallePedido.setPedido(detallePedido.getPedido());
            existingDetallePedido.setProducto(detallePedido.getProducto());
            existingDetallePedido.setCantidad(detallePedido.getCantidad());
            existingDetallePedido.setPrecioUnitario(detallePedido.getPrecioUnitario());
            existingDetallePedido.setSubtotal(detallePedido.getSubtotal());

            // Guardar los cambios en la base de datos
            return detallePedidoRepository.save(existingDetallePedido);
        }
        return null;
    }

    @Override
    public void deleteDetallePedido(Long id) {
        detallePedidoRepository.deleteById(id);
    }
}


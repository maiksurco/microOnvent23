package com.onvent.pedido.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.onvent.pedido.repository.DetallePedidoRepository;

import com.onvent.pedido.entity.DetallePedido;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4201", "http://localhost:4200"})
@RequestMapping("/detalle-pedidos")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @GetMapping
    public List<DetallePedido> getAllDetallesPedido() {
        return detallePedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public DetallePedido getDetallePedidoById(@PathVariable Long id) {
        return detallePedidoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public DetallePedido createDetallePedido(@RequestBody DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    @PutMapping("/{id}")
    public DetallePedido updateDetallePedido(@PathVariable Long id, @RequestBody DetallePedido detallePedido) {
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

    @DeleteMapping("/{id}")
    public void deleteDetallePedido(@PathVariable Long id) {
        detallePedidoRepository.deleteById(id);
    }
}

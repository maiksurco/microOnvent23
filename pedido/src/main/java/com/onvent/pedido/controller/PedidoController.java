package com.onvent.pedido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.onvent.pedido.entity.Pedido;
import com.onvent.pedido.repository.PedidoRepository;



import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4201", "http://localhost:4200"})
@RequestMapping("/pedidos")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping
    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Pedido getPedidoById(@PathVariable Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Pedido createPedido(@RequestBody Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @PutMapping("/{id}")
    public Pedido updatePedido(@PathVariable Integer id, @RequestBody Pedido pedido) {
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

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Integer id) {
        pedidoRepository.deleteById(id);
    }
}

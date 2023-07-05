package com.onvent.carritoComp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onvent.carritoComp.entity.Carrito;
import com.onvent.carritoComp.service.CarritoService;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {
     @Autowired
    private CarritoService carritoService;

    @GetMapping()
    public ResponseEntity<List<Carrito>> list() {
        return ResponseEntity.ok().body(carritoService.listar());
    }

    @PostMapping()
    public ResponseEntity<Carrito> save(@RequestBody Carrito carrito) {
        return ResponseEntity.ok(carritoService.guardar(carrito));
    }

    @PutMapping()
    public ResponseEntity<Carrito> update(@RequestBody Carrito carrito) {
        return ResponseEntity.ok(carritoService.actualizar(carrito));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(carritoService.listarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        carritoService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }
    
}

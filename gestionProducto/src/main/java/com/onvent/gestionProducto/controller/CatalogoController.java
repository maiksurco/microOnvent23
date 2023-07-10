package com.onvent.gestionProducto.controller;

import com.onvent.gestionProducto.entity.Catalogo;
import com.onvent.gestionProducto.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4201", "http://localhost:4200"})
@RequestMapping("/catalogo")
public class CatalogoController {
    @Autowired
    private CatalogoService catalogoService;

    @GetMapping()
    public ResponseEntity<List<Catalogo>> list() {
        return ResponseEntity.ok().body(catalogoService.listar());
    }

    @PostMapping()
    public ResponseEntity<Catalogo> save(@RequestBody Catalogo catalogo) {
        return ResponseEntity.ok(catalogoService.guardar(catalogo));
    }

    @PutMapping()
    public ResponseEntity<Catalogo> update(@RequestBody Catalogo catalogo) {
        return ResponseEntity.ok(catalogoService.actualizar(catalogo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalogo> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(catalogoService.listarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable(required = true) Integer id) {
        catalogoService.eliminarPorId(id);
        return "Eliminacion Correcta";
    }
}


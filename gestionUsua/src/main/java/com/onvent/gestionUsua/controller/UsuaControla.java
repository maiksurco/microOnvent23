package com.onvent.gestionUsua.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.onvent.gestionUsua.entity.Usua;
import com.onvent.gestionUsua.service.UsuaService;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuaControla {
    @Autowired
    private final UsuaService usuaService;
    
    public UsuaControla(UsuaService usuaService) {
        this.usuaService = usuaService;
    }

    @GetMapping
    public ResponseEntity<List<Usua>> getAllUsua() {
        List<Usua> usua = usuaService.getAllUsua();
        return ResponseEntity.ok(usua);
    }

    @PostMapping
    public ResponseEntity<Usua> createUsua(@RequestBody Usua usua) {
        Usua createdUsua = usuaService.createUsua(usua);
        return ResponseEntity.ok(createdUsua);
    }

    @PutMapping
    public ResponseEntity<Usua> updateUsua(@PathVariable Integer userId, @RequestBody Usua usua) {
        Usua updatedUsua = usuaService.updateUsua(userId, usua);
        return ResponseEntity.ok(updatedUsua);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsua(@PathVariable Integer usuaId) {
        usuaService.deleteUsua(usuaId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usua> getUsuaById(@PathVariable Integer usuaId) {
        Usua usua = usuaService.getUsuaById(usuaId);
        return ResponseEntity.ok(usua);
    }
}

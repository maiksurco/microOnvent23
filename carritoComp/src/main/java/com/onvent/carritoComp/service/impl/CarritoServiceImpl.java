package com.onvent.carritoComp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onvent.carritoComp.entity.Carrito;
import com.onvent.carritoComp.repository.CarritoRespository;
import com.onvent.carritoComp.service.CarritoService;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private CarritoRespository carritoRespository;

    @Override
    public List<Carrito> listar() {
        return carritoRespository.findAll();
    }

    @Override
    public Carrito guardar(Carrito carrito) {
        return carritoRespository.save(carrito);
    }

    @Override
    public Carrito actualizar(Carrito carrito) {
        return carritoRespository.save(carrito);
    }

    @Override
    public Optional<Carrito> listarPorId(Integer id) {
        return carritoRespository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        carritoRespository.deleteById(id);
    }
}

package com.onvent.carritoComp.service;

import com.onvent.carritoComp.entity.Carrito;

import java.util.List;
import java.util.Optional;

public interface CarritoService {
     public List<Carrito> listar();


    public Carrito guardar(Carrito carrito);

    public Carrito actualizar(Carrito carrito);

    public Optional<Carrito> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}

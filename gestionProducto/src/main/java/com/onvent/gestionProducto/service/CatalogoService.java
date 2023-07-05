package com.onvent.gestionProducto.service;

import com.onvent.gestionProducto.entity.Catalogo;

import java.util.List;
import java.util.Optional;


public interface CatalogoService {
    public List<Catalogo> listar();

    public Catalogo guardar(Catalogo catalogo);

    public Catalogo actualizar(Catalogo catalogo);

    public Optional<Catalogo> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}

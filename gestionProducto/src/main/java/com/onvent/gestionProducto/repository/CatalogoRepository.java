package com.onvent.gestionProducto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.onvent.gestionProducto.entity.Catalogo;

public interface CatalogoRepository extends JpaRepository<Catalogo, Integer>{
    
}

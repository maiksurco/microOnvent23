package com.onvent.gestionUsua.service;

import java.util.List;
import java.util.Optional;

import com.onvent.gestionUsua.entity.Usua;


public interface UsuaService {
    Usua createUsua(Usua Usua);
    Usua updateUsua(Integer UsuaId, Usua Usua);
    void deleteUsua(Integer UsuaId);
    Usua getUsuaById(Integer UsuaId);
    List<Usua> getAllUsua();
}

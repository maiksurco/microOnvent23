package com.onvent.gestionUsua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onvent.gestionUsua.entity.Usua;
import com.onvent.gestionUsua.repository.UsuaRepository;
import com.onvent.gestionUsua.service.UsuaService;
import com.onvent.gestionUsua.exception.UsuarioNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

@Service
public class UsuaServiceImpl implements UsuaService {
    private final UsuaRepository usuaRepository;

    public UsuaServiceImpl(UsuaRepository usuaRepository) {
        this.usuaRepository = usuaRepository;
    }

    @Override
    public Usua createUsua(Usua usua) {
        return usuaRepository.save(usua);
    }

    @Override
    public Usua updateUsua(Integer usuaId, Usua usua) {
        Usua existingUsua = usuaRepository.findById(usuaId)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con ID: " + usuaId));

        existingUsua.setNombre(usua.getNombre());
        existingUsua.setApellido(usua.getApellido());
        existingUsua.setEmail(usua.getEmail());


        return usuaRepository.save(existingUsua);
    }

    @Override
    public void deleteUsua(Integer usuaId) {
        usuaRepository.deleteById(usuaId);
    }

    @Override
    public Usua getUsuaById(Integer usuaId) {
        return usuaRepository.findById(usuaId)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con ID: " + usuaId));
    }

    @Override
    public List<Usua> getAllUsua() {
        return usuaRepository.findAll();
    }

}

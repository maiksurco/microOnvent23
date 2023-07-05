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
        // Lógica para crear un nuevo usuario en la base de datos
        return usuaRepository.save(usua);
    }

    @Override
    public Usua updateUsua(Integer usuaId, Usua usua) {
        // Lógica para actualizar los datos de un usuario existente en la base de datos
        Usua existingUsua = usuaRepository.findById(usuaId)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con ID: " + usuaId));

        // Actualizar los atributos del usuario existente con los valores proporcionados
        existingUsua.setNombre(usua.getNombre());
        existingUsua.setApellido(usua.getApellido());
        existingUsua.setEmail(usua.getEmail());

        // Guardar los cambios en la base de datos
        return usuaRepository.save(existingUsua);
    }

    @Override
    public void deleteUsua(Integer usuaId) {
        // Lógica para eliminar un usuario de la base de datos
        usuaRepository.deleteById(usuaId);
    }

    @Override
    public Usua getUsuaById(Integer usuaId) {
        // Lógica para obtener un usuario por su ID desde la base de datos
        return usuaRepository.findById(usuaId)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado con ID: " + usuaId));
    }

    @Override
    public List<Usua> getAllUsua() {
        // Lógica para obtener todos los usuarios de la base de datos
        return usuaRepository.findAll();
    }

}

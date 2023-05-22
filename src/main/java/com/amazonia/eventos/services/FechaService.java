package com.amazonia.eventos.services;

import com.amazonia.eventos.models.Fecha;
import com.amazonia.eventos.repositories.IFechaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FechaService {
    @Autowired
    private IFechaRepository iFechaRepository;
    public Fecha obtenerFechaEvento(Integer idFecha) {
        Optional<Fecha> fechaEnBase = iFechaRepository.findById(idFecha);
        return fechaEnBase.orElse(null);
    }
}

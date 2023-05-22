package com.amazonia.eventos.services;

import com.amazonia.eventos.models.Evento;
import com.amazonia.eventos.repositories.IEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    private IEventoRepository iEventoRepository;
    public List<Evento> obtenerEventos (){
        return iEventoRepository.findAll();
    }
    public Evento guardarEvento(Evento evento) {
        return iEventoRepository.save(evento);
    }
    public Evento obtenerEventoPorId(Integer idEvento) {
        Optional<Evento> eventoEnBase = iEventoRepository.findById(idEvento);
        return eventoEnBase.orElse(null);
    }
}

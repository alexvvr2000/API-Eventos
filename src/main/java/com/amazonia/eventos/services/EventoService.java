package com.amazonia.eventos.services;

import com.amazonia.eventos.models.Evento;
import com.amazonia.eventos.repositories.IEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {
    @Autowired
    private IEventoRepository iEventoRepository;
    public Evento guardarEvento(Evento evento) {
        return iEventoRepository.save(evento);
    }
    public Evento obtenerEventoPorId(Integer idEvento) {
        Optional<Evento> eventoEnBase = iEventoRepository.findById(idEvento);
        return eventoEnBase.orElse(null);
    }
    public void eliminarEvento(Integer idEvento) {
        iEventoRepository.deleteById(idEvento);
    }
}

package com.amazonia.eventos.controllers;

import com.amazonia.eventos.models.Evento;
import com.amazonia.eventos.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amazonia")
public class EventoController {
    @Autowired
    private EventoService eventoService;
    @GetMapping("/eventos")
    public List<Evento> eventosEnBase(){
        return eventoService.obtenerEventos();
    }
    @PutMapping("/eventos")
    public Evento agregarEvento(@Validated @RequestBody Evento nuevoEvento){
        return eventoService.guardarEvento(nuevoEvento);
    }
}

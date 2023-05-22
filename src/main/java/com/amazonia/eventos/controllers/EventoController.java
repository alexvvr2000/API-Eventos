package com.amazonia.eventos.controllers;

import com.amazonia.eventos.models.Evento;
import com.amazonia.eventos.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/amazonia")
public class EventoController {
    @Autowired
    private EventoService eventoService;
    @GetMapping("/eventos")
    public List<Evento> eventosEnBase(){
        return eventoService.obtenerEventos();
    }
    @PostMapping("/eventos")
    public Evento agregarEvento(@Validated @RequestBody Evento nuevoEvento){
        return eventoService.guardarEvento(nuevoEvento);
    }
    @PutMapping("/eventos/{idEvento}")
    public Evento actualizarEvento(
            @PathVariable(name = "idEvento") Integer idEvento,
            @RequestBody Map<String, String> descripcion
    ){
        if (!descripcion.containsKey("descripcion")) throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Campo descripcion vacio"
        );
        Evento eventoEnBase = eventoService.obtenerEventoPorId(idEvento);
        eventoEnBase.setDescripcion(descripcion.get("descripcion"));
        return eventoService.guardarEvento(eventoEnBase);
    }
    @DeleteMapping("/eventos/{idEvento}")
    public void actualizarEvento(
            @PathVariable(name = "idEvento") Integer idEvento
    ){
        if(idEvento == null) throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Evento es nulo"
        );
        eventoService.eliminarEvento(idEvento);
    }
}

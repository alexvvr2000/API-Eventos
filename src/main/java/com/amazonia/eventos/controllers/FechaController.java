package com.amazonia.eventos.controllers;

import com.amazonia.eventos.models.Evento;
import com.amazonia.eventos.models.Fecha;
import com.amazonia.eventos.services.EventoService;
import com.amazonia.eventos.services.FechaService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/api/amazonia")
public class FechaController {
    @Autowired
    private FechaService fechaService;
    @GetMapping("/fecha/{idFecha}")
    public Fecha obtenerFechaPorId(@PathVariable(name = "idFecha") Integer idFecha){
        Fecha fechaEnBase = fechaService.obtenerFechaEvento(idFecha);
        if(fechaEnBase == null) throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "ID no existe en base"
        );
        return fechaEnBase;
    }
    @PutMapping("/fecha/{idFecha}")
    public Fecha modificarFecha(
            @PathVariable(name = "idFecha") Integer idFecha,
            @RequestBody Map<String, Object> datosNuevos
    ) {
        try {
            return fechaService.actualizarFecha(idFecha, datosNuevos);
        } catch (Exception e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_MODIFIED, "Query invalido"
            );
        }
    }
    @PostMapping("/fecha/{idEvento}")
    public Fecha agregarFechaEvento(
            @Validated @RequestBody Fecha fechaEvento
    ){
        try {
            return fechaService.agregarFecha(fechaEvento);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.PARTIAL_CONTENT, "Datos faltantes"
            );
        }
    }
}

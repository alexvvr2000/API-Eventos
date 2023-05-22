package com.amazonia.eventos.controllers;

import com.amazonia.eventos.models.Fecha;
import com.amazonia.eventos.services.FechaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
}

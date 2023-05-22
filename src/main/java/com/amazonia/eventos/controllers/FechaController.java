package com.amazonia.eventos.controllers;

import com.amazonia.eventos.models.Fecha;
import com.amazonia.eventos.services.FechaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        Fecha fechaNueva = fechaService.actualizarFecha(idFecha, datosNuevos);
        if(fechaNueva == null) throw new ResponseStatusException(
                HttpStatus.NOT_ACCEPTABLE, "Campos no son parte de fecha"
        );
        return fechaNueva;
    }
}

package com.amazonia.eventos.services;

import com.amazonia.eventos.models.Fecha;
import com.amazonia.eventos.repositories.IFechaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
import java.util.Optional;

@Service
public class FechaService {
    @Autowired
    private IFechaRepository iFechaRepository;
    public Fecha obtenerFechaEvento(Integer idFecha) {
        Optional<Fecha> fechaEnBase = iFechaRepository.findById(idFecha);
        return fechaEnBase.orElse(null);
    }
    public Fecha agregarFecha(Fecha fechaNueva) {
        return iFechaRepository.save(fechaNueva);
    }
    public Fecha actualizarFecha(Integer idFecha, Map<String, Object> datosNuevos) throws Exception{
        Fecha fechaEnBase = obtenerFechaEvento(idFecha);
        if(fechaEnBase == null) throw new Exception("No se encontro id en base");
        for(String campoActual: datosNuevos.keySet()){
            Object nuevoDato = datosNuevos.get(campoActual);
            switch (campoActual) {
                case "dia" -> fechaEnBase.setDia(LocalDate.parse((String) nuevoDato));
                case "hora" -> fechaEnBase.setHora(LocalTime.parse((String) nuevoDato));
                case "cancelado" -> fechaEnBase.setCancelado((boolean) datosNuevos.get(campoActual));
                case "ubicacion" -> fechaEnBase.setUbicacion((String) datosNuevos.get(campoActual));
                default -> throw new Exception(
                        String.format("%s no es un campo valido", campoActual)
                );
            }
        }
        return iFechaRepository.save(fechaEnBase);
    }
    public boolean borrarFechaEvento(Integer idFecha) {
        boolean existeFecha = iFechaRepository.existsById(idFecha);
        if(!existeFecha) return false;
        iFechaRepository.deleteById(idFecha);
        return true;
    }
}

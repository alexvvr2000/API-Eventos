package com.amazonia.eventos.models;

import jakarta.persistence.*;

@Entity(name = "Evento")
@Table(name = "\"Evento\"", schema = "public")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvento")
    private Integer idEvento;
    @Column(name = "descripcion", nullable = false, unique = true, length = 50)
    private String descripcion;
    public Integer getId() {
        return this.idEvento;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

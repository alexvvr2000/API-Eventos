package com.amazonia.eventos.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Evento")
@Table(name = "\"Evento\"", schema = "public")
public class Evento implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvento", unique = true)
    private Integer idEvento;
    @Column(name = "descripcion", nullable = false, unique = true, length = 50)
    private String descripcion;
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "idFecha"
    )
    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "evento", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Fecha> fechasEvento = new HashSet<Fecha>();
    public Integer getId() {
        return this.idEvento;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Integer getIdEvento() {
        return idEvento;
    }
    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }
    public Set<Fecha> getFechasEvento() {
        return fechasEvento;
    }
    public void setFechasEvento(Set<Fecha> fechasEvento) {
        this.fechasEvento = fechasEvento;
    }
}

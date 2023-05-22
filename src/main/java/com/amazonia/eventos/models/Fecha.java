package com.amazonia.eventos.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Fecha")
@Table(name = "\"Fecha\"", schema = "public")
public class Fecha implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFecha", unique = true)
    private Integer idFecha;
    @ManyToOne
    @JoinColumn(
            name = "idEvento",
            referencedColumnName = "idEvento",
            foreignKey = @ForeignKey(
                    name = "fk_fecha_evento",
                    foreignKeyDefinition = "FOREIGN KEY (idEvento) " +
                            "REFERENCES public.\"Evento\" (idEvento) MATCH SIMPLE " +
                            "ON UPDATE CASCADE " +
                            "ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            ),
            nullable = false
    )
    private Evento evento;
    @Column(name = "diaHora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date diaHora;
    @Column(name = "precioAsiento", columnDefinition = "Decimal(10,2)")
    private Double precioAsiento;
    @Column(name = "asientosDisponibles", nullable = false)
    private Integer asientosDisponibles = 0;
    @Column(name = "cancelado", columnDefinition = "boolean default 'false'")
    private boolean cancelado = false;
    @Column(name = "ubicacion", length = 30, nullable = false)
    private String ubicacion;
    public Evento getEvento() {
        return evento;
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public Date getDiaHora() {
        return diaHora;
    }
    public void setDiaHora(Date diaHora) {
        this.diaHora = diaHora;
    }
    public Double getPrecioAsiento() {
        return precioAsiento;
    }
    public void setPrecioAsiento(Double precioAsiento) {
        this.precioAsiento = precioAsiento;
    }
    public boolean isCancelado() {
        return cancelado;
    }
    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
    public Integer getAsientosDisponibles() {
        return asientosDisponibles;
    }
    public void setAsientosDisponibles(Integer asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public Integer getIdFecha() {
        return idFecha;
    }
}

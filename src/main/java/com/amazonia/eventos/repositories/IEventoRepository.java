package com.amazonia.eventos.repositories;

import com.amazonia.eventos.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEventoRepository extends JpaRepository<Evento, Integer> {
}

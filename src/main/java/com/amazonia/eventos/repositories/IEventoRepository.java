package com.amazonia.eventos.repositories;

import com.amazonia.eventos.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEventoRepository extends JpaRepository<Evento, Integer> {
}

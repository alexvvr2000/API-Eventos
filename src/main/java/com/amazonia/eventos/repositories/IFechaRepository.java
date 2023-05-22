package com.amazonia.eventos.repositories;

import com.amazonia.eventos.models.Fecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFechaRepository extends JpaRepository<Fecha, Integer> {
}

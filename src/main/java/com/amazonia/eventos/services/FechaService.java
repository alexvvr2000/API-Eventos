package com.amazonia.eventos.services;

import com.amazonia.eventos.repositories.IFechaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FechaService {
    @Autowired
    private IFechaRepository iFechaRepository;
}

package com.amazonia.eventos.controllers;

import com.amazonia.eventos.services.FechaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/amazonia")
public class FechaController {
    @Autowired
    private FechaService fechaService;
}

package com.nttdata.BackEnd.controller;

import com.nttdata.BackEnd.model.TipoDocumento;
import com.nttdata.BackEnd.service.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipos-documento")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public List<TipoDocumento> getAllTipos() {
        return tipoDocumentoService.getAllTipos();
    }
}
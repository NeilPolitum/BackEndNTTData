package com.nttdata.BackEnd.controller;

import com.nttdata.BackEnd.model.TipoDocumento;
import com.nttdata.BackEnd.service.TipoDocumentoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private static final Logger logger = LoggerFactory.getLogger(TipoDocumentoController.class);

    @GetMapping
    public ResponseEntity<List<TipoDocumento>> getAllTipos() {
        try {
            List<TipoDocumento> tiposDocumento = tipoDocumentoService.getAllTipos();
            if (tiposDocumento.isEmpty()) {
                logger.info("No se encontraron tipos de documento.");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            logger.info("Tipos de documento recuperados exitosamente.");
            return new ResponseEntity<>(tiposDocumento, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error al recuperar los tipos de documento: ", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
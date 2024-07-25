package com.nttdata.BackEnd.service;

import com.nttdata.BackEnd.model.TipoDocumento;
import com.nttdata.BackEnd.repository.TipoDocumentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    public List<TipoDocumento> getAllTipos() {
        return tipoDocumentoRepository.findAll();
    }
}
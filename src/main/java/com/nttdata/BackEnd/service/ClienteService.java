package com.nttdata.BackEnd.service;

import com.nttdata.BackEnd.model.Cliente;
import com.nttdata.BackEnd.model.TipoDocumento;
import com.nttdata.BackEnd.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    public Optional<Cliente> getByTipoDocumentoAndId(TipoDocumento tipoDocumento, Long id) {
        return clienteRepository.findByTipoDocumentoAndId(tipoDocumento, id);
    }
}
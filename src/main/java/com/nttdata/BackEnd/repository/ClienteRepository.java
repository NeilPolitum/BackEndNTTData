package com.nttdata.BackEnd.repository;

import com.nttdata.BackEnd.model.Cliente;
import com.nttdata.BackEnd.model.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // List<Cliente> findAll();
    // Optional<Cliente> findById(Long id);
    // Cliente save(Cliente cliente);
    // void deleteById(Long id);
    Optional<Cliente> findByTipoDocumentoAndId(TipoDocumento tipoDocumento, Long id);
}
package com.nttdata.BackEnd.repository;

import com.nttdata.BackEnd.model.Cliente;
import com.nttdata.BackEnd.model.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByTipoDocumentoAndId(TipoDocumento tipoDocumento, Long id);
}
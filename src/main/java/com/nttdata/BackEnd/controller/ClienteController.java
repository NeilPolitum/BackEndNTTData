package com.nttdata.BackEnd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.nttdata.BackEnd.model.Cliente;
import com.nttdata.BackEnd.model.TipoDocumento;
import com.nttdata.BackEnd.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        return clienteService.findById(id)
            .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/buscar")
    public ResponseEntity<Cliente> getCliente(@RequestParam String tipoDocumentoId, @RequestParam Long id) {
        try {
            TipoDocumento tipoDocumento = new TipoDocumento();
            tipoDocumento.setId(tipoDocumentoId);
            log.info("Entra a buscar cliente");
            return clienteService.getByTipoDocumentoAndId(tipoDocumento, id)
                .map(cliente -> {
                    log.info("Cliente encontrado");
                    return new ResponseEntity<>(cliente, HttpStatus.OK);
                })
                .orElseGet(() -> {
                    log.warn("Cliente no encontrado con este tipo de documento y número de documento");
                    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
                });
        } catch (Exception e) {
            log.error("Error al obtener el cliente", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        try {
            Cliente savedCliente = clienteService.save(cliente);
            return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al crear cliente", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        return clienteService.findById(id).map(cliente -> {
            clienteService.deleteById(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
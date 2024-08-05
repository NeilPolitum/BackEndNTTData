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

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private static final Logger log = LoggerFactory.getLogger(ClienteController.class);

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        log.info("Solicitud para obtener todos los clientes");
        try {
            List<Cliente> clientes = clienteService.findAll();
            if (clientes.isEmpty()) {
                log.warn("No se encontraron clientes");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            log.info("Clientes obtenidos exitosamente");
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener todos los clientes", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
        log.info("Solicitud para obtener cliente con ID");
        try {
            Optional<Cliente> cliente = clienteService.findById(id);
            return cliente.map(value -> {
                log.info("Cliente encontrado con ID");
                return new ResponseEntity<>(value, HttpStatus.OK);
            }).orElseGet(() -> {
                log.warn("Cliente no encontrado con ID");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            });
        } catch (Exception e) {
            log.error("Error al obtener el cliente por ID", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<Cliente> getCliente(@RequestParam String tipoDocumentoId, @RequestParam Long id) {
        log.info("Solicitud para buscar cliente con tipoDocumento y ID");
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
        log.info("Solicitud para crear un nuevo cliente");
        try {
            Cliente savedCliente = clienteService.save(cliente);
            log.info("Cliente creado exitosamente");
            return new ResponseEntity<>(savedCliente, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al crear cliente", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        log.info("Solicitud para eliminar cliente con ID");
        return clienteService.findById(id).map(cliente -> {
            clienteService.deleteById(id);
            log.info("Cliente eliminado con ID");
            return new ResponseEntity<Void>(HttpStatus.OK);
        }).orElseGet(() -> {
            log.warn("Cliente no encontrado con ID");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        });
    }
}
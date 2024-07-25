package com.nttdata.BackEnd.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void testClienteGettersAndSetters() {
        Cliente cliente = new Cliente();
        cliente.setId(23445322L);
        cliente.setFirstName("Daniel");
        cliente.setMiddleName("Santiago");
        cliente.setLastName("Rubiano");
        cliente.setSecondLastName("Pulido");
        cliente.setPhone("1234567890");
        cliente.setAddress("Calle 95 con 21");
        cliente.setCity("Bogota DC");

        assertEquals(23445322, cliente.getId());
        assertEquals("Daniel", cliente.getFirstName());
        assertEquals("Santiago", cliente.getMiddleName());
        assertEquals("Rubiano", cliente.getLastName());
        assertEquals("Pulido", cliente.getSecondLastName());
        assertEquals("1234567890", cliente.getPhone());
        assertEquals("Calle 95 con 21", cliente.getAddress());
        assertEquals("Bogota DC", cliente.getCity());
    }
}
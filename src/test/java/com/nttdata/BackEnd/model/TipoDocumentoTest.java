package com.nttdata.BackEnd.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TipoDocumentoTest {

    @Test
    public void testTipoDocumentoGettersAndSetters() {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setId("23445322");
        tipoDocumento.setTipo("C");

        assertEquals("23445322", tipoDocumento.getId());
        assertEquals("C", tipoDocumento.getTipo());
    }
}
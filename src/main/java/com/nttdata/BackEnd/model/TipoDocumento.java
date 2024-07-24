package com.nttdata.BackEnd.model;

import javax.persistence.*;

@Entity
@Table(name = "tipo_documento")
public class TipoDocumento {
    @Id
    @Column(nullable = false, length = 1)
    private String id;

    @Column(nullable = false)
    private String tipo;

    public TipoDocumento() {
    }

    public TipoDocumento(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
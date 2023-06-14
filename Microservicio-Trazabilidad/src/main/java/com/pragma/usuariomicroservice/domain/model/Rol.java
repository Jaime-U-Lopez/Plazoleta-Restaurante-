package com.pragma.usuariomicroservice.domain.model;

import com.pragma.usuariomicroservice.adapters.http.dto.TipoRol;

public class Rol {
    private Long id;
    private TipoRol tipoRol;
    private String descripcion;

    public Rol() {
    }

    public Rol(Long id, TipoRol tipoRol, String descripcion) {
        this.id = id;
        this.tipoRol = tipoRol;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoRol getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(TipoRol tipoRol) {
        this.tipoRol = tipoRol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

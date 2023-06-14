package com.pragma.usuariomicroservice.adapters.http.dto;

public enum TipoRol {
    CLIENTE("CLIENTE"),
    PROPIETARIO("PROPIETARIO"),
    ADMINISTRADOR("ADMINISTRADOR"),
    EMPLEADO("EMPLEADO");

    private final String name;

    TipoRol(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}

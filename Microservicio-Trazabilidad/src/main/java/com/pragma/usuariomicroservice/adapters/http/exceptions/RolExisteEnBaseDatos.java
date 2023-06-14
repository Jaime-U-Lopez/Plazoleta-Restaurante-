package com.pragma.usuariomicroservice.adapters.http.exceptions;

public class RolExisteEnBaseDatos extends RuntimeException {

    public RolExisteEnBaseDatos(String message) {
        super(message);
    }

}

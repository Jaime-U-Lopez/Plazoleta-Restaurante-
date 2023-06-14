package com.pragma.usuariomicroservice.domain.api;

import com.pragma.usuariomicroservice.adapters.http.dto.TipoRol;
import com.pragma.usuariomicroservice.domain.model.Usuario;

public interface IUsuarioServicePort {

    void guardarUser(Usuario usuario, TipoRol rol);

    void deleteUsuario(Usuario usuario);

    Usuario getUsuario(Long id);
    Boolean validarPropietario(Long id);
}

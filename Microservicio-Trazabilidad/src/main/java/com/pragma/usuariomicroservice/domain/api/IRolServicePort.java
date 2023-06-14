package com.pragma.usuariomicroservice.domain.api;

import com.pragma.usuariomicroservice.adapters.http.dto.TipoRol;
import com.pragma.usuariomicroservice.domain.model.Rol;
import com.pragma.usuariomicroservice.domain.model.Usuario;

import java.util.List;

public interface IRolServicePort {


    List<Rol> getAllRoles();

    void saveRole(Rol rol);

    void deleteRole(Rol rol);

    Rol getRole(Long id);

}

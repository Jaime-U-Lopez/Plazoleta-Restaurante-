package com.pragma.usuariomicroservice.domain.spi;

import com.pragma.usuariomicroservice.domain.model.Rol;
import com.pragma.usuariomicroservice.domain.model.Usuario;

import java.util.List;

public interface IRolPersistencePort {

    List<Rol> getAllRoles();

    void save(Rol rol);

    void deleteRol(Rol rol);

    Rol getRole(Long id);


}

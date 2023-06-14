package com.pragma.usuariomicroservice.domain.usecase;

import com.pragma.usuariomicroservice.domain.api.IRolServicePort;
import com.pragma.usuariomicroservice.domain.model.Rol;
import com.pragma.usuariomicroservice.domain.model.Usuario;
import com.pragma.usuariomicroservice.domain.spi.IRolPersistencePort;

import java.util.List;

public class RolUseCase implements IRolServicePort {

    private final IRolPersistencePort rolPersistencePort;

    public RolUseCase(IRolPersistencePort rolPersistencePort) {
        this.rolPersistencePort = rolPersistencePort;
    }




    @Override
    public List<Rol> getAllRoles() {
        return this.rolPersistencePort.getAllRoles();
    }


    @Override
    public void saveRole(Rol rol) {

        this.rolPersistencePort.save(rol);

    }

    @Override
    public void deleteRole(Rol rol) {
     this.rolPersistencePort.deleteRol(rol);

    }

    @Override
    public Rol getRole(Long id) {
        return rolPersistencePort.getRole(id);
    }
}

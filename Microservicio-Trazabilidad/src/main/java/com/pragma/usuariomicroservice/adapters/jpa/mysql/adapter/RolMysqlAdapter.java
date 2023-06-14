package com.pragma.usuariomicroservice.adapters.jpa.mysql.adapter;

import com.pragma.usuariomicroservice.adapters.http.exceptions.RolExisteEnBaseDatos;
import com.pragma.usuariomicroservice.adapters.http.exceptions.RolNoExiste;
import com.pragma.usuariomicroservice.adapters.http.exceptions.UsuarioNoSeEncuentraRegistradoException;
import com.pragma.usuariomicroservice.adapters.jpa.mysql.entity.RolEntity;
import com.pragma.usuariomicroservice.adapters.jpa.mysql.mapper.RolEntityMapper;
import com.pragma.usuariomicroservice.adapters.jpa.mysql.repository.IRolRepository;
import com.pragma.usuariomicroservice.configuration.Constants;
import com.pragma.usuariomicroservice.domain.model.Rol;
import com.pragma.usuariomicroservice.domain.spi.IRolPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RolMysqlAdapter implements IRolPersistencePort {
    private final IRolRepository rolRepository;
    private final RolEntityMapper rolEntityMapper;

    @Override
    public List<Rol> getAllRoles() {
        List<RolEntity> rolEntityList = rolRepository.findAll();
        if(rolEntityList.isEmpty()) {
            throw new RolNoExiste(Constants.ROL_NO_REGISTRADO);

        }
        return rolEntityMapper.toRolList(rolEntityList);
    }

    @Override
    public void save(Rol rol) {
        Optional<RolEntity> rolEntity = this.rolRepository.findById(rol.getId());
     if(rolEntity.isPresent()){
         throw new RolExisteEnBaseDatos(Constants.ROL_YA_EXISTE);
     }

        this.rolRepository.save(this.rolEntityMapper.roltoRolEntity(rol));

    }

    @Override
    public void deleteRol(Rol rol) {
        Optional<RolEntity>  rolEntity = rolRepository.findById(rol.getId());
        if(rolEntity.isPresent()) {
            throw new RolNoExiste(Constants.ROL_NO_REGISTRADO);
        }

        this.rolRepository.delete(this.rolEntityMapper.roltoRolEntity(rol));

    }

    @Override
    public Rol getRole(Long id) {
        Optional<RolEntity> rolEntity=  this.rolRepository.findById(id);
        if(!rolEntity.isPresent()){
            throw new RolNoExiste(Constants.ROL_NO_REGISTRADO);
        }
        return  this.rolEntityMapper.rolEntityToRol(rolEntity.get());
    }
}

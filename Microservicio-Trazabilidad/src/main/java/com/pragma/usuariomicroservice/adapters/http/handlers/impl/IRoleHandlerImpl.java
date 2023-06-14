package com.pragma.usuariomicroservice.adapters.http.handlers.impl;

import com.pragma.usuariomicroservice.adapters.http.dto.TipoRol;
import com.pragma.usuariomicroservice.adapters.http.dto.request.RolRequestDto;
import com.pragma.usuariomicroservice.adapters.http.dto.response.RolResponseDto;
import com.pragma.usuariomicroservice.adapters.http.exceptions.RolNoExisteTipoRol;
import com.pragma.usuariomicroservice.adapters.http.handlers.IRoleHandler;
import com.pragma.usuariomicroservice.adapters.http.mapper.IRoleRequestMapper;
import com.pragma.usuariomicroservice.adapters.http.mapper.IRoleResponseMapper;
import com.pragma.usuariomicroservice.configuration.Constants;
import com.pragma.usuariomicroservice.domain.api.IRolServicePort;
import com.pragma.usuariomicroservice.domain.model.Rol;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IRoleHandlerImpl implements IRoleHandler {

    private final IRoleResponseMapper roleResponseMapper;
    private final IRolServicePort rolServicePort;
    private final IRoleRequestMapper roleRequestMapper;


    @Override
    public List<RolResponseDto> getAllRoles() {
        return roleResponseMapper.toResponseList(rolServicePort.getAllRoles());
    }


    @Override
    public void saveRol(RolRequestDto rolRequestDto ) {

        TipoRol rol1= TipoRol.CLIENTE;
        TipoRol rol2= TipoRol.EMPLEADO;
        TipoRol rol3= TipoRol.PROPIETARIO;
        TipoRol rol4= TipoRol.ADMINISTRADOR;
        if(rol1.equals(rolRequestDto.getTipoRol())||
                rol2.equals(rolRequestDto.getTipoRol())||
                rol3.equals(rolRequestDto.getTipoRol())||
                rol4.equals(rolRequestDto.getTipoRol())){
            Rol rol = roleRequestMapper.toRol(rolRequestDto);
            rolServicePort.saveRole(rol);
        }else{
            throw new RolNoExisteTipoRol(Constants.NO_EXISTE_TIPO_ROL);

        }

    }

    @Override
    public void deleteRol(RolResponseDto rolResponseDto) {
        Rol rol = roleResponseMapper.toRol(rolResponseDto);
        rolServicePort.deleteRole(rol);
    }

    @Override
    public RolResponseDto getRol(Long id) {
        return roleResponseMapper.toRolDTO(rolServicePort.getRole(id));
    }

}

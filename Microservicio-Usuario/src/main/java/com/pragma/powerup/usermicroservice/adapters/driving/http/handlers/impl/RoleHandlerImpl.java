package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.RolRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.RoleResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IRoleHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IRoleRequestMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IRoleResponseMapper;
import com.pragma.powerup.usermicroservice.domain.api.IRoleServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleHandlerImpl implements IRoleHandler {
    private final IRoleResponseMapper roleResponseMapper;
    private final IRoleRequestMapper roleRequestMapper;
    private final IRoleServicePort roleServicePort;

    @Override
    public List<RoleResponseDto> getAllRoles() {

        return roleResponseMapper.toResponseList(roleServicePort.getAllRoles());
    }

    @Override
    public RoleResponseDto createRol(RolRequestDto rolRequestDto) {

        RoleResponseDto  roleResponse =   new RoleResponseDto();
        roleResponse.setId(rolRequestDto.getId());
        roleResponse.setName(rolRequestDto.getName());
        roleResponse.setDescription(rolRequestDto.getDescription());

        this.roleServicePort.createRoles(this.roleRequestMapper.toRole(rolRequestDto));

        return roleResponse;
         }
}

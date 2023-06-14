package com.pragma.usuariomicroservice.adapters.http.handlers;


import com.pragma.usuariomicroservice.adapters.http.dto.request.RolRequestDto;
import com.pragma.usuariomicroservice.adapters.http.dto.request.UsuarioRequestDto;
import com.pragma.usuariomicroservice.adapters.http.dto.response.RolResponseDto;
import com.pragma.usuariomicroservice.adapters.http.dto.response.UsuarioResponseDto;

import java.util.List;

public interface IRoleHandler {
    List<RolResponseDto> getAllRoles();
    void saveRol(RolRequestDto rolRequestDto);
    void deleteRol(RolResponseDto rolResponseDto);

    RolResponseDto getRol(Long id);

}

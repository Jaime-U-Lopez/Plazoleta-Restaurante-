package com.pragma.usuariomicroservice.adapters.http.handlers;

import com.pragma.usuariomicroservice.adapters.http.dto.request.UsuarioRequestDto;
import com.pragma.usuariomicroservice.adapters.http.dto.response.UsuarioResponseDto;

public interface IUsuarioHandler {

    void saveUser(UsuarioRequestDto usuarioRequestDto);

    void deleteUsuario(UsuarioRequestDto usuarioRequestDto);

    UsuarioResponseDto getUsuario(Long id);
    Boolean validarUser(Long id);



}

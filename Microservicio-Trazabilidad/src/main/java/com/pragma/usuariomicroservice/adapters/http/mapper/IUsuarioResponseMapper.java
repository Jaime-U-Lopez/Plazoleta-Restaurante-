package com.pragma.usuariomicroservice.adapters.http.mapper;

import com.pragma.usuariomicroservice.adapters.http.dto.response.UsuarioResponseDto;
import com.pragma.usuariomicroservice.domain.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUsuarioResponseMapper {

    UsuarioResponseDto usuarioToUsuarioResponse(Usuario usuario);

}

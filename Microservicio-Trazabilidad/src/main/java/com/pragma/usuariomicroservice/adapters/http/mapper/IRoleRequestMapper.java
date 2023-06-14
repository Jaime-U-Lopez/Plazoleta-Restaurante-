package com.pragma.usuariomicroservice.adapters.http.mapper;


import com.pragma.usuariomicroservice.adapters.http.dto.request.RolRequestDto;
import com.pragma.usuariomicroservice.adapters.http.dto.response.RolResponseDto;
import com.pragma.usuariomicroservice.domain.model.Rol;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleRequestMapper {

    Rol toRol(RolRequestDto rolRequestDto);
    List<RolResponseDto> toResponseList(List<Rol> roleList);
}

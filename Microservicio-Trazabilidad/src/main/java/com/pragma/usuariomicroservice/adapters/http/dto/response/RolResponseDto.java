package com.pragma.usuariomicroservice.adapters.http.dto.response;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class RolResponseDto {
    private Long id;
    private String nombre;
    private String descripcion;
}

package com.pragma.usuariomicroservice.adapters.http.dto.request;

import com.pragma.usuariomicroservice.adapters.http.dto.TipoRol;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioRequestDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;

    private TipoRol tipoRol;
    @NotBlank
    @Pattern( message = "El correo debe tener el formato correcto.", regexp = "[A-Za-z0-9+_.-]+@(.+\\.[A-Za-z]+)$")
    private String correo;
    @NotBlank
    @Pattern(message = "El numero de documento debe ser solo numerico.", regexp = "^[0-9]+$")
    @Positive(message = "El numero de documento no puede ser negativo.")
    private String numeroDocumento;
    @NotBlank
    @Pattern(regexp = "^(\\+\\d{1,3})?((\\d{1,3})|\\d{1,3})\\d{3,4}\\d{4}$", message = "el numero de celular debe tener el formato correcto.")
    @Size(min = 6, max = 13, message = "El numero de celular debe tener entre 6 y 13 digitos.")
    @Positive(message = "El numero de celular no puede ser negativo")
    private String celular;
    @NotBlank
    private String fechaNacimiento;
    @NotBlank
    private String password;
}

package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class EmployeeRequestDto {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String dniNumber;
    @NotBlank
    @Pattern(regexp = "^(\\+\\d{1,3})?((\\d{1,3})|\\d{1,3})\\d{3,4}\\d{4}$", message = "El numero de celular debe tener el formato correcto ejemplo : +573017199695. ")
    @Size(min = 6, max = 13, message = "El numero de celular debe tener entre 6 y 13 digitos.")
    @Positive(message = "El numero de celular no puede ser negativo")
    private String phone;



    @NotBlank
    @Pattern( message = "El correo debe tener el formato correcto. ejemplo pepe@hotmail.com", regexp = "[A-Za-z0-9+_.-]+@(.+\\.[A-Za-z]+)$")
    private String email;

    @Positive(message = "El numero de rol no puede ser negativo")
    private Long idRole;


    @NotBlank
    private String password;





}

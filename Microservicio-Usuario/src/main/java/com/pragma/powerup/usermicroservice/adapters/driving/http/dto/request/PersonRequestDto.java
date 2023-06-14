package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;


@AllArgsConstructor
@Getter
public class PersonRequestDto {
    @NotBlank
    private String name;

    @NotBlank
    private String surname;
    @NotBlank
    @Pattern( message = "El correo debe tener el formato correcto.", regexp = "[A-Za-z0-9+_.-]+@(.+\\.[A-Za-z]+)$")
    private String mail;
    @NotBlank
    @Pattern(regexp = "^(\\+\\d{1,3})?((\\d{1,3})|\\d{1,3})\\d{3,4}\\d{4}$", message = "el numero de celular debe tener el formato correcto.")
    @Size(min = 6, max = 13, message = "El numero de celular debe tener entre 6 y 13 digitos.")
    @Positive(message = "El numero de celular no puede ser negativo")
    private String phone;
    @NotBlank
    private String address;
    @NotBlank
    private String idDniType;
    @NotBlank
    private String dniNumber;
    @NotBlank
    private String idPersonType;
    @NotBlank
    private String password;

    @Schema(description = "Birthdate is optional -> The format is dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Nullable
    private LocalDate birthDate;

}

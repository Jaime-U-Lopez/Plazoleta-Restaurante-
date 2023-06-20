package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponseDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String dniNumber;
    private String birthDate;
    private Long idRole;
}

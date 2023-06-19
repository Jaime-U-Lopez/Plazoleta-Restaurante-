package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.PersonRequestDto;
import com.pragma.powerup.usermicroservice.domain.model.User;

public interface IPersonHandler {
    User savePerson(PersonRequestDto personRequestDto);

}

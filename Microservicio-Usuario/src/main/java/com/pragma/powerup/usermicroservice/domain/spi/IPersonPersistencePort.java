package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.User;

public interface IPersonPersistencePort {
    User savePerson(User user);
}

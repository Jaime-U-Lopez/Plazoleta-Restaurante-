package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.domain.model.User;

import java.util.List;

public interface IUserPersistencePort {
    void saveUser(User user);
    void deleteUser(User user);
    List<User> getAllProviders(int page);
    User getProvider(String email);
    User getEmployee(String email);
    User getClient(String email);

    User getOwner(String email);
}

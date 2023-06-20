package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IRoleRepository;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.ClientRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.EmployeeRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.OwnerRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IPersonResponseMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IRoleRequestMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IUserRequestMapper;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {


    private final IRoleRepository roleRepository;
    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IPersonResponseMapper personResponseMapper;
private final IRoleRequestMapper roleRequestMapper;

    @Override
    public void saveUser(UserRequestDto userRequestDto) {

        userServicePort.saveUser(userRequestMapper.toUser(userRequestDto));
    }

    @Override
    public void saveOwner(OwnerRequestDto ownerRequestDto) {
        User user =userRequestMapper.ownerRequestDtotoUser(ownerRequestDto);
        Role role= roleRequestMapper.roleEntitytoRole(roleRepository.findById(4l).get());
        user.setRole(role);
        userServicePort.saveUser(user);
    }

    @Override
    public void saveClient(ClientRequestDto clientRequestDto) {
        userServicePort.saveUser(userRequestMapper.clientRequestDtotoUser(clientRequestDto));
    }

    @Override
    public void saveEmployee(EmployeeRequestDto employeeRequestDto) {
        userServicePort.saveUser(userRequestMapper.employeeRequestDtotoUser(employeeRequestDto));
    }

    @Override
    public void deleteUser(UserRequestDto userRequestDto) {
        userServicePort.deleteUser(userRequestMapper.toUser(userRequestDto));
    }

    @Override
    public List<UserResponseDto> getProvider(Integer page) {
        return personResponseMapper.userListToPersonResponseList(userServicePort.getAllProviders(page));
    }

    @Override
    public UserResponseDto getProvider(String  email) {
        return personResponseMapper.userToUserResponse(userServicePort.getProvider(email));
    }

    @Override
    public UserResponseDto getEmployee(String  email) {
        return personResponseMapper.userToUserResponse(userServicePort.getEmployee(email));
    }

    @Override
    public UserResponseDto getClient(String  email) {
        return personResponseMapper.userToUserResponse(userServicePort.getClient(email));
    }

    @Override
    public UserResponseDto getOwner(String  email) {
        return personResponseMapper.userToUserResponse(userServicePort.getOwner(email));
    }
}

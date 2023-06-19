package com.pragma.powerup.usermicroservice.adapters.driving.http.mapper;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.*;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {

    @Mapping(target = "role.id", source = "idRole")
    User toUser(UserRequestDto userRequestDto);


    User ownerRequestDtotoUser(OwnerRequestDto ownerRequestDto );
    @Mapping(target = "role.id", source = "idRole")
    User clientRequestDtotoUser(ClientRequestDto clientRequestDto );
    @Mapping(target = "role.id", source = "idRole")
    User employeeRequestDtotoUser(EmployeeRequestDto employeeRequestDto );


}

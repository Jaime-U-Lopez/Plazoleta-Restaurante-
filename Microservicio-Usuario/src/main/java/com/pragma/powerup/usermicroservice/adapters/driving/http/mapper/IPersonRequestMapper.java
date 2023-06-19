package com.pragma.powerup.usermicroservice.adapters.driving.http.mapper;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.ClientRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.EmployeeRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.OwnerRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.PersonRequestDto;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPersonRequestMapper {


    @Mapping(target = "role.id", source = "idRole")
    User toPerson(PersonRequestDto personRequestDto);



    PersonRequestDto toPersonRequestDTO(OwnerRequestDto ownerRequestDto );
    @Mapping(target = "idRole", source = "idRole")
    PersonRequestDto toPersonRequestDTO(ClientRequestDto clientRequestDto );
    @Mapping(target = "idRole", source = "idRole")
    PersonRequestDto toPersonRequestDTO(EmployeeRequestDto EmployeeRequestDto );

}

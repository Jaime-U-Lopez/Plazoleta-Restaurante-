package com.pragma.usuariomicroservice.adapters.http.controller;

import com.pragma.usuariomicroservice.adapters.http.dto.request.RolRequestDto;
import com.pragma.usuariomicroservice.adapters.http.dto.request.UsuarioRequestDto;
import com.pragma.usuariomicroservice.adapters.http.dto.response.RolResponseDto;
import com.pragma.usuariomicroservice.adapters.http.handlers.IRoleHandler;
import com.pragma.usuariomicroservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role/v1")
@RequiredArgsConstructor
//@SecurityRequirement(name = "jwt")
public class RoleRestController {
    private final IRoleHandler roleHandler;

    @Operation(summary = "mostrar todos los roles ",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All roles returned",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = RolResponseDto.class)))),
                    @ApiResponse(responseCode = "404", description = "No data found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("/")
    public ResponseEntity<List<RolResponseDto>> getAllRoles() {
        return ResponseEntity.ok(roleHandler.getAllRoles());
    }

    @Operation(summary = "Get all the roles",
            responses = {
                    @ApiResponse(responseCode = "200", description = "All roles returned",
                            content = @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = RolResponseDto.class)))),
                    @ApiResponse(responseCode = "404", description = "No data found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("/")
    public ResponseEntity<Map<String, String>>  createRole(@Valid @RequestBody RolRequestDto requestDto ) {
        roleHandler.saveRol(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY,Constants.ROL_CREADO_CON_EXITO)
        );
    }


    @Operation(summary = "Elimine un rol ",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Role deleted",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "404", description = "User not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})

    @DeleteMapping("")
    public ResponseEntity<Map<String, String>> deleteUser(@RequestBody RolResponseDto rolResponseDto) {
        roleHandler.deleteRol(rolResponseDto);
        return ResponseEntity.ok(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.ROL_ELIMINADO_CON_EXITO));
    }



}

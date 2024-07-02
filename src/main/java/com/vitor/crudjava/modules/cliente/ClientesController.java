package com.vitor.crudjava.modules.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitor.crudjava.exceptions.ExceptionResponse;
import com.vitor.crudjava.modules.cliente.dto.CreateClienteDTO;
import com.vitor.crudjava.modules.cliente.dto.GetClienteDTO;
import com.vitor.crudjava.modules.cliente.dto.PaginatedClientesDTO;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

@RestController
@RequestMapping("/clientes")
@Tag(name = "clientes", description = "Endpoints de clientes")
public class ClientesController {

    @Autowired
	private ClientesService clientesService;
    
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida",
                content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
        @ApiResponse(responseCode = "404", description = "Nenhum cliente encontrado",
                content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @GetMapping()
    public PaginatedClientesDTO getClientes(@RequestParam(defaultValue = "10") @Min(1) int limit,
                                            @RequestParam(defaultValue = "0") @Min(0) int offset) {
        return clientesService.getAllClientes(limit,offset);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida",
                content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
        @ApiResponse(responseCode = "404", description = "Cliente não encontrado",
                content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @GetMapping("/{id}")
    public GetClienteDTO getClienteById(@PathVariable @Min(1) Long id) {
        return clientesService.getCliente(id);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida",
                content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
        @ApiResponse(responseCode = "409", description = "Conflito, cliente já cadastrado",
                content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @PostMapping()
    public GetClienteDTO createCliente(@Valid @RequestBody CreateClienteDTO payload){

        return clientesService.createCliente(payload);
    }
}

package com.vitor.crudjava.modules.cliente;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitor.crudjava.exceptions.ExceptionResponse;
import com.vitor.crudjava.modules.cliente.dto.CreateClienteDTO;
import com.vitor.crudjava.modules.cliente.dto.GetClienteDTO;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
@Tag(name = "clientes", description = "Endpoints de clientes")
public class ClientesController {
    
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @GetMapping()
    public List<GetClienteDTO> getClientes() {

        GetClienteDTO cliente1 = new GetClienteDTO("Nome1", "email1@example.com", "01-01-2000", 123456789L, "111111111-11");
        GetClienteDTO cliente2 = new GetClienteDTO("Nome2", "email2@example.com", "02-02-2000", 987654321L, "222.222.222-22");
        
        return Arrays.asList(cliente1, cliente2);
    }

    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida",
                content = @Content(schema = @Schema(implementation = ExceptionResponse.class))),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor",
                content = @Content(schema = @Schema(implementation = ExceptionResponse.class)))
    })
    @PostMapping()
    public GetClienteDTO createCliente(@Valid @RequestBody CreateClienteDTO payload){
        return new GetClienteDTO(payload.getNome(), payload.getEmail(), payload.getAniversario(), payload.getTelefone(),payload.getCpf() );
    }
}

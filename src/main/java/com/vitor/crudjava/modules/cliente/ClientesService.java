package com.vitor.crudjava.modules.cliente;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitor.crudjava.exceptions.httpExceptions.ConflictException;
import com.vitor.crudjava.exceptions.httpExceptions.NotFoundException;
import com.vitor.crudjava.modules.cliente.dto.CreateClienteDTO;
import com.vitor.crudjava.modules.cliente.dto.GetClienteDTO;
import com.vitor.crudjava.modules.cliente.dto.PaginatedClientesDTO;
import com.vitor.crudjava.modules.cliente.models.ClienteEntity;
import com.vitor.crudjava.modules.cliente.repositories.ClienteRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

@Service
public class ClientesService {
    @Autowired
    ClienteRepository clienteRepository ;

    public GetClienteDTO createCliente(CreateClienteDTO dto){
        try{
            ClienteEntity newCliente = clienteRepository.save(CreateClienteDTO.toEntity(dto));
            return new GetClienteDTO(newCliente);
        }
        catch(DataIntegrityViolationException e){
            throw new ConflictException("Cliente já cadastrado. Ha outro cliente com este email ou este cpf");
        }
    }

    public List<GetClienteDTO> getAllClientes() {
        List<ClienteEntity> clientes = clienteRepository.findAll();
        return clientes.stream().map(GetClienteDTO::new).collect(Collectors.toList());
    }




    public PaginatedClientesDTO getAllClientes(int limit, int offset) {
        Pageable pageable = PageRequest.of(offset, limit);
        List<ClienteEntity> clientes = clienteRepository.findAllBy(pageable);
        if(clientes.size()==0) throw new NotFoundException("Nenhum cliente encontrado");
        List<GetClienteDTO> clienteDTOs = clientes.stream().map(GetClienteDTO::new).collect(Collectors.toList());

        boolean hasNextPage = clienteRepository.count() > (offset + 1) * limit;

        return new PaginatedClientesDTO(clienteDTOs, hasNextPage);
    }
    
    public GetClienteDTO getCliente(Long id){
        ClienteEntity cliente = clienteRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Nenhum cliente encontrado"));

        return new GetClienteDTO(cliente);
    }


}

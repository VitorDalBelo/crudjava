package com.vitor.crudjava.modules.cliente.dto;

import java.util.List;

public class PaginatedClientesDTO {
    private List<GetClienteDTO> clientes;
    private boolean hasNextPage;

    public PaginatedClientesDTO(List<GetClienteDTO> clientes, boolean hasNextPage) {
        this.clientes = clientes;
        this.hasNextPage = hasNextPage;
    }

    public List<GetClienteDTO> getClientes() {
        return clientes;
    }

    public void setClientes(List<GetClienteDTO> clientes) {
        this.clientes = clientes;
    }

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }
}

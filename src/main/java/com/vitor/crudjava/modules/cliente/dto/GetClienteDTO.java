package com.vitor.crudjava.modules.cliente.dto;

import java.text.SimpleDateFormat;

import com.vitor.crudjava.modules.cliente.models.ClienteEntity;

public class GetClienteDTO {

    private Long id;
    private String nome;
    private String email;
    private String aniversario;
    private Long telefone;
    private String cpf;


    public GetClienteDTO(ClienteEntity entity) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.aniversario = dateFormat.format(entity.getAniversario());
        this.telefone = entity.getTelefone();
        this.cpf = entity.getCpf();
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAniversario() {
        return aniversario;
    }
    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }
    public Long getTelefone() {
        return telefone;
    }
    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}

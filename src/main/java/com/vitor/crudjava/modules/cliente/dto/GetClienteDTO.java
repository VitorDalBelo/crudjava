package com.vitor.crudjava.modules.cliente.dto;

import java.util.Random;

public class GetClienteDTO {

    private Long id;
    private String nome;
    private String email;
    private String aniversario;
    private Long telefone;
    private String cpf;

    public GetClienteDTO(String nome, String email, String aniversario, Long telefone, String cpf) {
        Random random = new Random();
        this.id = (long) (random.nextInt(999999) + 1);
        this.nome = nome;
        this.email = email;
        this.aniversario = aniversario;
        this.telefone = telefone;
        this.cpf = cpf;
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

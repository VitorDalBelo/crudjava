package com.vitor.crudjava;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class DTO {

    @NotNull(message = "O campo nome é obrigatório")
    private String nome;
    @NotNull(message = "O campo email é obrigatório")
    private String email;
    @NotNull(message = "O campo aniversario é obrigatório")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "O campo aniversario deve estar no formato YYYY-MM-DD") 
    @Schema(example = "1999-07-01") 
    private String aniversario;
    private String telefone;
    @NotNull(message = "O campo cpf é obrigatório") 
    private String cpf;

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
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
}

package com.vitor.crudjava.modules.cliente.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class CreateClienteDTO {

    @NotNull(message = "O campo nome é obrigatório")
    private String nome;
    @NotNull(message = "O campo email é obrigatório")
    @Email(message = "O campo email deve ser um endereço de email válido")
    private String email;
    @NotNull(message = "O campo aniversario é obrigatório")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "O campo aniversario deve estar no formato YYYY-MM-DD") 
    @Schema(example = "1999-07-01") 
    private String aniversario;
    @Positive(message = "O campo telefone deve ser um número positivo")
    @Min(value = 1000000000L, message = "O campo telefone deve ter no mínimo 10 dígitos")
    @Max(value = 99999999999L, message = "O campo telefone deve ter no máximo 11 dígitos")
    @Schema(example = "3599991020") 
    private Long telefone;
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

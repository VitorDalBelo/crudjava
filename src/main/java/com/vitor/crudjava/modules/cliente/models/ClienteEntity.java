package com.vitor.crudjava.modules.cliente.models;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.Check;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
@Check(constraints = "telefone >= 1000000000 AND telefone <= 99999999999")
public class ClienteEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private Date aniversario;
    @Column(nullable = true)
    private Long telefone;
    @Column(nullable = false)
    private String cpf;

    

    public ClienteEntity() {}
    public ClienteEntity(Long id, String nome, String email, Date aniversario, Long telefone, String cpf) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.aniversario = aniversario;
        this.telefone = telefone;
        this.cpf = cpf;
    }
    public ClienteEntity(String nome, String email, Date aniversario, Long telefone, String cpf) {
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
    public Date getAniversario() {
        return aniversario;
    }
    public void setAniversario(Date aniversario) {
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

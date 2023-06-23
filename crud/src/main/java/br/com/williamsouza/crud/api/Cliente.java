package br.com.williamsouza.crud.api;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Document
public class Cliente {
    @Id
    private String id;
    private String nome;
    private String email;
    private String cpf;

    public Cliente() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotEmpty(message = "nome não pode ser vazio!")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @NotEmpty(message = "e-mail não pode ser vazio!")
    @Email(message = "e-mail invalido!")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotEmpty(message = "cpf não pode ser vazio!")
    @CPF(message = "cpf invalido!")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

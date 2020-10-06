/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.model.pessoa_fisica;

import SistemaLoja.model.contato.Telefone;
import SistemaLoja.model.endereco.Endereco;
import java.sql.Date;

/**
 *
 * @author pedroh
 */
public class Cliente {
    private int idCliente;
    private String nome;
    private Date dataNascimento;
    private String email; 
    private Endereco endereco;
    private Telefone telefone; 

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Cliente(int idCliente, String nome, Date dataNascimento, String email, Endereco endereco, Telefone telefone) {
        setIdCliente(idCliente);
        setNome(nome);
        setDataNascimento(dataNascimento);
        setEmail(email);
        setEndereco(endereco);
        setTelefone(telefone);
    }
    
    
}

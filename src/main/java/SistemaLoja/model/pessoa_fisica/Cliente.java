/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.model.pessoa_fisica;

import SistemaLoja.database.pessoa_fisica.*;
import java.util.Date;

/**
 *
 * @author pedroh
 */
public class Cliente {
    private int idCliente;
    private int idfkTelefone;
    private int idfkResidencia;
    private String nome;
    private Date dataNascimento;
    private String email;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdfkTelefone() {
        return idfkTelefone;
    }

    public void setIdfkTelefone(int idfkTelefone) {
        this.idfkTelefone = idfkTelefone;
    }

    public int getIdfkResidencia() {
        return idfkResidencia;
    }

    public void setIdfkResidencia(int idfkResidencia) {
        this.idfkResidencia = idfkResidencia;
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

    public Cliente(int idCliente, int idfkTelefone, int idfkResidencia, String nome, Date dataNascimento, String email) {
        this.setIdCliente(idCliente);
        this.setIdfkTelefone(idfkTelefone);
        this.setIdfkResidencia(idfkResidencia);
        this.setNome(nome);
        this.setDataNascimento(dataNascimento);
        this.setEmail(email);
    }
    
    
}

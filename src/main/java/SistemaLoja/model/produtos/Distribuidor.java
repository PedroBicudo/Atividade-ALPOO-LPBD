/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.model.produtos;

import SistemaLoja.model.contato.TelefoneDistribuidor;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public class Distribuidor {
    private int idDistribuidor;
    private String nomeFantasia;
    private String razaoSocial;
    private String email;
    private ArrayList<TelefoneDistribuidor> telefones;

    public int getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<TelefoneDistribuidor> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<TelefoneDistribuidor> telefones) {
        this.telefones = telefones;
    }

    public Distribuidor(int idDistribuidor, String nomeFantasia, String razaoSocial, String email, ArrayList<TelefoneDistribuidor> telefones) {
        this.idDistribuidor = idDistribuidor;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.email = email;
        this.telefones = telefones;
    }

}

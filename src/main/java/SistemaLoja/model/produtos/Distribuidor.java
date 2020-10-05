/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.model.produtos;

/**
 *
 * @author pedroh
 */
public class Distribuidor {
    private int idDistribuidor;
    private String nomeFantasia;
    private String razaoSocial;
    private String email;

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

    public Distribuidor(int idDistribuidor, String nomeFantasia, String razaoSocial, String email) {
        this.setIdDistribuidor(idDistribuidor);
        this.setNomeFantasia(nomeFantasia);
        this.setRazaoSocial(razaoSocial);
        this.setEmail(email);
    }
    
}

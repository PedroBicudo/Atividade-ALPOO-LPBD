/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.model.endereco;

/**
 *
 * @author pedroh
 */
public class Rua {
    private int idRua;
    private int idfkBairro;
    private String nome;

    public int getIdRua() {
        return idRua;
    }

    public void setIdRua(int idRua) {
        this.idRua = idRua;
    }

    public int getIdfkBairro() {
        return idfkBairro;
    }

    public void setIdfkBairro(int idfkBairro) {
        this.idfkBairro = idfkBairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Rua(int idRua, int idfkBairro, String nome) {
        this.setIdRua(idRua);
        this.setIdfkBairro(idfkBairro);
        this.setNome(nome);
    }
    
}

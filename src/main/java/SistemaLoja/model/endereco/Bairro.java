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
public class Bairro {
    private int idBairro;
    private int idfkCidade;
    private String nome;

    public int getIdfkCidade() {
        return idfkCidade;
    }

    public void setIdfkCidade(int idfkCidade) {
        this.idfkCidade = idfkCidade;
    }
    
    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Bairro(int idBairro, int idfkCidade, String nome) {
        this.setIdBairro(idBairro);
        this.setNome(nome);
        this.setIdfkCidade(idfkCidade);
    }
    
}

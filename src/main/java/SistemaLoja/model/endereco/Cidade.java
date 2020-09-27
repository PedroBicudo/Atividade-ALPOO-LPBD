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
public class Cidade {
    private int idCidade;
    private int idfkEstado;
    private String nome;

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public int getIdfkEstado() {
        return idfkEstado;
    }

    public void setIdfkEstado(int idfkEstado) {
        this.idfkEstado = idfkEstado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade(int idCidade, int idfkEstado, String nome) {
        this.setIdCidade(idCidade);
        this.setIdfkEstado(idfkEstado);
        this.setNome(nome);
    }
    
}

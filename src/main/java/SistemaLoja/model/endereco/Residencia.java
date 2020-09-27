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
public class Residencia {
    private int idResidencia;
    private int idfkRua;
    private int numero;
    private String descricao;

    public int getIdResidencia() {
        return idResidencia;
    }

    public void setIdResidencia(int idResidencia) {
        this.idResidencia = idResidencia;
    }

    public int getIdfkRua() {
        return idfkRua;
    }

    public void setIdfkRua(int idfkRua) {
        this.idfkRua = idfkRua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Residencia(int idResidencia, int idfkRua, int numero, String descricao) {
        this.setIdResidencia(idResidencia);
        this.setIdfkRua(idfkRua);
        this.setNumero(numero);
        this.setDescricao(descricao);
    }
}

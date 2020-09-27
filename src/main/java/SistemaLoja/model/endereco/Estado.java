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
public class Estado {
    private int idEstado;
    private String sigla;
    private String nome;

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla.toUpperCase().substring(0, 2);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado(int idEstado, String sigla, String nome) {
        this.setIdEstado(idEstado);
        this.setSigla(sigla);
        this.setNome(nome);
    }

}

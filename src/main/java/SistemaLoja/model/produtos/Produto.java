/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.model.produtos;

import java.sql.Date;

/**
 *
 * @author pedroh
 */
public class Produto {
    private int idProduto;
    private int idfkDistribuidor;
    private int estoque;
    private Date dataValidade;
    private String descricao;
    private float precoCusto;
    private float precoVenda;

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdfkDistribuidor() {
        return idfkDistribuidor;
    }

    public void setIdfkDistribuidor(int idfkDistribuidor) {
        this.idfkDistribuidor = idfkDistribuidor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Produto(int idProduto, int idfkDistribuidor, int estoque, Date dataValidade, String descricao, float precoCusto, float precoVenda) {
        this.setIdProduto(idProduto);
        this.setIdfkDistribuidor(idfkDistribuidor);
        this.setEstoque(estoque);
        this.setDataValidade(dataValidade);
        this.setDescricao(descricao);
        this.setPrecoCusto(precoCusto);
        this.setPrecoVenda(precoVenda);
    }
    
    
    
}

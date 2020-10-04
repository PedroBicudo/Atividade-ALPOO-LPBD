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
public class ProdutoComprado {
    private Produto produto;
    private int quantidade;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public float getSubTotal() {
        return produto.getPrecoVenda()*quantidade;
    }

    public ProdutoComprado(Produto produto, int quantidade) {
        setProduto(produto);
        setQuantidade(quantidade);
    }
    
}

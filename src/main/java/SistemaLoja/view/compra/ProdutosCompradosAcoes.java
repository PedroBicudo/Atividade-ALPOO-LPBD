/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.view.compra;

import SistemaLoja.model.produtos.ProdutoComprado;

/**
 *
 * @author pedroh
 */
public interface ProdutosCompradosAcoes {
    public void atualizarProdutoComprado(int posicaoNaLista, ProdutoComprado produtoComprado);
    public void resetarTela();
}

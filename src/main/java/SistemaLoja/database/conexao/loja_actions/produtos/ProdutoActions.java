/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao.loja_actions.produtos;

import SistemaLoja.model.produtos.Produto;
import SistemaLoja.model.produtos.ProdutoComprado;
import SistemaLoja.model.produtos.Venda;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public interface ProdutoActions {
    public boolean atualizarEstoqueDoProduto(Produto produto, int quantiaCompradaDoEstoque);
    public void efetuarCompraDeProdutos(Venda venda, ArrayList<ProdutoComprado> produtosComprados);
    public boolean efetuarCompraDoProduto(Venda venda, ProdutoComprado produtoComprado);
}

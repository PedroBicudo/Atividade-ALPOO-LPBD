/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao.loja_actions.produtos;

import SistemaLoja.database.conexao.IBancoDao;
import SistemaLoja.model.produtos.ItemVenda;
import SistemaLoja.model.produtos.ProdutoComprado;
import SistemaLoja.model.produtos.Venda;
import SistemaLoja.model.produtos.Produto;
import SistemaLoja.utils.Mensagem;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public class ProdutoManipulator implements ProdutoActions {
    
    private IBancoDao database;

    public ProdutoManipulator(IBancoDao database) {
        this.database = database;
    }
    
    @Override
    public boolean atualizarEstoqueDoProduto(Produto produto, int quantiaCompradaDoEstoque) {
        produto.setEstoque(produto.getEstoque()-quantiaCompradaDoEstoque);
        return database.getAtualizarActions().atualizarProduto(produto);
    }
    
    @Override
    public void efetuarCompraDeProdutos(Venda venda, ArrayList<ProdutoComprado> produtosComprados) {
        for (ProdutoComprado produtoComprado: produtosComprados) {
            boolean isCompraDoProdutoEfetuada = efetuarCompraDoProduto(venda, produtoComprado);
            if (!isCompraDoProdutoEfetuada) {
                Mensagem.mostrarErro("A compra de '"+produtoComprado.getProduto().getDescricao()+"' nao foi concluida.");
            } else {
                Mensagem.mostrarSucesso("A compra de '"+produtoComprado.getProduto().getDescricao()+"' foi concluida.");
            }
        }
    }

    @Override
    public boolean efetuarCompraDoProduto(Venda venda, ProdutoComprado produtoComprado) {
        Produto produto = produtoComprado.getProduto();
        boolean isEstoqueDoProdutoAtualizado = atualizarEstoqueDoProduto(produto, produtoComprado.getQuantidade());
        
        if (!isEstoqueDoProdutoAtualizado) {
            return false;
        }
        
        ItemVenda produtoVendidoEmQuantidade = 
                new ItemVenda(
                        venda.getIdVenda(), 
                        produto.getIdProduto(), 
                        produtoComprado.getQuantidade(), 
                        produtoComprado.getSubTotal()
                );
        
        return database.getInserirActions().inserirItemVenda(produtoVendidoEmQuantidade);
    }
    
}

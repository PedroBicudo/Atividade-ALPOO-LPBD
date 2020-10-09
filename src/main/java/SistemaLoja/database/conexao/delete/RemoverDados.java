/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao.delete;

import SistemaLoja.model.pessoa_fisica.Cliente;
import SistemaLoja.model.produtos.Distribuidor;
import SistemaLoja.model.produtos.Produto;

/**
 *
 * @author pedroh
 */
public interface RemoverDados {
    public boolean removerDistribuidor(Distribuidor distribuidor);
    public boolean removerCliente(Cliente cliente);
    public boolean removerProduto(Produto produto);
}

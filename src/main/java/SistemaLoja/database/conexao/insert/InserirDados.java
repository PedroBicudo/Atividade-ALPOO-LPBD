/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao.insert;

import SistemaLoja.model.contato.Telefone;
import SistemaLoja.model.contato.TelefoneCliente;
import SistemaLoja.model.contato.TelefoneDistribuidor;
import SistemaLoja.model.endereco.Bairro;
import SistemaLoja.model.endereco.Residencia;
import SistemaLoja.model.endereco.Rua;
import SistemaLoja.model.pessoa_fisica.Cliente;
import SistemaLoja.model.produtos.Distribuidor;
import SistemaLoja.model.produtos.ItemVenda;
import SistemaLoja.model.produtos.Produto;
import SistemaLoja.model.produtos.Venda;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public interface InserirDados {
    public boolean inserirCliente(Cliente cliente);
    public boolean inserirDistribuidor(Distribuidor distribuidor);
    public boolean inserirTelefonesCliente(int idCliente, ArrayList<TelefoneCliente> telefones);
    public boolean inserirTelefonesDistribuidor(int idDistribuidor, ArrayList<TelefoneDistribuidor> telefones);
    public boolean inserirItemVenda(ItemVenda itemVenda);
    public boolean inserirProduto(Produto produto);
    public int inserirVenda(Venda venda);    
}

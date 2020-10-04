/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao;

import SistemaLoja.database.conexao.delete.RemoverDados;
import SistemaLoja.database.conexao.insert.InserirDados;
import SistemaLoja.database.conexao.loja_actions.produtos.ProdutoActions;
import SistemaLoja.database.conexao.select.SelecionarDados;
import SistemaLoja.database.conexao.update.AtualizarDados;
import SistemaLoja.model.contato.Telefone;
import SistemaLoja.model.endereco.Bairro;
import SistemaLoja.model.endereco.Cidade;
import SistemaLoja.model.endereco.Estado;
import SistemaLoja.model.endereco.Residencia;
import SistemaLoja.model.endereco.Rua;
import SistemaLoja.model.pessoa_fisica.Cliente;
import SistemaLoja.model.produtos.ClienteEVenda;
import SistemaLoja.model.produtos.Distribuidor;
import SistemaLoja.model.produtos.ItemVenda;
import SistemaLoja.model.produtos.Produto;
import SistemaLoja.model.produtos.ProdutoComprado;
import SistemaLoja.model.produtos.Venda;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public interface IBancoDao {
    
    public RemoverDados getRemoverActions();
    public InserirDados getInserirActions();
    public SelecionarDados getSelecionarActions();
    public AtualizarDados getAtualizarActions();
    public ProdutoActions getProdutoActions();
    public Connection getConnection();
    public void endConnection();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao.select;

import SistemaLoja.database.conexao.IBancoDao;
import SistemaLoja.model.contato.Telefone;
import SistemaLoja.model.contato.TelefoneCliente;
import SistemaLoja.model.endereco.Bairro;
import SistemaLoja.model.endereco.Cidade;
import SistemaLoja.model.endereco.Estado;
import SistemaLoja.model.endereco.Residencia;
import SistemaLoja.model.pessoa_fisica.Cliente;
import SistemaLoja.model.produtos.ClienteEVenda;
import SistemaLoja.model.produtos.Produto;
import SistemaLoja.model.produtos.Venda;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public interface SelecionarDados {
    public ArrayList<Estado> selecionarTodosOsEstados();
    public ArrayList<Cidade> selecionarCidadesByEstado(int estadoId);
    public ArrayList<Bairro> selecionarBairrosByCidade(int cidadeId);
    public ArrayList<Bairro> selecionarRuasByBairro(int bairroId);
    public ArrayList<Cliente> selecionarClientes();
    public ArrayList<Venda> selecionarVendas();
    public ArrayList<Produto> selecionarProdutos();
    public Residencia selecionarResidenciaById(int residenciaId);
    public Produto selecionarProdutoById(int produtoId);
    public Cliente selecionarClienteById(int clienteId);
    public ArrayList<TelefoneCliente> selecionarTelefonesByClienteId(int clienteId);
    public Venda selecionarUltimaCompraDoCliente(int clienteId);
    public ArrayList<Cliente> selecionarClientesSemEmail();
    public ArrayList<Produto> selecionarProdutosVencidos();
    public ArrayList<ClienteEVenda> selecionarVendasPorClienteEm2020();
}

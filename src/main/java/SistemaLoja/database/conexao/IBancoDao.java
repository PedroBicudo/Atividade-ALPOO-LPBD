/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao;

import SistemaLoja.model.contato.Telefone;
import SistemaLoja.model.endereco.Bairro;
import SistemaLoja.model.endereco.Cidade;
import SistemaLoja.model.endereco.Estado;
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
public interface IBancoDao {
    
    // Inserir dados
    public boolean inserirCliente(Cliente cliente);
    public boolean inserirTelefone(Telefone telefone);
    public boolean inserirBairro(Bairro bairro);
    public boolean inserirResidencia(Residencia residencia);
    public boolean inserirRua(Rua rua);
    public boolean inserirDistribuidor(Distribuidor distribuidor);
    public boolean inserirItemVenda(ItemVenda itemVenda);
    public boolean inserirProduto(Produto produto);
    public boolean inserirVenda(Venda venda);
    
    // Atualizar dados
    public boolean atualizarCliente(Cliente cliente);
    public boolean atualizarTelefone(Telefone telefone);
    public boolean atualizarResidencia(Residencia residencia);
    public boolean atualizarRua(Rua rua);
    public boolean atualizarDistribuidor(Distribuidor distribuidor);
    public boolean atualizarProduto(Produto produto);
    
    public boolean efetuarCompraDeProduto(Cliente cliente, Venda venda, Produto produto, int quantia);
    
    // Selecionar grupos de registros
    public ArrayList<Estado> selecionarTodosOsEstados();
    public ArrayList<Cidade> selecionarCidadesByEstado(int estadoId);
    public ArrayList<Bairro> selecionarBairrosByCidade(int cidadeId);
    public ArrayList<Bairro> selecionarRuasByBairro(int bairroId);
    
    // Selecionar um registro
    public Residencia selecionarResidenciaById(int residenciaId);
    public Produto selecionarProdutoById(int produtoId);
    
    // Métodos da atividade
    public ArrayList<Cliente> selecionarClientesSemAColunaEmail();
    public ArrayList<Produto> selecionarProdutosVencidos(); // Criar uma VIEW
    public void mostrarVendasPorClienteEm2020();
    public ArrayList<Venda> selecionarVendas();
    public float getValorEmDinheiroDoTotalDeVendas();
    
    // Encerrar conexão
    public void endConnection();
}

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
    public boolean inserirCidade(Cidade cidade);
    public boolean inserirEstado(Estado estado);
    public boolean inserirResidencia(Residencia residencia);
    public boolean inserirRua(Rua rua);
    public boolean inserirDistribuidor(Distribuidor distribuidor);
    public boolean inserirItemVenda(ItemVenda itemVenda);
    public boolean inserirProduto(Produto produto);
    public boolean inserirVenda(Venda venda);
    
    // Verificar se dados existem
    public boolean isClienteJaCriado(Cliente cliente);
    public boolean isTelefoneJaCriado(Telefone telefone);
    public boolean isBairroJaCriado(Bairro bairro);
    public boolean isCidadeJaCriado(Cidade cidade);
    public boolean isEstadoJaCriado(Estado estado);
    public boolean isResidenciaJaCriado(Residencia residencia);
    public boolean isRuaJaCriado(Rua rua);
    public boolean isDistribuidorJaCriado(Distribuidor distribuidor);
    public boolean isItemVendaJaCriado(ItemVenda itemVenda);
    public boolean isProdutoJaCriado(Produto produto);
    public boolean isVendaJaCriado(Venda venda);

    // Atualizar dados
    public boolean atualizarCliente(Cliente cliente);
    public boolean atualizarTelefone(Telefone telefone);
    public boolean atualizarResidencia(Residencia residencia);
    public boolean atualizarRua(Rua rua);
    public boolean atualizarDistribuidor(Distribuidor distribuidor);
    
    // Encerrar conexão
    public void endConnection();
}

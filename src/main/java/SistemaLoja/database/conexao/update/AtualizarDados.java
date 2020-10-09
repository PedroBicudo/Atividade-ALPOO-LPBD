/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao.update;

import SistemaLoja.model.contato.TelefoneCliente;
import SistemaLoja.model.contato.TelefoneDistribuidor;
import SistemaLoja.model.endereco.Residencia;
import SistemaLoja.model.endereco.Cidade;
import SistemaLoja.model.endereco.Bairro;
import SistemaLoja.model.endereco.Rua;
import SistemaLoja.model.pessoa_fisica.Cliente;
import SistemaLoja.model.produtos.Distribuidor;
import SistemaLoja.model.produtos.Produto;

/**
 *
 * @author pedroh
 */
public interface AtualizarDados {
    public boolean atualizarCliente(Cliente cliente);    
    public boolean atualizarTelefoneCliente(TelefoneCliente telefone);
    public boolean atualizarResidencia(Residencia residencia);
    public boolean atualizarRua(Rua rua);
    public boolean atualizarCidade(Cidade cidade);
    public boolean atualizarBairro(Bairro bairro);
    public boolean atualizarDistribuidor(Distribuidor distribuidor);
    public boolean atualizarTelefoneDistribuidor(TelefoneDistribuidor telefone);
    public boolean atualizarProduto(Produto produto);
}

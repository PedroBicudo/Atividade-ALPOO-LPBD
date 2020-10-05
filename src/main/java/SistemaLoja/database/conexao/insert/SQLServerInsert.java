/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao.insert;

import SistemaLoja.database.conexao.IBancoDao;
import SistemaLoja.model.contato.Telefone;
import SistemaLoja.model.endereco.Bairro;
import SistemaLoja.model.endereco.Residencia;
import SistemaLoja.model.endereco.Rua;
import SistemaLoja.model.pessoa_fisica.Cliente;
import SistemaLoja.model.produtos.Distribuidor;
import SistemaLoja.model.produtos.ItemVenda;
import SistemaLoja.model.produtos.Produto;
import SistemaLoja.model.produtos.Venda;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author pedroh
 */
public class SQLServerInsert implements InserirDados {
    
    private IBancoDao database;

    public SQLServerInsert(IBancoDao database) {
        this.database = database;
    }
    
    @Override
    public boolean inserirCliente(Cliente cliente) {
        try {
            String sqlInsert = "INSERT INTO CLIENTE(IDFK_RESIDENCIA, DATA_NASC, EMAIL, NOME) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlInsert);
            prepareStatement.setInt(1, cliente.getIdfkResidencia());
            prepareStatement.setDate(2, cliente.getDataNascimento());
            prepareStatement.setString(3, cliente.getEmail());
            prepareStatement.setString(4, cliente.getNome());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }
    }

    @Override
    public boolean inserirTelefone(Telefone telefone) {
        try {
            String sqlInsert = "INSERT INTO TELEFONE(TELEFONE) VALUES(?)";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlInsert);
            prepareStatement.setString(1, telefone.getTelefone());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }
    }

    @Override
    public boolean inserirBairro(Bairro bairro) {
        try {
            String sqlInsert = "INSERT INTO BAIRRO(NOME, IDFK_CIDADE) VALUES(?, ?)";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlInsert);
            prepareStatement.setString(1, bairro.getNome());
            prepareStatement.setInt(2, bairro.getIdfkCidade());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }
    }

    @Override
    public boolean inserirResidencia(Residencia residencia) {
        try {
            String sqlInsert = "INSERT INTO RESIDENCIA(NUMERO, DESCRICAO, IDFK_RUA) VALUES(?, ?, ?)";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlInsert);
            prepareStatement.setInt(1, residencia.getNumero());
            prepareStatement.setString(2, residencia.getDescricao());
            prepareStatement.setInt(3, residencia.getIdfkRua());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }
    }

    @Override
    public boolean inserirRua(Rua rua) {
        try {
            String sqlInsert = "INSERT INTO RESIDENCIA(NOME, IDFK_BAIRRO) VALUES(?, ?)";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlInsert);
            prepareStatement.setString(1, rua.getNome());
            prepareStatement.setInt(2, rua.getIdfkBairro());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }
    }

    @Override
    public boolean inserirDistribuidor(Distribuidor distribuidor) {
        try {
            String sqlInsert = "INSERT INTO DISTRIBUIDOR(NOME_FANTASIA, RAZAO_SOCIAL, EMAIL) VALUES(?, ?, ?)";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlInsert);
            prepareStatement.setString(1, distribuidor.getNomeFantasia());
            prepareStatement.setString(2, distribuidor.getRazaoSocial());
            prepareStatement.setString(3, distribuidor.getEmail());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }
    }

    @Override
    public boolean inserirItemVenda(ItemVenda itemVenda) {
        try {
            String sqlInsert = "INSERT INTO ITENS_VENDA(QUANTIDADE, SUB_TOTAL, IDFK_VENDA, IDFK_PRODUTO) VALUES(?, ?, ?, ?)";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlInsert);
            prepareStatement.setInt(1, itemVenda.getTotal());
            prepareStatement.setFloat(2, itemVenda.getSubTotal());
            prepareStatement.setInt(3, itemVenda.getIdfkVenda());
            prepareStatement.setInt(4, itemVenda.getIdfkProduto());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }
    }

    @Override
    public boolean inserirProduto(Produto produto) {
        try {
            String sqlInsert = "INSERT INTO PRODUTO(ESTOQUE, DATA_VALIDADE, DESCRICAO, PRECO_CUSTO, PRECO_VENDA, IDFK_DISTRIBUIDOR) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlInsert);
            prepareStatement.setInt(1, produto.getEstoque());
            prepareStatement.setDate(2, produto.getDataValidade());
            prepareStatement.setString(3, produto.getDescricao());
            prepareStatement.setFloat(4, produto.getPrecoCusto());
            prepareStatement.setFloat(5, produto.getPrecoVenda());
            prepareStatement.setInt(6, produto.getIdfkDistribuidor());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }
    }

    @Override
    public boolean inserirVenda(Venda venda) {
        try {
            String sqlInsert = "INSERT INTO VENDA(TOTAL, IDFK_CLIENTE) VALUES(?, ?)";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlInsert);
            prepareStatement.setFloat(1, venda.getTotal());
            prepareStatement.setInt(2, venda.getIdfkCliente());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }
    }
    
}

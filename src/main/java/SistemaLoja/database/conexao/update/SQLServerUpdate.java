/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao.update;

import SistemaLoja.database.conexao.IBancoDao;
import SistemaLoja.model.contato.Telefone;
import SistemaLoja.model.contato.TelefoneCliente;
import SistemaLoja.model.contato.TelefoneDistribuidor;
import SistemaLoja.model.endereco.Residencia;
import SistemaLoja.model.endereco.Rua;
import SistemaLoja.model.pessoa_fisica.Cliente;
import SistemaLoja.model.produtos.Distribuidor;
import SistemaLoja.model.produtos.Produto;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author pedroh
 */
public class SQLServerUpdate implements AtualizarDados {
    private IBancoDao database;

    public SQLServerUpdate(IBancoDao database) {
        this.database = database;
    }
    
        @Override
    public boolean atualizarCliente(Cliente cliente) {
        try {
            String sqlUpdate = "UPDATE CLIENTE SET IDFK_RESIDENCIA=?, DATA_NASC=?, EMAIL=?, NOME=? WHERE ID_CLIENTE=?";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlUpdate);
            prepareStatement.setInt(1, cliente.getIdfkResidencia());
            prepareStatement.setDate(2, cliente.getDataNascimento());
            prepareStatement.setString(3, cliente.getEmail());
            prepareStatement.setString(4, cliente.getNome());
            prepareStatement.setInt(5, cliente.getIdCliente());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }        
    }

    @Override
    public boolean atualizarTelefoneCliente(TelefoneCliente telefone) {
        try {
            String sqlUpdate = "UPDATE TELEFONE_CLIENTE SET TELEFONE=? WHERE ID_TELEFONE=?";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlUpdate);
            prepareStatement.setString(1, telefone.getTelefone());
            prepareStatement.setInt(2, telefone.getIdTelefone());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }        
    }

    @Override
    public boolean atualizarTelefoneDistribuidor(TelefoneDistribuidor telefone) {
        try {
            String sqlUpdate = "UPDATE TELEFONE_DISTRIBUIDOR SET TELEFONE=? WHERE ID_TELEFONE=?";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlUpdate);
            prepareStatement.setString(1, telefone.getTelefone());
            prepareStatement.setInt(2, telefone.getIdTelefone());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }        
    }
    
    @Override
    public boolean atualizarResidencia(Residencia residencia) {
        try {
            String sqlUpdate = "UPDATE RESIDENCIA SET NUMERO=?, DESCRICAO=?, IDFK_RUA=? WHERE ID_RESIDENCIA=?";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlUpdate);
            prepareStatement.setInt(1, residencia.getNumero());
            prepareStatement.setString(2, residencia.getDescricao());
            prepareStatement.setInt(3, residencia.getIdfkRua());
            prepareStatement.setInt(4, residencia.getIdResidencia());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }        
    }

    @Override
    public boolean atualizarRua(Rua rua) {
        try {
            String sqlUpdate = "UPDATE RUA SET NOME=?, IDFK_BAIRRO=? WHERE ID_RUA=?";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlUpdate);
            prepareStatement.setString(1, rua.getNome());
            prepareStatement.setInt(2, rua.getIdfkBairro());
            prepareStatement.setInt(3, rua.getIdRua());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }        
    }

    @Override
    public boolean atualizarDistribuidor(Distribuidor distribuidor) {
        try {
            String sqlUpdate = "UPDATE DISTRIBUIDOR SET NOME_FANTASIA=?, RAZAO_SOCIAL=?, EMAIL=? WHERE ID_DISTRIBUIDOR=?";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlUpdate);
            prepareStatement.setString(1, distribuidor.getNomeFantasia());
            prepareStatement.setString(2, distribuidor.getRazaoSocial());
            prepareStatement.setString(3, distribuidor.getEmail());
            prepareStatement.setInt(4, distribuidor.getIdDistribuidor());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }        
    }

    @Override
    public boolean atualizarProduto(Produto produto) {
        try {
            String sqlUpdate = "UPDATE PRODUTO SET ESTOQUE=?, DATA_VALIDADE=?, DESCRICAO=?, PRECO_CUSTO=?, PRECO_VENDA=?, IDFK_DISTRIBUIDOR=? WHERE ID_PRODUTO=?";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlUpdate);
            prepareStatement.setInt(1, produto.getEstoque());
            prepareStatement.setDate(2, produto.getDataValidade());
            prepareStatement.setString(3, produto.getDescricao());
            prepareStatement.setFloat(4, produto.getPrecoCusto());
            prepareStatement.setFloat(5, produto.getPrecoVenda());
            prepareStatement.setInt(6, produto.getIdfkDistribuidor());
            prepareStatement.setInt(7, produto.getIdProduto());
            
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }        
    }
      
}

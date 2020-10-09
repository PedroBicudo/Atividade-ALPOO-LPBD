/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao.delete;

import SistemaLoja.database.conexao.IBancoDao;
import SistemaLoja.model.pessoa_fisica.Cliente;
import SistemaLoja.model.produtos.Distribuidor;
import SistemaLoja.model.produtos.Produto;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author pedroh
 */
public class SQLServerDelete implements RemoverDados {
    private IBancoDao database;

    public SQLServerDelete(IBancoDao database) {
        this.database = database;
    }

    @Override
    public boolean removerDistribuidor(Distribuidor distribuidor) {
        try {
            PreparedStatement removerDistribuidor = database.getConnection().prepareStatement("DELETE FROM DISTRIBUIDOR WHERE ID_DISTRIBUIDOR=?");
            removerDistribuidor.setInt(1, distribuidor.getIdDistribuidor());
            removerDistribuidor.executeUpdate();
        
            return true;
        
        } catch (SQLException exception){
            return false;
        }
    }

    @Override
    public boolean removerCliente(Cliente cliente) {
        try {
            PreparedStatement removerCliente = database.getConnection().prepareStatement("DELETE FROM CLIENTE WHERE ID_CLIENTE=?");
            removerCliente.setInt(1, cliente.getIdCliente());
            removerCliente.executeUpdate();
        
            return true;
        
        } catch (SQLException exception){
            return false;
        }
    }

    @Override
    public boolean removerProduto(Produto produto) {
        try {
            PreparedStatement removerProduto = database.getConnection().prepareStatement("DELETE FROM PRODUTO WHERE ID_PRODUTO=?");
            removerProduto.setInt(1, produto.getIdProduto());
            removerProduto.executeUpdate();
        
            return true;
        
        } catch (SQLException exception){
            return false;
        }
    }
    
    
}

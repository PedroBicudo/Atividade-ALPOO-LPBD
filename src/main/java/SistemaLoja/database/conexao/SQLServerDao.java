/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao;

import SistemaLoja.database.conexao.delete.RemoverDados;
import SistemaLoja.database.conexao.delete.SQLServerDelete;
import SistemaLoja.database.conexao.insert.InserirDados;
import SistemaLoja.database.conexao.insert.SQLServerInsert;
import SistemaLoja.database.conexao.loja_actions.produtos.ProdutoActions;
import SistemaLoja.database.conexao.loja_actions.produtos.ProdutoManipulator;
import SistemaLoja.database.conexao.select.SQLServerSelect;
import SistemaLoja.database.conexao.select.SelecionarDados;
import SistemaLoja.database.conexao.update.AtualizarDados;
import SistemaLoja.database.conexao.update.SQLServerUpdate;
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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public class SQLServerDao implements IBancoDao {
    
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=LOJA";
    private static SQLServerDao databaseDao;
    
    private Connection databaseConnection;

    public Connection getDatabaseConnection() {
        return databaseConnection;
    }

    public void setDatabaseConnection(Connection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
    
    public synchronized static SQLServerDao getInstance() {
        if (databaseDao != null) {
            return databaseDao;
        } 
        
        try {
            Class.forName(DRIVER);
            databaseDao = new SQLServerDao();
            databaseDao.databaseConnection = DriverManager.getConnection(DATABASE_URL, "sa", "masterkey");
            return databaseDao;
        
        } catch (ClassNotFoundException|SQLException exception) {
            System.out.println(exception.getMessage());
            
            return null;
        }
    }

    @Override
    public RemoverDados getRemoverActions() {
        return new SQLServerDelete(databaseDao);
    }

    @Override
    public InserirDados getInserirActions() {
        return new SQLServerInsert(databaseDao);
    }

    @Override
    public SelecionarDados getSelecionarActions() {
        return new SQLServerSelect(databaseDao);
    }

    @Override
    public AtualizarDados getAtualizarActions() {
        return new SQLServerUpdate(databaseDao);
    }

    @Override
    public ProdutoActions getProdutoActions() {
        return new ProdutoManipulator(databaseDao);
    }

    @Override
    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void endConnection() {
        try {
            databaseConnection.close();
        } catch (SQLException exception) {
            System.out.println("Erro ao desconectar do banco");
            System.out.println(exception.getMessage());
        }
    }
    
    public static void main(String[] args) {
        SQLServerDao sql = SQLServerDao.getInstance();
    };
    
}

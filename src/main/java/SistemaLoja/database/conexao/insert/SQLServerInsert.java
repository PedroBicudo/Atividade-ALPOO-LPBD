/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao.insert;

import SistemaLoja.database.conexao.IBancoDao;
import SistemaLoja.database.conexao.SQLServerDao;
import SistemaLoja.model.contato.TelefoneCliente;
import SistemaLoja.model.contato.TelefoneDistribuidor;
import SistemaLoja.model.endereco.Bairro;
import SistemaLoja.model.endereco.Cidade;
import SistemaLoja.model.endereco.Endereco;
import SistemaLoja.model.endereco.Estado;
import SistemaLoja.model.endereco.Residencia;
import SistemaLoja.model.endereco.Rua;
import SistemaLoja.model.pessoa_fisica.Cliente;
import SistemaLoja.model.produtos.Distribuidor;
import SistemaLoja.model.produtos.ItemVenda;
import SistemaLoja.model.produtos.Produto;
import SistemaLoja.model.produtos.Venda;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public class SQLServerInsert implements InserirDados {
    
    private IBancoDao database;

    public SQLServerInsert(IBancoDao database) {
        this.database = database;
    }
    
    private void adicionarEnderecoAoStatement(PreparedStatement statement, Endereco endereco) throws SQLException {
            statement.setString(1, endereco.getEstado().getNome());
            statement.setString(2, endereco.getEstado().getSigla());
            statement.setString(3, endereco.getCidade().getNome());
            statement.setString(4, endereco.getBairro().getNome());
            statement.setString(5, endereco.getRua().getNome());
            statement.setInt(6, endereco.getResidencia().getNumero());
            statement.setString(7, endereco.getResidencia().getDescricao());
    }
    
    private void adicionarClienteAoStament(PreparedStatement statement, Cliente cliente) throws SQLException {
            statement.setString(8, cliente.getNome());
            statement.setString(9, cliente.getEmail());
            statement.setDate(10, cliente.getDataNascimento());    
    }
    
    @Override
    public boolean inserirCliente(Cliente cliente) {
        try {
            String sqlInsert = "INSERT INTO ESTADO(NOME, SIGLA) VALUES(?, ?); INSERT INTO CIDADE(IDFK_ESTADO, NOME) VALUES((SELECT SCOPE_IDENTITY()), ?); INSERT INTO BAIRRO(IDFK_CIDADE, NOME) VALUES((SELECT SCOPE_IDENTITY()), ?);INSERT INTO RUA(IDFK_BAIRRO, NOME) VALUES((SELECT SCOPE_IDENTITY()), ?);INSERT INTO RESIDENCIA(IDFK_RUA, NUMERO, DESCRICAO) VALUES((SELECT SCOPE_IDENTITY()), ?, ?);INSERT INTO CLIENTE(IDFK_RESIDENCIA, NOME, EMAIL, DATA_NASC) VALUES((SELECT SCOPE_IDENTITY()), ?, ?, ?);SELECT SCOPE_IDENTITY() AS ID_CLIENTE_CRIADO;";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlInsert);
            adicionarEnderecoAoStatement(prepareStatement, cliente.getEndereco());
            adicionarClienteAoStament(prepareStatement, cliente);
            ResultSet idClienteCriado = prepareStatement.executeQuery();
            idClienteCriado.next();            
            boolean isTelefonesInseridos = inserirTelefonesCliente(idClienteCriado.getInt("ID_CLIENTE_CRIADO"), cliente.getTelefones());

            return isTelefonesInseridos;
            
        } catch (SQLException|NullPointerException exception) {
            
            return false;
        }
    }


    @Override
    public boolean inserirDistribuidor(Distribuidor distribuidor) {
        try {
            String sqlInsert = "INSERT INTO DISTRIBUIDOR(NOME_FANTASIA, RAZAO_SOCIAL, EMAIL) VALUES(?, ?, ?);SELECT SCOPE_IDENTITY() AS ID_DISTRIBUIDOR_CRIADO";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlInsert);
            prepareStatement.setString(1, distribuidor.getNomeFantasia());
            prepareStatement.setString(2, distribuidor.getRazaoSocial());
            prepareStatement.setString(3, distribuidor.getEmail());
            int idDistribuidorCriado = prepareStatement.executeQuery().getInt("ID_DISTRIBUIDOR_CRIADO");
            boolean isTelefonesInseridos = inserirTelefonesDistribuidor(idDistribuidorCriado, distribuidor.getTelefones());
            
            return isTelefonesInseridos;
        
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
    public int inserirVenda(Venda venda) {
        try {
            String sqlInsert = "INSERT INTO VENDA(TOTAL, IDFK_CLIENTE) VALUES(?, ?); SELECT SCOPE_IDENTITY() AS ID_VENDA_CRIADA";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlInsert);
            prepareStatement.setFloat(1, venda.getTotal());
            prepareStatement.setInt(2, venda.getIdfkCliente());
            int idVendaCriada = prepareStatement.executeQuery().getInt("ID_VENDA_CRIADA");
            
            return idVendaCriada;
        
        } catch (SQLException exception) {
            
            return -1;
        }
    }

    @Override
    public boolean inserirTelefonesCliente(int idCliente, ArrayList<TelefoneCliente> telefones) {
        try {
            String sqlInsert = "INSERT INTO TELEFONE_CLIENTE(IDFK_CLIENTE, TELEFONE) VALUES(?, ?)";
            for (TelefoneCliente telefoneAtual: telefones) {
                PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlInsert);
                prepareStatement.setInt(1, idCliente);
                prepareStatement.setString(2, telefoneAtual.getTelefone());
                prepareStatement.executeUpdate();
            }
            
            return true;
        
        } catch (SQLException exception) {
            
            return false;
        }
    }

    @Override
    public boolean inserirTelefonesDistribuidor(int idDistribuidor, ArrayList<TelefoneDistribuidor> telefones) {
        try {
            String sqlInsert = "INSERT INTO TELEFONE_DISTRIBUIDOR(IDFK_DISTRIBUIDOR, TELEFONE) VALUES(?, ?)";
            for (TelefoneDistribuidor telefoneAtual: telefones) {
                PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlInsert);
                prepareStatement.setInt(1, idDistribuidor);
                prepareStatement.setString(2, telefoneAtual.getTelefone());
                prepareStatement.executeUpdate();
            }
            
            return true;
        
        } catch (SQLException exception) {
            
            return false;
        }
    }
    
    
    public static void main(String[] args) {
        Estado e = new Estado(0, "AA", "AAAAAA");
        Cidade c= new Cidade(0, 0, "AAAAAAA");
        Bairro b = new Bairro(0, 0, "POPOPOP");
        Rua r = new Rua(0, 0, "POPOAPSDOAPDOPASODAP");
        Residencia rd = new Residencia(0, 0, 123, "nada");
        Endereco ed = new Endereco(rd, r, b, c, e);
        ArrayList<TelefoneCliente> telefones = new ArrayList<TelefoneCliente>();
        telefones.add(new TelefoneCliente(0, 0, "123-123-123"));
        telefones.add(new TelefoneCliente(0, 0, "222-333-444"));
        telefones.add(new TelefoneCliente(0, 0, "123-123-555"));
        telefones.add(new TelefoneCliente(0, 0, "123-123-666"));
        
        
        Cliente cl = new Cliente(0, "POKOIO", new Date(2012, 12, 12), "teste@gmail.com", ed, telefones);
        
        System.out.println(SQLServerDao.getInstance().getInserirActions().inserirCliente(cl));
    }
    
}

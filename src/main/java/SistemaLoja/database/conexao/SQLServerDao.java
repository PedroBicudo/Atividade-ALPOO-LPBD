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
    public boolean inserirCliente(Cliente cliente) {
        try {
            String sqlInsert = "INSERT INTO CLIENTE(IDFK_RESIDENCIA, IDFK_TELEFONE, DATA_NASC, EMAIL, NOME) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlInsert);
            prepareStatement.setInt(1, cliente.getIdfkResidencia());
            prepareStatement.setInt(2, cliente.getIdfkTelefone());
            prepareStatement.setDate(1, cliente.getDataNascimento());
            prepareStatement.setString(1, cliente.getEmail());
            prepareStatement.setString(1, cliente.getNome());
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
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlInsert);
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
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlInsert);
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
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlInsert);
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
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlInsert);
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
            String sqlInsert = "INSERT INTO DISTRIBUIDOR(NOME_FANTASIA, RAZAO_SOCIAL, EMAIL, IDFK_TELEFONE) VALUES(?, ?, ?, ?)";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlInsert);
            prepareStatement.setString(1, distribuidor.getNomeFantasia());
            prepareStatement.setString(2, distribuidor.getRazaoSocial());
            prepareStatement.setString(3, distribuidor.getEmail());
            prepareStatement.setInt(4, distribuidor.getIdfkTelefone());
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
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlInsert);
            prepareStatement.setInt(1, itemVenda.getTotal());
            prepareStatement.setInt(2, itemVenda.getSubTotal());
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
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlInsert);
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
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlInsert);
            prepareStatement.setFloat(1, venda.getTotal());
            prepareStatement.setInt(2, venda.getIdfkCliente());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }
    }

    @Override
    public boolean atualizarCliente(Cliente cliente) {
        try {
            String sqlUpdate = "UPDATE CLIENTE SET IDFK_RESIDENCIA=?, IDFK_TELEFONE=?, DATA_NASC=?, EMAIL=?, NOME=? WHERE ID_CLIENTE=?";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlUpdate);
            prepareStatement.setInt(1, cliente.getIdfkResidencia());
            prepareStatement.setInt(2, cliente.getIdfkTelefone());
            prepareStatement.setDate(3, cliente.getDataNascimento());
            prepareStatement.setString(4, cliente.getEmail());
            prepareStatement.setString(5, cliente.getNome());
            prepareStatement.setInt(6, cliente.getIdCliente());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }        
    }

    @Override
    public boolean atualizarTelefone(Telefone telefone) {
        try {
            String sqlUpdate = "UPDATE TELEFONE SET TELEFONE=? WHERE ID_TELEFONE=?";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlUpdate);
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
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlUpdate);
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
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlUpdate);
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
            String sqlUpdate = "UPDATE DISTRIBUIDOR SET NOME_FANTASIA=?, RAZAO_SOCIAL=?, EMAIL=?, IDFK_TELEFONE=? WHERE ID_DISTRIBUIDOR=?";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlUpdate);
            prepareStatement.setString(1, distribuidor.getNomeFantasia());
            prepareStatement.setString(2, distribuidor.getRazaoSocial());
            prepareStatement.setString(3, distribuidor.getEmail());
            prepareStatement.setInt(4, distribuidor.getIdfkTelefone());
            prepareStatement.setInt(5, distribuidor.getIdDistribuidor());
            prepareStatement.executeUpdate();
            
            return true;
        } catch (SQLException exception) {
            
            return false;
        }        
    }

    @Override
    public boolean atualizarProduto(Produto produto) {
        try {
            String sqlUpdate = "UPDATE PRODUTO SET ESTOQUE=?, DATA_VALIDADE=?, DESCRICAO=?, PRECO_CUSTO=?, PRECO_VENDA=?, IDFK_DISTRIBUIDOR WHERE ID_PRODUTO=?";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlUpdate);
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

    @Override
    public ArrayList<Estado> selecionarTodosOsEstados() {
        ArrayList<Estado> estadosEncontrados = new ArrayList<>();
        try {
            String sqlSelect = "SELECT ID_ESTADO, SIGLA, NOME FROM ESTADO";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlSelect);
            ResultSet estados = prepareStatement.executeQuery();
            while (estados.next()) {
                estadosEncontrados.add(
                        new Estado(estados.getInt("ID_ESTADO"), estados.getString("SIGLA"), estados.getString("NOME"))
                );
            }
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return estadosEncontrados;
    }

    @Override
    public ArrayList<Cidade> selecionarCidadesByEstado(int estadoId) {
        ArrayList<Cidade> cidadesEncontradosNoEstado = new ArrayList<>();
        try {
            String sqlSelect = "SELECT ID_CIDADE, IDFK_ESTADO, NOME FROM CIDADE WHERE IDFK_ESTADO=?";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlSelect);
            prepareStatement.setInt(1, estadoId);
            ResultSet cidades = prepareStatement.executeQuery();
            while (cidades.next()) {
                cidadesEncontradosNoEstado.add(
                        new Cidade(cidades.getInt("ID_CIDADE"), cidades.getInt("IDFK_ESTADO"), cidades.getString("NOME"))
                );
            }
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return cidadesEncontradosNoEstado;        
    }

    @Override
    public ArrayList<Bairro> selecionarBairrosByCidade(int cidadeId) {
        ArrayList<Bairro> bairrosEncontradosNaCidade = new ArrayList<>();
        try {
            String sqlSelect = "SELECT ID_BAIRRO, IDFK_CIDADE, NOME FROM BAIRRO WHERE IDFK_CIDADE=?";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlSelect);
            prepareStatement.setInt(1, cidadeId);
            ResultSet bairros = prepareStatement.executeQuery();
            while (bairros.next()) {
                bairrosEncontradosNaCidade.add(
                        new Bairro(bairros.getInt("ID_BAIRRO"), bairros.getInt("IDFK_CIDADE"), bairros.getString("NOME"))
                );
            }
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return bairrosEncontradosNaCidade;
    }

    @Override
    public ArrayList<Bairro> selecionarRuasByBairro(int bairroId) {
        ArrayList<Bairro> ruasEncontradasNoBairro = new ArrayList<>();
        try {
            String sqlSelect = "SELECT ID_RUA, IDFK_BAIRRO, NOME FROM RUA WHERE IDFK_BAIRRO=?";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlSelect);
            prepareStatement.setInt(1, bairroId);
            ResultSet ruas = prepareStatement.executeQuery();
            while (ruas.next()) {
                ruasEncontradasNoBairro.add(
                        new Bairro(ruas.getInt("ID_RUA"), ruas.getInt("IDFK_BAIRRO"), ruas.getString("NOME"))
                );
            }
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return ruasEncontradasNoBairro;
    }

    @Override
    public Residencia selecionarResidenciaById(int residenciaId) {
        Residencia residenciaEncontrada = null;
        try {
            String sqlSelect = "SELECT ID_RUA, IDFK_BAIRRO, NOME, DESCRICAO FROM RUA WHERE IDFK_BAIRRO=?";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlSelect);
            prepareStatement.setInt(1, residenciaId);
            ResultSet residencia = prepareStatement.executeQuery();
            
            while(residencia.next()) {
                residenciaEncontrada = new Residencia(residenciaId, residencia.getInt("IDFK_RUA"), residencia.getInt("NUMERO"), residencia.getString("DESCRICAO"));
            }            
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return residenciaEncontrada;
    }

    @Override
    public Produto selecionarProdutoById(int produtoId) {
        Produto produtoEncontrado = null;
        try {
            String sqlSelect = "SELECT ID_PRODUTO, IDFK_DISTRIBUIDOR, ESTOQUE, DATA_VALIDADE, DESCRICAO, PRECO_CUSTO, PRECO_VENDA FROM PRODUTO WHERE ID_PRODUTO=?";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlSelect);
            prepareStatement.setInt(1, produtoId);
            ResultSet produto = prepareStatement.executeQuery();
            
            while(produto.next()) {
                produtoEncontrado = new Produto(produtoId, produto.getInt("IDFK_DISTRIBUIDOR"), produto.getInt("ESTOQUE"), produto.getDate("NUMERO"), produto.getString("DESCRICAO"), produto.getFloat("PRECO_CUSTO"), produto.getFloat("PRECO_VENDA"));
            }            
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return produtoEncontrado;
    }
    
    @Override
    public boolean efetuarCompraDeProduto(Cliente cliente, Venda venda, Produto produto, int quantia) {
        return true;
    }

    @Override
    public ArrayList<Cliente> selecionarClientesSemAColunaEmail() {
        ArrayList<Cliente> clientesEncontrados = new ArrayList<>();
        try {
            String sqlSelect = "SELECT ID_CLIENTE, NOME, DATA_NASC, IDFK_TELEFONE, IDFK_RESIDENCIA FROM CLIENTE";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlSelect);
            ResultSet clientes = prepareStatement.executeQuery();
            while (clientes.next()) {
                clientesEncontrados.add(
                        new Cliente(clientes.getInt("ID_CLIENTE"), clientes.getInt("IDFK_TELEFONE"), clientes.getInt("IDFK_RESIDENCIA"), clientes.getString("NOME"), clientes.getDate("DATA_NASC"), null)
                );
            }
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return clientesEncontrados;
    }

    @Override
    public ArrayList<Produto> selecionarProdutosVencidos() {
        ArrayList<Produto> produtosVencidosEncontrados = new ArrayList<>();
        try {
            String sqlSelect = "SELECT ID_PRODUTO, ESTOQUE, DATA_VALIDADE, DESCRICAO, PRECO_CUSTO, PRECO_VENDA, IDFK_DISTRIBUIDOR FROM PRODUTO WHERE DATA_VALIDADE < CURRENT_TIMESTAMP AND ESTOQUE > 0";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlSelect);
            ResultSet produtosVencidos = prepareStatement.executeQuery();
            while (produtosVencidos.next()) {
                produtosVencidosEncontrados.add(
                        new Produto(produtosVencidos.getInt("ID_PRODUTO"), produtosVencidos.getInt("IDFK_DISTRIBUIDOR"), produtosVencidos.getInt("ESTOQUE"), produtosVencidos.getDate("DATA_VALIDADE"), produtosVencidos.getString("DESCRICAO"), produtosVencidos.getFloat("PRECO_CUSTO"), produtosVencidos.getFloat("PRECO_VENDA"))
                );
            }
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return produtosVencidosEncontrados;
    }

    @Override
    public void mostrarVendasPorClienteEm2020() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Venda> selecionarVendas() {
        ArrayList<Venda> vendasEncontradas = new ArrayList<>();
        try {
            String sqlSelect = "SELECT TOTAL, IDFK_CLIENTE FROM VENDA";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlSelect);
            ResultSet vendas = prepareStatement.executeQuery();
            while (vendas.next()) {
                vendasEncontradas.add(
                        new Venda(vendas.getInt("ID_VENDA"), vendas.getInt("IDFK_CLIENTE"), vendas.getDate("DATA_HORA_VENDA"), vendas.getFloat("TOTAL"))
                );
            }
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return vendasEncontradas;
    }

    @Override
    public float getValorEmDinheiroDoTotalDeVendas() {
        float valorTotalDeVendas = 0;
        try {
            String sqlSelect = "SELECT SUM(TOTAL) AS TOTAL_VENDAS FROM VENDA";
            PreparedStatement prepareStatement = databaseConnection.prepareStatement(sqlSelect);
            ResultSet vendas = prepareStatement.executeQuery();
            while (vendas.next()) {
                valorTotalDeVendas = vendas.getFloat("TOTAL_VENDAS");
            }
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return valorTotalDeVendas;
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
    
}

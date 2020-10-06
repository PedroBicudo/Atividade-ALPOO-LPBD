/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao.select;

import SistemaLoja.database.conexao.IBancoDao;
import SistemaLoja.database.conexao.SQLServerDao;
import SistemaLoja.model.contato.Telefone;
import SistemaLoja.model.contato.TelefoneCliente;
import SistemaLoja.model.endereco.Bairro;
import SistemaLoja.model.endereco.Cidade;
import SistemaLoja.model.endereco.Endereco;
import SistemaLoja.model.endereco.Estado;
import SistemaLoja.model.endereco.Residencia;
import SistemaLoja.model.endereco.Rua;
import SistemaLoja.model.pessoa_fisica.Cliente;
import SistemaLoja.model.produtos.ClienteEVenda;
import SistemaLoja.model.produtos.Produto;
import SistemaLoja.model.produtos.Venda;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public class SQLServerSelect implements SelecionarDados {
    private IBancoDao database;

    public SQLServerSelect(IBancoDao database) {
        this.database = database;
    }
    
    
    @Override
    public ArrayList<Estado> selecionarTodosOsEstados() {
        ArrayList<Estado> estadosEncontrados = new ArrayList<>();
        try {
            String sqlSelect = "SELECT ID_ESTADO, SIGLA, NOME FROM ESTADO";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
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
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
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
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
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
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
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
    public ArrayList<Cliente> selecionarClientes() {
        ArrayList<Cliente> clientesEncontrados = new ArrayList<>();
        try {
            String sqlSelect = "SELECT ID_CLIENTE, NOME, DATA_NASC, EMAIL, ID_RESIDENCIA, IDFK_RESIDENCIA, NUMERO_DA_CASA, DESCRICAO, RUA, BAIRRO, CIDADE, ESTADO_SIGLA, ESTADO_NOME FROM CLIENTE INNER JOIN ENDERECO ON CLIENTE.IDFK_RESIDENCIA = ENDERECO.ID_RESIDENCIA";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            ResultSet clientes = prepareStatement.executeQuery();
            while (clientes.next()) {
                Endereco enderecoCliente = new Endereco(
                        new Residencia(0, 0, clientes.getInt("NUMERO_DA_CASA"), clientes.getString("DESCRICAO")),
                        new Rua(0, 0, clientes.getString("RUA")),
                        new Bairro(0, 0, clientes.getString("BAIRRO")),
                        new Cidade(0, 0, clientes.getString("CIDADE")),
                        new Estado(0, clientes.getString("ESTADO"), clientes.getString("ESTADO_NOME"))
                );
                Telefone telefoneCliente = database.getSelecionarActions().selecionarTelefoneByClienteId(clientes.getInt("ID_CLIENTE"));
                
                clientesEncontrados.add(
                        new Cliente(
                                clientes.getInt("ID_CLIENTE"), 
                                clientes.getString("NOME"), 
                                clientes.getDate("DATA_NASC"), 
                                clientes.getString("EMAIL"),
                                enderecoCliente,
                                telefoneCliente
                    )
                );
            }
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return clientesEncontrados;        
    }
    
    
    
    
    @Override
    public Residencia selecionarResidenciaById(int residenciaId) {
        Residencia residenciaEncontrada = null;
        try {
            String sqlSelect = "SELECT ID_RUA, IDFK_BAIRRO, NOME, DESCRICAO FROM RUA WHERE IDFK_BAIRRO=?";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
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
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            prepareStatement.setInt(1, produtoId);
            ResultSet produto = prepareStatement.executeQuery();
            produto.next();
            produtoEncontrado = new Produto(produtoId, produto.getInt("IDFK_DISTRIBUIDOR"), produto.getInt("ESTOQUE"), produto.getDate("DATA_VALIDADE"), produto.getString("DESCRICAO"), produto.getFloat("PRECO_CUSTO"), produto.getFloat("PRECO_VENDA"));
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return produtoEncontrado;
    }
    
        @Override
    public ArrayList<Cliente> selecionarClientesSemEmail() {
        ArrayList<Cliente> clientesEncontrados = new ArrayList<>();
        try {
            String sqlSelect = "SELECT ID_CLIENTE, NOME, DATA_NASC, IDFK_RESIDENCIA FROM CLIENTE WHERE EMAIL IS NULL";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            ResultSet clientes = prepareStatement.executeQuery();
            while (clientes.next()) {
                Endereco enderecoCliente = new Endereco(
                        new Residencia(0, 0, clientes.getInt("NUMERO_DA_CASA"), clientes.getString("DESCRICAO")),
                        new Rua(0, 0, clientes.getString("RUA")),
                        new Bairro(0, 0, clientes.getString("BAIRRO")),
                        new Cidade(0, 0, clientes.getString("CIDADE")),
                        new Estado(0, clientes.getString("ESTADO"), clientes.getString("ESTADO_NOME"))
                );
                Telefone telefoneCliente = database.getSelecionarActions().selecionarTelefoneByClienteId(clientes.getInt("ID_CLIENTE"));
                
                clientesEncontrados.add(
                        new Cliente(
                                clientes.getInt("ID_CLIENTE"), 
                                clientes.getString("NOME"), 
                                clientes.getDate("DATA_NASC"), 
                                clientes.getString("EMAIL"),
                                enderecoCliente,
                                telefoneCliente
                    )
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
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
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
    public Cliente selecionarClienteById(int clienteId) {
        Cliente clienteEncontrado;
        try {
            String sqlSelect = "SELECT ID_CLIENTE, NOME, DATA_NASC, EMAIL, IDFK_RESIDENCIA FROM CLIENTE WHERE ID_CLIENTE=?";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            prepareStatement.setInt(1, clienteId);
            ResultSet clientes = prepareStatement.executeQuery();
            clientes.next();
            Endereco enderecoCliente = new Endereco(
                new Residencia(0, 0, clientes.getInt("NUMERO_DA_CASA"), clientes.getString("DESCRICAO")),
                new Rua(0, 0, clientes.getString("RUA")),
                new Bairro(0, 0, clientes.getString("BAIRRO")),
                new Cidade(0, 0, clientes.getString("CIDADE")),
                new Estado(0, clientes.getString("ESTADO"), clientes.getString("ESTADO_NOME"))
            );
            Telefone telefoneCliente = database.getSelecionarActions().selecionarTelefoneByClienteId(clientes.getInt("ID_CLIENTE"));
                
            clienteEncontrado = new Cliente(
                clientes.getInt("ID_CLIENTE"), 
                clientes.getString("NOME"), 
                clientes.getDate("DATA_NASC"), 
                clientes.getString("EMAIL"),
                enderecoCliente,
                telefoneCliente
            );
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            clienteEncontrado = null;
        }        
        
        return clienteEncontrado;
    }

    @Override
    public Venda selecionarUltimaCompraDoCliente(int clienteId) {
        Venda ultimaVendaFeitaParaOCliente;
        try {
            String sqlSelect = "SELECT ID_VENDA, DATA_HORA_VENDA, TOTAL, IDFK_CLIENTE FROM VENDA WHERE DATA_HORA_VENDA = (SELECT MAX(DATA_HORA_VENDA) FROM VENDA WHERE IDFK_CLIENTE=?) AND IDFK_CLIENTE=?";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            prepareStatement.setInt(1, clienteId);
            prepareStatement.setInt(2, clienteId);
            ResultSet ultimaVenda = prepareStatement.executeQuery();
            ultimaVenda.next();
            ultimaVendaFeitaParaOCliente = 
                    new Venda(
                            ultimaVenda.getInt("ID_VENDA"), 
                            ultimaVenda.getInt("IDFK_CLIENTE"), 
                            ultimaVenda.getDate("DATA_HORA_VENDA"), 
                            ultimaVenda.getFloat("TOTAL")
                    );
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            ultimaVendaFeitaParaOCliente = null;
        }        
        
        return ultimaVendaFeitaParaOCliente;
    }
    
    public int getTotalDeComprasDoClienteEm2020(Cliente cliente) {
        int totalDeVendasParaOClienteEm2020 = 0;
        try {
            String sqlSelect = "SELECT COUNT(IDFK_CLIENTE) AS TOTAL_COMPRAS FROM VENDA WHERE IDFK_CLIENTE = ? AND YEAR(DATA_HORA_VENDA) = '2020'";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            prepareStatement.setInt(1, cliente.getIdCliente());
            ResultSet vendas = prepareStatement.executeQuery();
            vendas.next();
            totalDeVendasParaOClienteEm2020 = vendas.getInt("TOTAL_COMPRAS");
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return totalDeVendasParaOClienteEm2020;        
    }
    
        @Override
    public ArrayList<ClienteEVenda> selecionarVendasPorClienteEm2020() {
        ArrayList<ClienteEVenda> vendasPorClienteEm2020 = new ArrayList<>();
        ArrayList<Cliente> clientesDoBanco = selecionarClientes();
        for (Cliente cliente: clientesDoBanco) {
            vendasPorClienteEm2020.add(new ClienteEVenda(cliente, getTotalDeComprasDoClienteEm2020(cliente)));
        }
        
        return vendasPorClienteEm2020;        
    }

    @Override
    public ArrayList<Venda> selecionarVendas() {
        ArrayList<Venda> vendasEncontradas = new ArrayList<>();
        try {
            String sqlSelect = "SELECT TOTAL, IDFK_CLIENTE FROM VENDA";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
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
    public ArrayList<Produto> selecionarProdutos() {
        ArrayList<Produto> produtosEncontrados = new ArrayList<>();
        try {
            String sqlSelect = "SELECT ID_PRODUTO, ESTOQUE, DATA_VALIDADE, DESCRICAO, PRECO_CUSTO, PRECO_VENDA, IDFK_DISTRIBUIDOR FROM PRODUTO WHERE DATA_VALIDADE > CURRENT_TIMESTAMP AND ESTOQUE > 0";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            ResultSet produtos = prepareStatement.executeQuery();
            while (produtos.next()) {
                produtosEncontrados.add(
                        new Produto(produtos.getInt("ID_PRODUTO"), produtos.getInt("IDFK_DISTRIBUIDOR"), produtos.getInt("ESTOQUE"), produtos.getDate("DATA_VALIDADE"), produtos.getString("DESCRICAO"), produtos.getFloat("PRECO_CUSTO"), produtos.getFloat("PRECO_VENDA"))
                );
            }
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return produtosEncontrados;        
    }

    @Override
    public TelefoneCliente selecionarTelefoneByClienteId(int clienteId) {
        TelefoneCliente telefoneDoCliente = null;
        try {
            String sqlSelect = "SELECT IDFK_CLIENTE, TELEFONE WHERE IDFK_CLIENTE = ?";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            prepareStatement.setInt(1, clienteId);
            ResultSet telefone = prepareStatement.executeQuery();
            telefone.next();
            telefoneDoCliente = new TelefoneCliente(clienteId, clienteId, telefone.getString("TELEFONE"));
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return telefoneDoCliente;        
    }
    
    
    public static void main(String[] args) {
        System.out.println(
                SQLServerDao.getInstance().getSelecionarActions().selecionarClientesSemEmail().size()
        );
    }
}

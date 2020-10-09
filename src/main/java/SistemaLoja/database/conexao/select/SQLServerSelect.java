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
import SistemaLoja.model.contato.TelefoneDistribuidor;
import SistemaLoja.model.endereco.Bairro;
import SistemaLoja.model.endereco.Cidade;
import SistemaLoja.model.endereco.Endereco;
import SistemaLoja.model.endereco.Estado;
import SistemaLoja.model.endereco.Residencia;
import SistemaLoja.model.endereco.Rua;
import SistemaLoja.model.pessoa_fisica.Cliente;
import SistemaLoja.model.produtos.ClienteEVenda;
import SistemaLoja.model.produtos.Distribuidor;
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
            String sqlSelect = "SELECT CL.ID_CLIENTE, CL.DATA_NASC, CL.EMAIL, CL.NOME, RD.ID_RESIDENCIA,  RD.NUMERO AS RESIDENCIA_NUMERO,  RD.DESCRICAO AS RESIDENCIA_DESCRICAO,  RUA.ID_RUA, RUA.NOME  AS RUA, BRR.ID_BAIRRO, BRR.NOME AS BAIRRO, CD.ID_CIDADE, CD.NOME AS CIDADE,  ES.ID_ESTADO, ES.SIGLA,  ES.NOME AS NOME_ESTADO  FROM CLIENTE AS CL INNER JOIN RESIDENCIA AS RD ON CL.IDFK_RESIDENCIA = RD.ID_RESIDENCIA INNER JOIN RUA  ON RUA.ID_RUA = RD.IDFK_RUA  INNER JOIN BAIRRO AS  BRR  ON RUA.IDFK_BAIRRO = BRR.ID_BAIRRO  INNER JOIN  CIDADE AS CD ON CD.ID_CIDADE = BRR.IDFK_CIDADE INNER JOIN ESTADO AS ES ON ES.ID_ESTADO = CD.IDFK_ESTADO";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            ResultSet clientes = prepareStatement.executeQuery();
            while (clientes.next()) {
                Endereco enderecoCliente = new Endereco(
                        new Residencia(clientes.getInt("ID_RESIDENCIA"), clientes.getInt("ID_RUA"), clientes.getInt("RESIDENCIA_NUMERO"), clientes.getString("RESIDENCIA_DESCRICAO")),
                        new Rua(clientes.getInt("ID_RUA"), clientes.getInt("ID_BAIRRO"), clientes.getString("RUA")),
                        new Bairro(clientes.getInt("ID_BAIRRO"), clientes.getInt("ID_CIDADE"), clientes.getString("BAIRRO")),
                        new Cidade(clientes.getInt("ID_CIDADE"), clientes.getInt("ID_ESTADO"), clientes.getString("CIDADE")),
                        new Estado(clientes.getInt("ID_ESTADO"), clientes.getString("SIGLA"), clientes.getString("NOME_ESTADO"))
                );
                ArrayList<TelefoneCliente> telefonesCliente = 
                        database.getSelecionarActions()
                                .selecionarTelefonesByClienteId(clientes.getInt("ID_CLIENTE"));
                
                clientesEncontrados.add(new Cliente(
                                clientes.getInt("ID_CLIENTE"), 
                                clientes.getString("NOME"), 
                                clientes.getDate("DATA_NASC"), 
                                clientes.getString("EMAIL"),
                                enderecoCliente,
                                telefonesCliente
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
            String sqlSelect = "SELECT 	CL.ID_CLIENTE, CL.DATA_NASC, CL.EMAIL, CL.NOME, RD.ID_RESIDENCIA,  RD.NUMERO AS RESIDENCIA_NUMERO,  RD.DESCRICAO AS RESIDENCIA_DESCRICAO,  RUA.ID_RUA, RUA.NOME  AS RUA, BRR.ID_BAIRRO, BRR.NOME AS BAIRRO, CD.ID_CIDADE, CD.NOME AS CIDADE,  ES.ID_ESTADO, ES.SIGLA,  ES.NOME AS NOME_ESTADO  FROM CLIENTE AS CL INNER JOIN RESIDENCIA AS RD ON CL.IDFK_RESIDENCIA = RD.ID_RESIDENCIA INNER JOIN RUA  ON RUA.ID_RUA = RD.IDFK_RUA  INNER JOIN BAIRRO AS  BRR  ON RUA.IDFK_BAIRRO = BRR.ID_BAIRRO  INNER JOIN  CIDADE AS CD ON CD.ID_CIDADE = BRR.IDFK_CIDADE INNER JOIN ESTADO AS ES ON ES.ID_ESTADO = CD.IDFK_ESTADO WHERE LEN(EMAIL) = 0";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            ResultSet clientes = prepareStatement.executeQuery();
            while (clientes.next()) {
                Endereco enderecoCliente = new Endereco(
                        new Residencia(clientes.getInt("ID_RESIDENCIA"), clientes.getInt("ID_RUA"), clientes.getInt("RESIDENCIA_NUMERO"), clientes.getString("RESIDENCIA_DESCRICAO")),
                        new Rua(clientes.getInt("ID_RUA"), clientes.getInt("ID_BAIRRO"), clientes.getString("RUA")),
                        new Bairro(clientes.getInt("ID_BAIRRO"), clientes.getInt("ID_CIDADE"), clientes.getString("BAIRRO")),
                        new Cidade(clientes.getInt("ID_CIDADE"), clientes.getInt("ID_ESTADO"), clientes.getString("CIDADE")),
                        new Estado(clientes.getInt("ID_ESTADO"), clientes.getString("SIGLA"), clientes.getString("NOME_ESTADO"))
                );
                ArrayList<TelefoneCliente> telefonesCliente = 
                        database.getSelecionarActions()
                                .selecionarTelefonesByClienteId(clientes.getInt("ID_CLIENTE"));
                
                clientesEncontrados.add(new Cliente(
                                clientes.getInt("ID_CLIENTE"), 
                                clientes.getString("NOME"), 
                                clientes.getDate("DATA_NASC"), 
                                clientes.getString("EMAIL"),
                                enderecoCliente,
                                telefonesCliente
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
            String sqlSelect = "SELECT 	CL.ID_CLIENTE, CL.DATA_NASC, CL.EMAIL, CL.NOME, RD.ID_RESIDENCIA,  RD.NUMERO AS RESIDENCIA_NUMERO,  RD.DESCRICAO AS RESIDENCIA_DESCRICAO,  RUA.ID_RUA, RUA.NOME  AS RUA, BRR.ID_BAIRRO, BRR.NOME AS BAIRRO, CD.ID_CIDADE, CD.NOME AS CIDADE,  ES.ID_ESTADO, ES.SIGLA,  ES.NOME AS NOME_ESTADO  FROM CLIENTE AS CL INNER JOIN RESIDENCIA AS RD ON CL.IDFK_RESIDENCIA = RD.ID_RESIDENCIA INNER JOIN RUA  ON RUA.ID_RUA = RD.IDFK_RUA  INNER JOIN BAIRRO AS  BRR  ON RUA.IDFK_BAIRRO = BRR.ID_BAIRRO  INNER JOIN  CIDADE AS CD ON CD.ID_CIDADE = BRR.IDFK_CIDADE INNER JOIN ESTADO AS ES ON ES.ID_ESTADO = CD.IDFK_ESTADO WHERE ID_CLIENTE = ?";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            prepareStatement.setInt(1, clienteId);
            ResultSet clientes = prepareStatement.executeQuery();
            clientes.next();
            Endereco enderecoCliente = new Endereco(
                    new Residencia(clientes.getInt("ID_RESIDENCIA"), clientes.getInt("ID_RUA"), clientes.getInt("RESIDENCIA_NUMERO"), clientes.getString("RESIDENCIA_DESCRICAO")),
                    new Rua(clientes.getInt("ID_RUA"), clientes.getInt("ID_BAIRRO"), clientes.getString("RUA")),
                    new Bairro(clientes.getInt("ID_BAIRRO"), clientes.getInt("ID_CIDADE"), clientes.getString("BAIRRO")),
                    new Cidade(clientes.getInt("ID_CIDADE"), clientes.getInt("ID_ESTADO"), clientes.getString("CIDADE")),
                    new Estado(clientes.getInt("ID_ESTADO"), clientes.getString("SIGLA"), clientes.getString("NOME_ESTADO"))
                );
            
            ArrayList<TelefoneCliente> telefonesCliente = 
                    database.getSelecionarActions()
                            .selecionarTelefonesByClienteId(clientes.getInt("ID_CLIENTE"));
                
            clienteEncontrado = new Cliente(
                clientes.getInt("ID_CLIENTE"), 
                clientes.getString("NOME"), 
                clientes.getDate("DATA_NASC"), 
                clientes.getString("EMAIL"),
                enderecoCliente,
                telefonesCliente
            );
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            clienteEncontrado = null;
        }        
        
        return clienteEncontrado;
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
            String sqlSelect = "SELECT ID_VENDA, TOTAL, DATA_HORA_VENDA, IDFK_CLIENTE FROM VENDA";
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
            String sqlSelect = "SELECT ID_PRODUTO, ESTOQUE, DATA_VALIDADE, DESCRICAO, PRECO_CUSTO, PRECO_VENDA, IDFK_DISTRIBUIDOR FROM PRODUTO";
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
    public ArrayList<Produto> selecionarProdutosNaoVencidosComEstoque() {
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
    public ArrayList<TelefoneCliente> selecionarTelefonesByClienteId(int clienteId) {
        ArrayList<TelefoneCliente> telefonesDoCliente = new ArrayList<>();
        try {
            String sqlSelect = "SELECT ID_TELEFONE, IDFK_CLIENTE, TELEFONE FROM TELEFONE_CLIENTE WHERE IDFK_CLIENTE = ?";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            prepareStatement.setInt(1, clienteId);
            ResultSet telefone = prepareStatement.executeQuery();
            while(telefone.next()){
                telefonesDoCliente.add(new TelefoneCliente(telefone.getInt("IDFK_CLIENTE"), telefone.getInt("ID_TELEFONE"), telefone.getString("TELEFONE")));
            }
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return telefonesDoCliente;        
    }

    @Override
    public ArrayList<TelefoneDistribuidor> selecionarTelefonesByDistribuidorId(int distribuidorId) {
        ArrayList<TelefoneDistribuidor> telefonesDoCliente = new ArrayList<>();
        try {
            String sqlSelect = "SELECT ID_TELEFONE, IDFK_DISTRIBUIDOR, TELEFONE FROM TELEFONE_DISTRIBUIDOR WHERE IDFK_DISTRIBUIDOR = ?";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            prepareStatement.setInt(1, distribuidorId);
            ResultSet telefone = prepareStatement.executeQuery();
            while(telefone.next()){
                telefonesDoCliente.add(new TelefoneDistribuidor(distribuidorId, telefone.getInt("ID_TELEFONE"), telefone.getString("TELEFONE")));
            }
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return telefonesDoCliente;        
    }
    
    @Override
    public float selecionarOValorTotalDeVendas() {
        float totalDeVendas = 0F;
        try {
            String sqlSelect = "SELECT SUM(TOTAL) AS TOTAL_DAS_VENDAS FROM VENDA";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            ResultSet total = prepareStatement.executeQuery();
            total.next();
            totalDeVendas = total.getFloat("TOTAL_DAS_VENDAS");
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return totalDeVendas;        
    }

    @Override
    public ArrayList<Distribuidor> selecionarDistribuidores() {
        ArrayList<Distribuidor> distribuidoresEncontrados = new ArrayList<>();
        try {
            String sqlSelect = "SELECT ID_DISTRIBUIDOR, NOME_FANTASIA, RAZAO_SOCIAL, EMAIL FROM DISTRIBUIDOR";
            PreparedStatement prepareStatement = database.getConnection().prepareStatement(sqlSelect);
            ResultSet distribuidores = prepareStatement.executeQuery();
            while(distribuidores.next()) {
                ArrayList<TelefoneDistribuidor> telefones = selecionarTelefonesByDistribuidorId(distribuidores.getInt("ID_DISTRIBUIDOR"));
                distribuidoresEncontrados.add(
                        new Distribuidor(
                                distribuidores.getInt("ID_DISTRIBUIDOR"),
                                distribuidores.getString("NOME_FANTASIA"), 
                                distribuidores.getString("RAZAO_SOCIAL"), 
                                distribuidores.getString("EMAIL"), 
                                telefones)
                        );
            }
            
            
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }        
        
        return distribuidoresEncontrados;
    }
    
    public static void main(String[] args) {
        System.out.println(
                SQLServerDao.getInstance().getSelecionarActions().selecionarDistribuidores().size()
        );
    }
    
}

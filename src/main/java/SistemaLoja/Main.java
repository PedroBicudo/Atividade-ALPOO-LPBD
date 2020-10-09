/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja;

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
import SistemaLoja.model.produtos.Produto;
import SistemaLoja.model.produtos.ProdutoComprado;
import SistemaLoja.model.produtos.Venda;
import SistemaLoja.utils.Conversor;
import SistemaLoja.view.principal.TelaPrincipal;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author pedroh
 */
public class Main {
    
    private IBancoDao database = SQLServerDao.getInstance();
    
    /**
     * @param args the command line arguments
     */
    private void cadastrarDistribuidor() {
        ArrayList<TelefoneDistribuidor> telefones = new ArrayList<>();
        telefones.add(new TelefoneDistribuidor(0, 0, "11111111"));
        telefones.add(new TelefoneDistribuidor(0, 0, "22222222"));
        
        database.getInserirActions().inserirDistribuidor(
                new Distribuidor(
                        0, 
                        "A",
                        "A", 
                        "a@gmail.com", 
                        telefones)
        );
    }
    
    private void cadastrarProdutos() {
        Distribuidor distribuidor = database.getSelecionarActions().selecionarDistribuidores().get(0);
        String[] nomes = {"a", "b", "c", "d", "e", "f" , "g", "h", "i", "j"};
        
        for (int pos=0; pos < 10; pos++) {
            Date validade = Conversor.StringParaData("12/12/2020");
            database.getInserirActions().inserirProduto(
                    new Produto(0, distribuidor.getIdDistribuidor(), 25, validade, nomes[pos], 1F, 2F)
            );
        }
        
        Date vencido = Conversor.StringParaData("12/12/2000");
        database.getInserirActions().inserirProduto(
                new Produto(0, distribuidor.getIdDistribuidor(), 10, vencido, "Produto vencido", 1F, 2F)
        );
    }
    
    private void cadastrarClientes() {
        ArrayList<TelefoneCliente> t1 = new ArrayList<>();
        t1.add(new TelefoneCliente(0, 0, "11111111"));
        t1.add(new TelefoneCliente(0, 0, "22222222"));
        
        ArrayList<TelefoneCliente> t2 = new ArrayList<>();
        t2.add(new TelefoneCliente(0, 0, "33333333"));
        t2.add(new TelefoneCliente(0, 0, "44444444"));
        
        ArrayList<TelefoneCliente> t3 = new ArrayList<>();
        t3.add(new TelefoneCliente(0, 0, "55555555"));
        t3.add(new TelefoneCliente(0, 0, "66666666"));        
        
        ArrayList<TelefoneCliente> t4 = new ArrayList<>();
        t4.add(new TelefoneCliente(0, 0, "77777777"));
        t4.add(new TelefoneCliente(0, 0, "88888888"));
        
        ArrayList<TelefoneCliente> t5 = new ArrayList<>();
        t5.add(new TelefoneCliente(0, 0, "99999999"));
        t5.add(new TelefoneCliente(0, 0, "12121212"));        
        
        Endereco ed1 = 
                new Endereco(
                        new Residencia(0, 0, 121, "Casa Azul"), 
                        new Rua(0, 0, "AA"), 
                        new Bairro(0, 0, "BB"), 
                        new Cidade(0, 0, "CC"), 
                        database.getSelecionarActions().selecionarTodosOsEstados().get(0)
                );
        
        Endereco ed2 = 
                new Endereco(
                        new Residencia(0, 0, 156, "Casa Amarela"), 
                        new Rua(0, 0, "DD"), 
                        new Bairro(0, 0, "EE"), 
                        new Cidade(0, 0, "FF"), 
                        database.getSelecionarActions().selecionarTodosOsEstados().get(1)
                );
        
        Endereco ed3 = 
                new Endereco(
                        new Residencia(0, 0, 97, "Casa Verde"), 
                        new Rua(0, 0, "GG"), 
                        new Bairro(0, 0, "HH"), 
                        new Cidade(0, 0, "II"), 
                        database.getSelecionarActions().selecionarTodosOsEstados().get(0)
                );        
        
        
        Endereco ed4 = 
                new Endereco(
                        new Residencia(0, 0, 1, ""), 
                        new Rua(0, 0, "JJ"), 
                        new Bairro(0, 0, "KK"), 
                        new Cidade(0, 0, "LL"), 
                        database.getSelecionarActions().selecionarTodosOsEstados().get(0)
                );
        
        Endereco ed5 = 
                new Endereco(
                        new Residencia(0, 0, 50, ""), 
                        new Rua(0, 0, "MM"), 
                        new Bairro(0, 0, "NN"), 
                        new Cidade(0, 0, "OO"), 
                        database.getSelecionarActions().selecionarTodosOsEstados().get(0)
                );
        
        Date nascimento1 = Conversor.StringParaData("05/12/1800");
        Date nascimento2 = Conversor.StringParaData("04/11/1987");
        Date nascimento3 = Conversor.StringParaData("03/10/1900");
        Date nascimento4 = Conversor.StringParaData("02/09/2000");
        Date nascimento5 = Conversor.StringParaData("01/08/1967");
        
        Cliente c1 = new Cliente(0, "Peter", nascimento1, "peter@gmail.com", ed1, t1);
        Cliente c2 = new Cliente(0, "Jeff", nascimento2, "jeff@gmail.com", ed2, t2);
        Cliente c3 = new Cliente(0, "July", nascimento3, "july@gmail.com", ed3, t3);
        Cliente c4 = new Cliente(0, "Richard", nascimento4, "", ed4, t4);
        Cliente c5 = new Cliente(0, "Bob", nascimento5, "", ed5, t5);
        
        database.getInserirActions().inserirCliente(c1);
        database.getInserirActions().inserirCliente(c2);
        database.getInserirActions().inserirCliente(c3);
        database.getInserirActions().inserirCliente(c4);
        database.getInserirActions().inserirCliente(c5);
                
    }
    
    private void popularVendas() {
        ArrayList<Cliente> clientes = database.getSelecionarActions().selecionarClientes();
        ArrayList<Produto> produtos = database.getSelecionarActions().selecionarProdutos();
        for (Cliente cliente: clientes) {
            ArrayList<ProdutoComprado> p1 = new ArrayList<>();
            ArrayList<ProdutoComprado> p2 = new ArrayList<>();
            
            Venda venda1 = new Venda(0, cliente.getIdCliente(), null, 0);
            Venda venda2 = new Venda(0, cliente.getIdCliente(), null, 0);
            
            for (int pos=0; pos < 3; pos++) {
                ProdutoComprado pc1 = new ProdutoComprado(produtos.get(pos), 2);
                p1.add(pc1);
                venda1.setTotal(venda1.getTotal()+pc1.getSubTotal());
            }
            
            for (int pos=3; pos < 6; pos++) {
                ProdutoComprado pc2 = new ProdutoComprado(produtos.get(pos), 2);
                p2.add(pc2);
                venda2.setTotal(venda2.getTotal()+pc2.getSubTotal());
            }
            database.getProdutoActions().efetuarCompraDeProdutos(venda1, p1);
            database.getProdutoActions().efetuarCompraDeProdutos(venda2, p2);
        }
    }
    
    public void popularDados() {
        cadastrarDistribuidor();
        cadastrarProdutos();
        cadastrarClientes();
        popularVendas();
    }
    
    public static void main(String[] args) {
        new Main().popularDados();
        new TelaPrincipal().setVisible(true);
    }
    
}

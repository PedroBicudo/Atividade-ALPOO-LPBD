/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.model.produtos;
import SistemaLoja.model.pessoa_fisica.Cliente;

/**
 *
 * @author pedroh
 */
public class ClienteEVenda {
    private Cliente cliente;
    private int totalVendas;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(int totalVendas) {
        this.totalVendas = totalVendas;
    }

    public ClienteEVenda(Cliente cliente, int totalVendas) {
        setCliente(cliente);
        setTotalVendas(totalVendas);
    }
    
}

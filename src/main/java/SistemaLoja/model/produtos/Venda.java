/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.model.produtos;

import java.sql.Date;

/**
 *
 * @author pedroh
 */
public class Venda {
    private int idVenda;
    private int idfkCliente;
    private Date dataHoraVenda;
    private float total;

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdfkCliente() {
        return idfkCliente;
    }

    public void setIdfkCliente(int idfkCliente) {
        this.idfkCliente = idfkCliente;
    }

    public Date getDataHoraVenda() {
        return dataHoraVenda;
    }

    public void setDataHoraVenda(Date dataHora) {
        this.dataHoraVenda = dataHora;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Venda(int idVenda, int idfkCliente, Date dataHora, float total) {
        this.setIdVenda(idVenda);
        this.setIdfkCliente(idfkCliente);
        this.setDataHoraVenda(dataHora);
        this.setTotal(total);
    }
    
}

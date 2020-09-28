/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.model.produtos;

/**
 *
 * @author pedroh
 */
public class ItemVenda {
    private int idItemVenda;
    private int idfkVenda;
    private int idfkProduto;
    private int total;
    private int subTotal;

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public int getIdfkVenda() {
        return idfkVenda;
    }

    public void setIdfkVenda(int idfkVenda) {
        this.idfkVenda = idfkVenda;
    }

    public int getIdfkProduto() {
        return idfkProduto;
    }

    public void setIdfkProduto(int idfkProduto) {
        this.idfkProduto = idfkProduto;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }

    public ItemVenda(int idItemVenda, int idfkVenda, int idfkProduto, int total, int subTotal) {
        this.setIdItemVenda(idItemVenda);
        this.setIdfkVenda(idfkVenda);
        this.setIdfkProduto(idfkProduto);
        this.setTotal(total);
        this.setSubTotal(subTotal);
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.model.contato;

/**
 *
 * @author pedroh
 */
public class TelefoneCliente extends Telefone {
    private int idfkCliente;

    public int getIdfkCliente() {
        return idfkCliente;
    }

    public void setIdfkCliente(int idfkCliente) {
        this.idfkCliente = idfkCliente;
    }
    
    public TelefoneCliente(int idfkCliente, int idTelefone, String telefone) {
        super(idTelefone, telefone);
        setIdfkCliente(idfkCliente);
    }

}   

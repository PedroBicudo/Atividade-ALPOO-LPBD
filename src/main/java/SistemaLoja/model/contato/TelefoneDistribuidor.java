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
public class TelefoneDistribuidor extends Telefone {
    private int idfkDistribuidor;

    public int getIdfkDistribuidor() {
        return idfkDistribuidor;
    }

    public void setIdfkDistribuidor(int idfkDistribuidor) {
        this.idfkDistribuidor = idfkDistribuidor;
    }

    public TelefoneDistribuidor(int idfkDistribuidor, int idTelefone, String telefone) {
        super(idTelefone, telefone);
        setIdfkDistribuidor(idfkDistribuidor);
    }
}

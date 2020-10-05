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
public class Telefone {
    private int idTelefone;
    private String telefone;
    

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Telefone(int idTelefone, String telefone) {
        setIdTelefone(idTelefone);
        setTelefone(telefone);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.database.conexao.delete;

import SistemaLoja.database.conexao.IBancoDao;

/**
 *
 * @author pedroh
 */
public class SQLServerDelete implements RemoverDados {
    private IBancoDao database;

    public SQLServerDelete(IBancoDao database) {
        this.database = database;
    }
    
}

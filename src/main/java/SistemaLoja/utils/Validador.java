/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.utils;

/**
 *
 * @author pedroh
 */
public class Validador {
    
    public static boolean isDataValida(String data) {
        return true;
    }
    
    public static boolean isIdValido(String id) {
        if (id == null) {
            return false;
        }
        
        try {
            Integer.parseInt(id);
            return true;
        
        } catch (NumberFormatException exception) {
            return false;
        }
        
    }
    
    public static boolean isQuantidadeValida(int quantidade, int totalEstoque) {
        return quantidade > 0 && quantidade <= totalEstoque ;
    }

}

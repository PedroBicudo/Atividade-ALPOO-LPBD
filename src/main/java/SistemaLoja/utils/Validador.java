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
        return Validador.isNumero(id);
    }
    
    public static boolean isNumero(String text) {
        try {
            Integer.parseInt(text);
            return true;
        
        } catch (NumberFormatException exception) {
            return false;
        }
    }
    
    public static boolean isTextoVazio(String text) {
        return text.trim().isEmpty();
    }
    
    public static boolean isTelefoneValido(String telefone) {
        return 
                telefone.trim().length() >= 8 && telefone.trim().length() <= 11 &&
                Validador.isNumero(telefone);
    }
    
}

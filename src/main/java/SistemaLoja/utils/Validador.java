/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.utils;

import java.sql.Date;
import java.time.LocalDateTime;

/**
 *
 * @author pedroh
 */
public class Validador {
    
    public static boolean isDataDeValidadeValida(Date data) {
        Date dataAtual = Date.valueOf(LocalDateTime.now().toLocalDate());
        return data.compareTo(dataAtual) > 0;  
    }
    
    public static boolean isDataDeNascimentoValida(Date data) {
        Date dataAtual = Date.valueOf(LocalDateTime.now().toLocalDate());
        return data.compareTo(dataAtual) < 0;
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
        boolean isTamanhoValido = telefone.trim().length() >= 8 && telefone.trim().length() <= 11;
        if (isTamanhoValido) {
            
            if (Integer.parseInt(telefone) < 0) {
                return false;
            }
            
            return true;            
        }
        
        return false;
    }
}

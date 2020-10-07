/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.utils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author pedroh
 */
public class Conversor {
    
    public static String dateToString(Date date) {
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        return dataFormatada.format(date);
    }
    
    public static Date StringParaData(String valor) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return new Date(format.parse(valor).getTime());
            
        } catch (ParseException exception) {
            
            return null;
        }

    }
}

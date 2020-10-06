/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.utils;

import javax.swing.JOptionPane;

/**
 *
 * @author pedroh
 */
public class Mensagem {
    
    public static void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mostrarSucesso(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.INFORMATION_MESSAGE);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.view.principal;

import SistemaLoja.view.cadastro.TelaDeOpcoesDeCadastro;
import SistemaLoja.view.compra.TelaDeCompraPanel;
import SistemaLoja.view.extras.TelaDeExtras;
import javax.swing.JFrame;

/**
 *
 * @author pedroh
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    private TelaDeCompraPanel telaDeCompra;
    private TelaDeOpcoesDeCadastro telaDeOpcoesDeCadastro;
    private TelaDeExtras telaDeExtras;

    /**
     * Creates new form TelaPrincipal
     */    
    
    public TelaPrincipal() {
        initComponents();
        telaDeCompra = new TelaDeCompraPanel();
        telaDeCompra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaDeExtras = new TelaDeExtras();
        telaDeExtras.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        telaDeOpcoesDeCadastro = new TelaDeOpcoesDeCadastro();
        telaDeOpcoesDeCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnComprarProduto = new javax.swing.JButton();
        btnPainelExtras = new javax.swing.JButton();
        btnPainelCadastro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnComprarProduto.setText("Abrir painel de compra");
        btnComprarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarProdutoActionPerformed(evt);
            }
        });

        btnPainelExtras.setText("Abrir painel de extras");
        btnPainelExtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPainelExtrasActionPerformed(evt);
            }
        });

        btnPainelCadastro.setText("Abrir painel de cadastro");
        btnPainelCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPainelCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnPainelCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(btnPainelExtras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnComprarProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(btnComprarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnPainelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnPainelExtras, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComprarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarProdutoActionPerformed
        if (!telaDeCompra.isVisible()) {
            telaDeCompra.setVisible(true);
        }
    }//GEN-LAST:event_btnComprarProdutoActionPerformed

    private void btnPainelExtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPainelExtrasActionPerformed
        if (!telaDeExtras.isVisible()) {
            telaDeExtras.setVisible(true);
        }
    }//GEN-LAST:event_btnPainelExtrasActionPerformed

    private void btnPainelCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPainelCadastroActionPerformed
        // TODO add your handling code here:
        if (!telaDeOpcoesDeCadastro.isVisible()) {
            telaDeOpcoesDeCadastro.setVisible(true);
        }
    }//GEN-LAST:event_btnPainelCadastroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprarProduto;
    private javax.swing.JButton btnPainelCadastro;
    private javax.swing.JButton btnPainelExtras;
    // End of variables declaration//GEN-END:variables
}

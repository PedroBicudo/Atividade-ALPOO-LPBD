/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.view.extras.total_de_compras;

import SistemaLoja.model.produtos.ClienteEVenda;

/**
 *
 * @author pedroh
 */
public class CardClienteECompras extends javax.swing.JPanel {
    
    private ClienteEVenda clienteDoContainer;

    public ClienteEVenda getClienteDoContainer() {
        return clienteDoContainer;
    }

    public void setClienteDoContainer(ClienteEVenda clienteDoContainer) {
        this.clienteDoContainer = clienteDoContainer;
    }    

    public CardClienteECompras(ClienteEVenda clienteDoContainer) {
        initComponents();
        setClienteDoContainer(clienteDoContainer);
        conectarLabelsComCliente();
    }
    
    public void conectarLabelsComCliente() {
        lbNome.setText(getClienteDoContainer().getCliente().getNome());
        lbEmail.setText(getClienteDoContainer().getCliente().getEmail());
        lbCodigo.setText(String.valueOf(getClienteDoContainer().getCliente().getIdCliente()));
        lbTotalCompras.setText(String.valueOf(getClienteDoContainer().getTotalVendas()));
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbNomeText = new javax.swing.JLabel();
        lbEmailText = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbCodigoText = new javax.swing.JLabel();
        lbCodigo = new javax.swing.JLabel();
        lbTotalComprasText = new javax.swing.JLabel();
        lbTotalCompras = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbNomeText.setText("Nome");

        lbEmailText.setText("Email");

        lbNome.setText("NOME");

        lbEmail.setText("EMAIL");

        lbCodigoText.setText("C�digo");

        lbCodigo.setText("CODIGO");

        lbTotalComprasText.setText("Total de compras");

        lbTotalCompras.setText("TOTAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbEmailText)
                            .addComponent(lbNomeText))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbNome)
                                .addContainerGap(386, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
                                .addComponent(lbCodigoText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbCodigo)
                                .addGap(30, 30, 30))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTotalComprasText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTotalCompras)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNomeText)
                    .addComponent(lbNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmailText)
                    .addComponent(lbEmail)
                    .addComponent(lbCodigoText)
                    .addComponent(lbCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTotalComprasText)
                    .addComponent(lbTotalCompras))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbCodigoText;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEmailText;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNomeText;
    private javax.swing.JLabel lbTotalCompras;
    private javax.swing.JLabel lbTotalComprasText;
    // End of variables declaration//GEN-END:variables
}

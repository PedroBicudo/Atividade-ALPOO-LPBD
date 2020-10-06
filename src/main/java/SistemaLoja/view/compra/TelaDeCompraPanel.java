/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.view.compra;

import SistemaLoja.view.compra.ProdutosCompradosAcoes;
import SistemaLoja.view.compra.ContainerCompraProduto;
import SistemaLoja.database.conexao.IBancoDao;
import SistemaLoja.database.conexao.SQLServerDao;
import SistemaLoja.model.pessoa_fisica.Cliente;
import SistemaLoja.model.produtos.Produto;
import SistemaLoja.model.produtos.ProdutoComprado;
import SistemaLoja.model.produtos.Venda;
import SistemaLoja.utils.Mensagem;
import SistemaLoja.utils.Validador;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author pedroh
 */
public class TelaDeCompraPanel extends javax.swing.JFrame implements ProdutosCompradosAcoes {
    
    private ArrayList<Produto> produtosDoBanco;
    private ProdutoComprado[] produtosCompradosPeloCliente;
    private float totalDaCompra;
    private Cliente clienteDaSessao;
    private IBancoDao database;
    
    
    /**
     * Creates new form TelaDeCompraPanel
     */
    public TelaDeCompraPanel() {
        initComponents();
        initComponentsExtras();
        database = SQLServerDao.getInstance();
        totalDaCompra = 0F;
        
    }
    
    public void initComponentsExtras() {
        paneProdutosContainer = new JPanel();
        scrollPaneProdutos.setViewportView(paneProdutosContainer);
        paneProdutosContainer.setLayout(new BoxLayout(paneProdutosContainer, BoxLayout.Y_AXIS));
        btnCarregarProdutos.setEnabled(false);
        btnFinalizarCompra.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneProdutos = new javax.swing.JScrollPane();
        btnFinalizarCompra = new javax.swing.JButton();
        lbCodCliente = new javax.swing.JLabel();
        txtFieldCodCliente = new javax.swing.JTextField();
        btnCarregarProdutos = new javax.swing.JButton();
        btnValidarCliente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFinalizarCompra.setText("Finalizar Compra");
        btnFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarCompraActionPerformed(evt);
            }
        });

        lbCodCliente.setText("C�digo do cliente");

        txtFieldCodCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldCodClienteActionPerformed(evt);
            }
        });

        btnCarregarProdutos.setText("Carregar Produtos");
        btnCarregarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCarregarProdutosActionPerformed(evt);
            }
        });

        btnValidarCliente.setText("Validar Cliente");
        btnValidarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValidarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCarregarProdutos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollPaneProdutos))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(lbCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFieldCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnValidarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 122, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodCliente)
                    .addComponent(txtFieldCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnValidarCliente)
                    .addComponent(jLabel2))
                .addGap(79, 79, 79)
                .addComponent(btnCarregarProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarCompraActionPerformed
        ArrayList<ProdutoComprado> produtosCompradosPeloCliente = obterProdutosComprados();
        if (produtosCompradosPeloCliente.size() > 0) {
            calcularTotalDaCompra(produtosCompradosPeloCliente);
            Venda compraDoCliente = new Venda(0, clienteDaSessao.getIdCliente(), null, totalDaCompra);
            database.getInserirActions().inserirVenda(compraDoCliente);
            Venda ultimaVendaParaOCliente = database.getSelecionarActions().selecionarUltimaCompraDoCliente(clienteDaSessao.getIdCliente());                    
            database.getProdutoActions().efetuarCompraDeProdutos(ultimaVendaParaOCliente, produtosCompradosPeloCliente);
            popularListaDeProdutos();
            totalDaCompra = 0F;
        } else {
            Mensagem.mostrarErro("Voc� deve ter no minimo um produto para finalizar a compra");
        }
    }//GEN-LAST:event_btnFinalizarCompraActionPerformed

    private void txtFieldCodClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldCodClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldCodClienteActionPerformed

    private void btnCarregarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCarregarProdutosActionPerformed
        if (clienteDaSessao != null) {
            popularListaDeProdutos();
            btnFinalizarCompra.setEnabled(true);
        
        } else {
            // Mostrar erro usuario
        }
        
    }//GEN-LAST:event_btnCarregarProdutosActionPerformed

    private void btnValidarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValidarClienteActionPerformed
        // TODO add your handling code here:
        String clienteId = txtFieldCodCliente.getText();
        if (Validador.isIdValido(clienteId)) {
            clienteDaSessao = database.getSelecionarActions().selecionarClienteById(Integer.parseInt(clienteId));
            if (clienteDaSessao == null) {
                Mensagem.mostrarErro("ID do cliente inv�lido");
                txtFieldCodCliente.setText("");
            } else {
                txtFieldCodCliente.setEnabled(false);
                txtFieldCodCliente.setForeground(Color.GREEN);
                btnCarregarProdutos.setEnabled(true);
            }
        }
    }//GEN-LAST:event_btnValidarClienteActionPerformed

    @Override
    public void atualizarProdutoComprado(int posicaoNaLista, ProdutoComprado produtoComprado) {
        produtosCompradosPeloCliente[posicaoNaLista] = produtoComprado;
    }
    
    private ArrayList<ProdutoComprado> obterProdutosComprados() {
        ArrayList<ProdutoComprado> produtoComprados = new ArrayList<>();
        for (ProdutoComprado produtoComprado: produtosCompradosPeloCliente) {
            if (produtoComprado != null) {
                if (produtoComprado.getSubTotal() > 0) {
                    produtoComprados.add(produtoComprado);
                }
            }
        }
        return produtoComprados;
    }
    
    private void calcularTotalDaCompra(ArrayList<ProdutoComprado> produtoComprados) {
        for (ProdutoComprado produtoComprado: produtoComprados) {
            totalDaCompra += produtoComprado.getSubTotal();
        }
    }

    
    public void popularListaDeProdutos() {
        paneProdutosContainer.removeAll();
        produtosDoBanco = database.getSelecionarActions().selecionarProdutos();
        produtosCompradosPeloCliente = new ProdutoComprado[produtosDoBanco.size()];

        for (int pos=0; pos < produtosDoBanco.size(); pos++) {
            paneProdutosContainer.add(
                    new ContainerCompraProduto(pos, this, produtosDoBanco.get(pos))
            );
        }
        paneProdutosContainer.updateUI();
    }
    
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
            java.util.logging.Logger.getLogger(TelaDeCompraPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeCompraPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeCompraPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeCompraPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDeCompraPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCarregarProdutos;
    private javax.swing.JButton btnFinalizarCompra;
    private javax.swing.JButton btnValidarCliente;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbCodCliente;
    private javax.swing.JScrollPane scrollPaneProdutos;
    private javax.swing.JTextField txtFieldCodCliente;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JPanel paneProdutosContainer;
}

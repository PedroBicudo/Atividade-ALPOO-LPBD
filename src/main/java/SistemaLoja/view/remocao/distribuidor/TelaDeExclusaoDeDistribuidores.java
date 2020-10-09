/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaLoja.view.remocao.distribuidor;

import SistemaLoja.view.remocao.ExclusaoDeItem;
import SistemaLoja.view.remocao.cliente.*;
import SistemaLoja.database.conexao.IBancoDao;
import SistemaLoja.database.conexao.SQLServerDao;
import SistemaLoja.model.pessoa_fisica.Cliente;
import SistemaLoja.model.produtos.Distribuidor;
import SistemaLoja.utils.Mensagem;
import SistemaLoja.view.remocao.CardItemComExclusao;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author pedroh
 */
public class TelaDeExclusaoDeDistribuidores extends javax.swing.JPanel implements ExclusaoDeItem {
    
    private IBancoDao database;
    private ArrayList<Distribuidor> distribuidoresDisponiveis;
    private ArrayList<CardItemComExclusao> distribuidoresCards;
    private JPanel cardsContainer; 

    /**
     * Creates new form TelaDeExclusaoDeClientes
     */
    public TelaDeExclusaoDeDistribuidores() {
        initComponents();
        database = SQLServerDao.getInstance();
        distribuidoresDisponiveis = database.getSelecionarActions().selecionarDistribuidores();
        cardsContainer = new JPanel();
        cardsContainer.setLayout(new BoxLayout(cardsContainer, BoxLayout.Y_AXIS));
        scrollPaneDistribuidores.setViewportView(cardsContainer);
    }
    
    private void popularDistribuidores() {
        cardsContainer.removeAll();
        if (distribuidoresDisponiveis.size() < 1) {
            Mensagem.mostrarErro("N�o existem distribuidores cadastrados no banco");
        }
        
        for (int pos=0; pos < distribuidoresDisponiveis.size(); pos++) {
            cardsContainer.add(new CardItemComExclusao(this, pos, distribuidoresDisponiveis.get(pos)));
        }
        cardsContainer.updateUI();
    }
    
    @Override
    public void excluirItemDePosicao(int pos) {
        Distribuidor distribuidorSelecionado = distribuidoresDisponiveis.get(pos);
        boolean isDistribuidorRemovido = database.getRemoverActions().removerDistribuidor(distribuidorSelecionado);
        if (isDistribuidorRemovido) {
            Mensagem.mostrarSucesso("Distribuidor removido");
        
        } else {
        
            Mensagem.mostrarErro("Falha ao remover o distribuidor");
        }
        distribuidoresDisponiveis = database.getSelecionarActions().selecionarDistribuidores();
        popularDistribuidores();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPaneDistribuidores = new javax.swing.JScrollPane();
        btnAtualizar = new javax.swing.JButton();

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPaneDistribuidores)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(449, Short.MAX_VALUE)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 62, Short.MAX_VALUE)
                .addComponent(btnAtualizar)
                .addGap(39, 39, 39)
                .addComponent(scrollPaneDistribuidores, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        distribuidoresDisponiveis = database.getSelecionarActions().selecionarDistribuidores();
        popularDistribuidores();
    }//GEN-LAST:event_btnAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JScrollPane scrollPaneDistribuidores;
    // End of variables declaration//GEN-END:variables

}

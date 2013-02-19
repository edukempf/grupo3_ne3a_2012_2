/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.BebidaDAO;
import Modelo.Bebida;
import java.util.Date;
import javax.swing.JOptionPane;


/**
 *
 * @author Eduardo
 */
public class JDialogAltBebidas extends javax.swing.JDialog {

    /**
     * Creates new form JDialogAltBebidas
     */
    public JDialogAltBebidas(java.awt.Frame parent, boolean modal,Bebida bebida) {
        super(parent, modal);
        initComponents();
        jTextFieldCodigo.setText(bebida.getId()+"");
        jTextFieldNome.setText(bebida.getNome()+"");
        jTextFieldQtde.setText(bebida.getQtde()+"");
        jTextFieldPreco.setText(bebida.getPreco()+"");
        jTextFieldValidade.setText(bebida.getDataValidade()+"");
         jComboBoxBebida.setSelectedItem(bebida.getTipo());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldQtde = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxBebida = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldValidade = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Código:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 56, -1, -1));

        jTextFieldCodigo.setEditable(false);
        getContentPane().add(jTextFieldCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 52, 140, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Alterar de Bebidas");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 12, -1, -1));

        jLabel7.setText("Nome:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 91, -1, 20));

        jTextFieldQtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQtdeActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldQtde, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 122, 240, 25));

        jLabel8.setText("Quantidade:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 126, -1, -1));
        getContentPane().add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 89, 240, 25));
        getContentPane().add(jTextFieldPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 159, 240, 25));

        jLabel9.setText("Preço:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 163, -1, -1));

        jLabel10.setText("Tipo:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 229, -1, -1));

        jComboBoxBebida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione uma Bebida", "Refrigerante", "Suco", "Alcoolica" }));
        getContentPane().add(jComboBoxBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 224, 240, -1));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/limpar.png"))); // NOI18N
        jButton8.setText("Limpar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        jButton5.setText("Salvar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar.jpg"))); // NOI18N
        jButton10.setText("Fechar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 263, -1, -1));

        jLabel1.setText("Validade:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 196, -1, -1));
        getContentPane().add(jTextFieldValidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 192, 240, 24));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldQtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQtdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQtdeActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jTextFieldNome.setText("");
        jTextFieldQtde.setText("");
        jTextFieldPreco.setText("");
        jTextFieldValidade.setText("");
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int opcao = JOptionPane.showConfirmDialog(this, "Bebiida já Existente! Deseja Substitui-la?", "Confirmação de atualização", JOptionPane.OK_OPTION | JOptionPane.CANCEL_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            Bebida bebida = new Bebida();
            bebida.setNome(jTextFieldNome.getText());
            bebida.setQtde(Integer.parseInt(jTextFieldQtde.getText()));
            bebida.setTipo(jComboBoxBebida.getSelectedItem().toString());
            bebida.setDataValidade(new Date(jTextFieldValidade.getText()));
            bebida.setPreco(Double.parseDouble(jTextFieldPreco.getText()));

            try {
                BebidaDAO.update(bebida);
                JOptionPane.showMessageDialog(null, "Bebida atualizada com sucesso");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
                System.out.println(ex.toString());
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogAltBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogAltBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogAltBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogAltBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogAltBebidas dialog = new JDialogAltBebidas(new javax.swing.JFrame(), true,null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox jComboBoxBebida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldQtde;
    private javax.swing.JTextField jTextFieldValidade;
    // End of variables declaration//GEN-END:variables
}

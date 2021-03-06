/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.MesaDAO;
import DAO.PedidoBebidaDAO;
import DAO.PedidoPratoDAO;
import DAO.TransactionManager;
import Modelo.Bebida;
import Modelo.Mesa;
import Modelo.PedidoBebida;
import Modelo.PedidoPrato;
import Modelo.Prato;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author a899755
 */
public class JDialogCalcularConta extends javax.swing.JDialog {

    /**
     * Creates new form JDialogCalcularConta
     */
    private MesaDAO daoMesa;
    private PedidoBebidaDAO daoPedidoBebida;
    private PedidoPratoDAO daoPedidoPrato;
    private DefaultComboBoxModel modelCombo;
    private List<PedidoPrato> listPedidosPratos;
    private List<PedidoBebida> listPedidosBebidas;
    private boolean contaCalculada;

    public void preencheComboBoxMesa() {
        daoMesa = new MesaDAO();
        List<Mesa> mesas = daoMesa.lista();
        List<String> mesasOcupadas = new ArrayList<String>();
        for (Mesa mesa : mesas) {
            if (mesa.isStatus()) {
                mesasOcupadas.add("Mesa - " + mesa.getId());
            }
        }
        modelCombo = new DefaultComboBoxModel(mesasOcupadas.toArray());
        jComboBoxMesa.setModel(modelCombo);
        jComboBoxMesa.updateUI();
    }

    public JDialogCalcularConta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencheComboBoxMesa();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jComboBoxMesa = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTotalBebidas = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldTotalPratos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldTotalGeral = new javax.swing.JTextField();
        jButtonConsultarPedidosBebidas = new javax.swing.JButton();
        jButtonConsultarPedidosPratos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButtonCalcularConta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jButtonPagarConta = new javax.swing.JButton();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxMesa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBoxMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 200, -1));

        jLabel1.setText("Mesa a fechar conta:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 39, -1, -1));

        jTextFieldTotalBebidas.setEditable(false);
        jTextFieldTotalBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTotalBebidasActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldTotalBebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 75, 190, -1));

        jLabel2.setText("Total em bebidas:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 77, -1, -1));

        jLabel3.setText("Total em pratos:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, -1, -1));

        jTextFieldTotalPratos.setEditable(false);
        getContentPane().add(jTextFieldTotalPratos, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 113, 190, -1));

        jLabel4.setText("Total geral:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 154, -1, -1));

        jTextFieldTotalGeral.setEditable(false);
        getContentPane().add(jTextFieldTotalGeral, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 151, 190, -1));

        jButtonConsultarPedidosBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/zoom.png"))); // NOI18N
        jButtonConsultarPedidosBebidas.setText("Consultar Pedidos de Bebidas");
        jButtonConsultarPedidosBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarPedidosBebidasActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConsultarPedidosBebidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 70, -1, -1));

        jButtonConsultarPedidosPratos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/zoom.png"))); // NOI18N
        jButtonConsultarPedidosPratos.setText("Consultar Pedidos de Pratos");
        jButtonConsultarPedidosPratos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarPedidosPratosActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonConsultarPedidosPratos, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 110, 190, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Calculo da Conta da Mesa");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jButtonCalcularConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/calcular.png"))); // NOI18N
        jButtonCalcularConta.setText("Calcular Conta");
        jButtonCalcularConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalcularContaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCalcularConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 200, -1));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar.jpg"))); // NOI18N
        jButton10.setText("Fechar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButtonPagarConta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/calcular.png"))); // NOI18N
        jButtonPagarConta.setText("Pagar");
        jButtonPagarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagarContaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(jButtonPagarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPagarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 550, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private double calculaValorBebida() {
        double totalBebidas = 0;
        daoPedidoBebida = new PedidoBebidaDAO();
        listPedidosBebidas = (ArrayList<PedidoBebida>) daoPedidoBebida.buscaPedidoAbertoPorMesa(Integer.parseInt(jComboBoxMesa.getSelectedItem().toString().substring(jComboBoxMesa.getSelectedItem().toString().lastIndexOf(" ") + 1, jComboBoxMesa.getSelectedItem().toString().length())));
        for (PedidoBebida pedidoBebida : listPedidosBebidas) {
            for (Bebida b : pedidoBebida.getBebidas()) {
                totalBebidas += b.getPreco();
            }
        }
        return totalBebidas;
    }

    private double calculaValorPratos() {
        daoPedidoPrato = new PedidoPratoDAO();
        listPedidosPratos = (ArrayList<PedidoPrato>) daoPedidoPrato.buscaPedidoAbertoPorMesa(Integer.parseInt(jComboBoxMesa.getSelectedItem().toString().substring(jComboBoxMesa.getSelectedItem().toString().lastIndexOf(" ") + 1, jComboBoxMesa.getSelectedItem().toString().length())));
        double totalPratos = 0;
        for (PedidoPrato pedidoPrato : listPedidosPratos) {
            for (Prato p : pedidoPrato.getPratos()) {
                totalPratos += p.getPreco();
            }
        }
        return totalPratos;
    }

    private void setValoresCalculados() {
        double totalGeral = calculaValorBebida() + calculaValorPratos();
        this.contaCalculada = true;
        jTextFieldTotalBebidas.setText(calculaValorBebida() + "");
        jTextFieldTotalGeral.setText(totalGeral + "");
        jTextFieldTotalPratos.setText(calculaValorPratos() + "");
    }

    private void limpaCampos() {
        jTextFieldTotalBebidas.setText("0,00");
        jTextFieldTotalGeral.setText("0,00");
        jTextFieldTotalPratos.setText("0,00");
    }

    private void fechaMesa() {
        int op2 = JOptionPane.showConfirmDialog(null, "Deseja fechar já fazer o fechamento da mesa?", null, JOptionPane.YES_NO_OPTION);
        if (op2 == JOptionPane.YES_OPTION) {
            new JDialogFecharMesa(null, true).setVisible(true);
            dispose();
        }
    }

    private void pagaPedido() {
        if (this.contaCalculada) {
            if (listPedidosBebidas.isEmpty() && listPedidosPratos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Mesa sem nenhum pedido!!");
                fechaMesa();
            } else {
                int op = JOptionPane.showConfirmDialog(null, "Você que deseja pagar a conta da mesa: " + jComboBoxMesa.getSelectedItem().toString());
                if (op == JOptionPane.YES_OPTION) {
                    TransactionManager.Transaction t = TransactionManager.beginTransaction();
                    try {
                        daoPedidoBebida = new PedidoBebidaDAO();
                        daoPedidoPrato = new PedidoPratoDAO();
                        for (PedidoBebida pb : listPedidosBebidas) {
                            pb.setPago(true);
                            daoPedidoBebida.persisteObjeto(pb,t);
                        }
                        for (PedidoPrato pp : listPedidosPratos) {
                            pp.setPago(true);
                            daoPedidoBebida.persisteObjeto(pp,t);
                        }
                        t.commit();
                        JOptionPane.showMessageDialog(null, "Pagamento realizado com sucesso!!");
                        limpaCampos();
                        fechaMesa();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        t.rollback();
                        JOptionPane.showMessageDialog(null, "Erro ao fazer o pagamento!!");
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Calcule o valor da conta primeiro!!");
        }
    }

    private void jTextFieldTotalBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTotalBebidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTotalBebidasActionPerformed

    private void jButtonConsultarPedidosBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarPedidosBebidasActionPerformed
        // TODO add your handling code here:
        new JDialogConPedidoBebida(null, true).setVisible(true);
    }//GEN-LAST:event_jButtonConsultarPedidosBebidasActionPerformed

    private void jButtonPagarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagarContaActionPerformed
        // TODO add your handling code here:
        pagaPedido();
    }//GEN-LAST:event_jButtonPagarContaActionPerformed

    private void jButtonCalcularContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalcularContaActionPerformed
        // TODO add your handling code here:
        setValoresCalculados();
    }//GEN-LAST:event_jButtonCalcularContaActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButtonConsultarPedidosPratosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarPedidosPratosActionPerformed
        // TODO add your handling code here:
        new JDialogConPedidoPrato(null, true).setVisible(true);
    }//GEN-LAST:event_jButtonConsultarPedidosPratosActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogCalcularConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogCalcularConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogCalcularConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogCalcularConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogCalcularConta dialog = new JDialogCalcularConta(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonCalcularConta;
    private javax.swing.JButton jButtonConsultarPedidosBebidas;
    private javax.swing.JButton jButtonConsultarPedidosPratos;
    private javax.swing.JButton jButtonPagarConta;
    private javax.swing.JComboBox jComboBoxMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldTotalBebidas;
    private javax.swing.JTextField jTextFieldTotalGeral;
    private javax.swing.JTextField jTextFieldTotalPratos;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.FuncionarioDAO;
import DAO.MesaDAO;
import DAO.PedidoBebidaDAO;
import DAO.PedidoPratoDAO;
import DAO.TransactionManager;
import Modelo.Bebida;
import Modelo.Funcionario;
import Modelo.Mesa;
import Modelo.PedidoBebida;
import Modelo.PedidoPrato;
import Modelo.Prato;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class JDialogViewPedidoBebida extends javax.swing.JDialog {

    /**
     * Creates new form JDialogViewPedidoBebida
     */
    private PedidoBebida pedido;
    private PedidoBebidaDAO dao;
    private DefaultTableModel modelPratos;
    private DefaultComboBoxModel modelCombo;
    private List<Bebida> listaPratos;
    private FuncionarioDAO daoFunc;
    private MesaDAO daoMesa;

    public JDialogViewPedidoBebida(java.awt.Frame parent, boolean modal, PedidoBebida pedido) {
        super(parent, modal);
        this.pedido = pedido;
        this.listaPratos = pedido.getBebidas();
        initComponents();
        criaTabelas();
        preenchetabelaPrato();
        preencheComboBoxMesa();
        preencheComboBoxFuncionario();
        jComboBoxGarcon.setSelectedItem(pedido.getIdFuncionario().getCodFuncionario() + " - " + pedido.getIdFuncionario().getNome());
        jComboBoxMesa.setSelectedItem("Mesa - " + pedido.getIdMesa().getId());
    }

    private void criaTabelas() {
        modelPratos = new DefaultTableModel(new String[]{"Nome", "Preço"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTablePratos.setModel(modelPratos);
    }

    private void preenchetabelaPrato() {
        modelPratos.setNumRows(0);
        try {
            List<Bebida> lista2 = this.listaPratos;
            for (Bebida p : lista2) {
                modelPratos.addRow(new Object[]{p.getNome(),
                    p.getPreco() + ""});

            }
            jTablePratos.updateUI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void preencheComboBoxFuncionario() {
        daoFunc = new FuncionarioDAO();
        List<Funcionario> funcionarios = daoFunc.lista();
        String[] nomeFunc = new String[funcionarios.size()];
        for (int i = 0; i < funcionarios.size(); i++) {
            nomeFunc[i] = funcionarios.get(i).getCodFuncionario() + " - " + funcionarios.get(i).getNome();
        }
        modelCombo = new DefaultComboBoxModel(nomeFunc);
        jComboBoxGarcon.setModel(modelCombo);
        jComboBoxGarcon.updateUI();
    }

    public void preencheComboBoxMesa() {
        daoMesa = new MesaDAO();
        List<Mesa> mesas = daoMesa.lista();
        String[] lista = new String[mesas.size()];
        for (int i = 0; i < mesas.size(); i++) {
            lista[i] = "Mesa - " + mesas.get(i).getId();
        }
        modelCombo = new DefaultComboBoxModel(lista);
        jComboBoxMesa.setModel(modelCombo);
        jComboBoxMesa.updateUI();
    }

    private void apagaPedido() {
        dao = new PedidoBebidaDAO();
        pedido.setBebidas(null);
        pedido.setIdFuncionario(null);
        pedido.setIdMesa(null);
        int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover esse Pedido?", "Confirmação de exclusão", JOptionPane.OK_OPTION | JOptionPane.CANCEL_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            try {
                dao.delete(pedido);
                JOptionPane.showMessageDialog(null, "Apagado com sucesso!");
                dispose();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro ao apagar!");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel19 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jButtonFechar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonRemover = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabelMesa = new javax.swing.JLabel();
        jComboBoxGarcon = new javax.swing.JComboBox();
        jLabelGarcon = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTablePratos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jComboBoxMesa = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel19.setText("Dados de Pedidos");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar.jpg"))); // NOI18N
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/edit.png"))); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/remover.png"))); // NOI18N
        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jButtonRemover)
                .addGap(34, 34, 34)
                .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMesa.setText("Número da Mesa:");
        jPanel3.add(jLabelMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        jComboBoxGarcon.setEnabled(false);
        jPanel3.add(jComboBoxGarcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 270, -1));

        jLabelGarcon.setText("Garçon:");
        jPanel3.add(jLabelGarcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jTablePratos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTablePratos.setEnabled(false);
        jScrollPane3.setViewportView(jTablePratos);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 340, 170));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pratos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 370, 220));

        jComboBoxMesa.setEnabled(false);
        jPanel3.add(jComboBoxMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 270, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel19)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel19)
                    .addGap(6, 6, 6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(30, 30, 30)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        dispose();
        JDialog dialog = new JDialogCadPedidoBebida(null, true, this.pedido);
        dialog.setLocation(getX() + 50, getY() + 50);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        apagaPedido();
    }//GEN-LAST:event_jButtonRemoverActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogViewPedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogViewPedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogViewPedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogViewPedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogViewPedidoBebida dialog = new JDialogViewPedidoBebida(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JComboBox jComboBoxGarcon;
    private javax.swing.JComboBox jComboBoxMesa;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabelGarcon;
    private javax.swing.JLabel jLabelMesa;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTablePratos;
    // End of variables declaration//GEN-END:variables
}

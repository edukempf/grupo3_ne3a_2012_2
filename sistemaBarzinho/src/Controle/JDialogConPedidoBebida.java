/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.PedidoBebidaDAO;
import DAO.PedidoPratoDAO;
import DAO.TransactionManager;
import Modelo.Bebida;
import Modelo.PedidoBebida;
import Modelo.PedidoPrato;
import Modelo.Prato;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class JDialogConPedidoBebida extends javax.swing.JDialog {

    /**
     * Creates new form JDialogConPedidoBebida
     */
    private List<PedidoBebida> lista;
    private DefaultTableModel model;
    private PedidoBebidaDAO dao = new PedidoBebidaDAO();

    public JDialogConPedidoBebida(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        criaTabela();
    }

    private void criaTabela() {
        model = new DefaultTableModel(new String[]{"Codigo", "Número Mesa", "Nome do Funcionário", "Total Pedido"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1.setModel(model);
        jTable1.updateUI();
    }

    private void preenchetabela() {
        model.setNumRows(0);
        try {

            if (!jTextFieldNome.getText().equals("")) {
                lista = (ArrayList<PedidoBebida>) dao.buscaPorMesa(Integer.parseInt(jTextFieldNome.getText()));

            } else {
                lista = (ArrayList<PedidoBebida>) dao.buscaTodosPedidos();
            }
            double custoPedido = 0;
            for (PedidoBebida pedido : lista) {
                for (Bebida p : pedido.getBebidas()) {
                    custoPedido += p.getPreco();
                }
                model.addRow(new Object[]{pedido.getId(),
                    pedido.getIdMesa().getId(),
                    pedido.getIdFuncionario().getNome(),
                    custoPedido});
                custoPedido = 0;
            }

            jTable1.updateUI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private PedidoBebida getPedidoSelecionado() {
        PedidoBebida pedido = new PedidoBebida();
        int linha = jTable1.getSelectedRow();
        int coluna = 0;
        String codigo = model.getValueAt(linha, coluna).toString();
        try {
            pedido = dao.get(Integer.parseInt(codigo));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pedido;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButtonRemover = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jButtonView = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Consultar Pedidos");

        jLabel8.setText("Numero da Mesa:");

        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/zoom.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Pedidos Encontrados pela Consulta");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo ", "Número da Mesa", "Funcionário", "Pratos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jButtonRemover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/remover.png"))); // NOI18N
        jButtonRemover.setText("Remover");
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar.jpg"))); // NOI18N
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jButtonView.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/consultar.jpg"))); // NOI18N
        jButtonView.setText("View");
        jButtonView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonViewActionPerformed(evt);
            }
        });

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/edit.png"))); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButtonRemover)
                .addGap(18, 18, 18)
                .addComponent(jButtonView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonView, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(182, 182, 182)
                            .addComponent(jLabel5))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(jLabel8)
                            .addGap(6, 6, 6)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(25, 25, 25)
                            .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(17, 17, 17)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(20, 20, 20)
                    .addComponent(jLabel2)
                    .addGap(13, 13, 13)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(30, 30, 30)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        // TODO add your handling code here:
        preenchetabela();
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            JDialog dialog = new JDialogCadPedidoBebida(null, true, getPedidoSelecionado());
            dialog.setLocation(getX() + 50, getY() + 50);
            dialog.setVisible(true);
        };
    }//GEN-LAST:event_jTable1MousePressed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed

        PedidoBebida pedido = getPedidoSelecionado();
        pedido.setBebidas(null);
        pedido.setIdFuncionario(null);
        pedido.setIdMesa(null);
        if (pedido != null) {
            int opcao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja remover esse Pedido?", "Confirmação de exclusão", JOptionPane.OK_OPTION | JOptionPane.CANCEL_OPTION);
            if (opcao == JOptionPane.YES_OPTION) {
                try {
                    TransactionManager.beginTransaction();
                    dao.delete(pedido);
                    TransactionManager.comitTransaction();
                    preenchetabela();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    TransactionManager.rollbackTransaction();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione uma Pedido!");
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonViewActionPerformed
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            JDialog dialog = new JDialogViewPedidoBebida(null, true, getPedidoSelecionado());
            dialog.setLocation(getX() + 50, getY() + 50);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor Selecione uma linha da Tabela para Visualizar!");
        }
    }//GEN-LAST:event_jButtonViewActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        int row = jTable1.getSelectedRow();
        if (row >= 0) {
            JDialog dialog = new JDialogCadPedidoBebida(null, true, getPedidoSelecionado());
            dialog.setLocation(getX() + 50, getY() + 50);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Por favor Selecione uma linha da Tabela para Editar!");
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogConPedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogConPedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogConPedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogConPedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogConPedidoBebida dialog = new JDialogConPedidoBebida(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JButton jButtonView;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
}

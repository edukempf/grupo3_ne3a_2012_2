/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.FuncionarioDAO;
import DAO.MesaDAO;
import Modelo.Bebida;
import Modelo.Funcionario;
import Modelo.Mesa;
import Modelo.PedidoBebida;
import Modelo.PedidoPrato;
import Modelo.Prato;
import Utils.Data;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eduardo
 */
public class JDialogCadPedidoBebida extends javax.swing.JDialog {

    /**
     * Creates new form JDialogCadPedidoBebida
     */
    private List<Bebida> listaBebida=new ArrayList<Bebida>();
    private DefaultComboBoxModel modelCombo;
    private DefaultTableModel modelBebida;
    private FuncionarioDAO daoFunc;
    private MesaDAO daoMesa;
    private PedidoBebida pedido;
    
    
    private void criaTabelas() {
        modelBebida = new DefaultTableModel(new String[]{"Nome", "Preço"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTableBebidas.setModel(modelBebida);
    }

    private void preenchetabelaPrato() {
        modelBebida.setNumRows(0);
        try {
            List<Bebida> lista = this.listaBebida;
            for (Bebida b : lista) {
                modelBebida.addRow(new Object[]{b.getNome(),
                            b.getPreco() + ""});

            }
            jTableBebidas.updateUI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    public JDialogCadPedidoBebida(java.awt.Frame parent, boolean modal, PedidoBebida pedido) {
        super(parent, modal);
        initComponents();
        this.pedido=pedido;
        criaTabelas();
        this.listaBebida = new ArrayList<Bebida>();
        preencheComboBoxFuncionario();
        preencheComboBoxMesa();
        if (pedido != null) {
            jComboBoxGarcon.setSelectedItem(pedido.getIdFuncionario().getCodFuncionario() + " - " + pedido.getIdFuncionario().getNome());
            jComboBoxMesa.setSelectedItem("Mesa - " + pedido.getIdMesa().getId());
            this.listaBebida=pedido.getBebidas();
            preenchetabelaPrato();

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
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
    
    
    private void getBebida() {

        new JDialogConBebidas(null, true).setVisible(true);
        Bebida b = (Bebida) Data.hash.remove("bebida");
        if (b == null) {
            return;
        }
        listaBebida.add(b);
        preenchetabelaPrato();

    }
    
    private void deleteBebida() {
        int linha = jTableBebidas.getSelectedRow();
        listaBebida.remove(linha);
        preenchetabelaPrato();
    }
    
    private void limpaFormularioTodo() {
        jComboBoxMesa.setSelectedIndex(0);
        jComboBoxGarcon.setSelectedIndex(0);
        listaBebida.removeAll(listaBebida);
        preenchetabelaPrato();
    }
    
    private PedidoBebida getDadosDosCampos() {
        PedidoBebida ped = new PedidoBebida();
        ped.setIdMesa(daoMesa.get(Integer.parseInt(jComboBoxMesa.getSelectedItem().toString().substring(jComboBoxMesa.getSelectedItem().toString().lastIndexOf(" ") + 1, jComboBoxMesa.getSelectedItem().toString().length()))));
        ped.setIdFuncionario(daoFunc.get(Integer.parseInt(jComboBoxGarcon.getSelectedItem().toString().substring(0, jComboBoxGarcon.getSelectedItem().toString().indexOf(" ")))));
        ped.setBebidas(this.listaBebida);
        if(this.pedido!=null){
            ped.setId(this.pedido.getId());
        }

        return ped;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelMesa = new javax.swing.JLabel();
        jComboBoxGarcon = new javax.swing.JComboBox();
        jLabelGarcon = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableBebidas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButtonAddPrato = new javax.swing.JButton();
        jButtonRemovePrato = new javax.swing.JButton();
        jComboBoxMesa = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonLimpar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Cadastro de Pedidos");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelMesa.setText("Número da Mesa:");
        jPanel3.add(jLabelMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        jPanel3.add(jComboBoxGarcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 270, -1));

        jLabelGarcon.setText("Garçon:");
        jPanel3.add(jLabelGarcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jTableBebidas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableBebidas);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 320, 110));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bebidas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonAddPrato.setText("add");
        jButtonAddPrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddPratoActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonAddPrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        jButtonRemovePrato.setText("remove");
        jButtonRemovePrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemovePratoActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonRemovePrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 370, 220));

        jComboBoxMesa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBoxMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 270, -1));

        jButton1.setText("Nova Mesa");
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/zoom.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jButtonLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/limpar.png"))); // NOI18N
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/salvar.png"))); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/fechar.jpg"))); // NOI18N
        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jLabel4))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addGap(8, 8, 8)
                    .addComponent(jButtonPesquisar)
                    .addGap(5, 5, 5)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddPratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddPratoActionPerformed
        // TODO add your handling code here:
        getBebida();
    }//GEN-LAST:event_jButtonAddPratoActionPerformed

    private void jButtonRemovePratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemovePratoActionPerformed
        // TODO add your handling code here:
        deleteBebida();
    }//GEN-LAST:event_jButtonRemovePratoActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        JDialog dialog = new JDialogConComidas(null, true);
        dialog.setLocation(getX() + 50, getY() + 50);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        this.limpaFormularioTodo();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        dispose();
        JDialog dialog = new JDialogViewPedidoBebida(null, true, this.getDadosDosCampos());
        dialog.setLocation(getX() + 50, getY() + 50);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogCadPedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogCadPedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogCadPedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogCadPedidoBebida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogCadPedidoBebida dialog = new JDialogCadPedidoBebida(new javax.swing.JFrame(), true,null);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAddPrato;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonRemovePrato;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboBoxGarcon;
    private javax.swing.JComboBox jComboBoxMesa;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelGarcon;
    private javax.swing.JLabel jLabelMesa;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableBebidas;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Comida;
import Modelo.Funcionario;
import Modelo.Prato;
import Utils.Data;
import Utils.Utilitarios;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juliana
 */
public class JDialogCadPratos extends javax.swing.JDialog {

    /**
     * Creates new form JDialogCadPratos
     */
    
    private DefaultTableModel model;
    private Prato prato;
    
    
    private List<Comida> listaComida;
    public JDialogCadPratos(java.awt.Frame parent, boolean modal, Prato prato) {
       super(parent, modal);
        initComponents();
        criaTabela();
        this.listaComida=new ArrayList<Comida>();
        this.prato=prato;
        if(prato!=null){
            jTextFieldNome.setText(prato.getNome());
            jTextFieldPreco.setText(prato.getPreco()+"");
            listaComida=prato.getIngredientes();
            preenchetabela();
            jTextFieldQtde.setText(prato.getQuantidadePorcoes()+"");
        }
    }
    
    private void criaTabela() {
        model = new DefaultTableModel(new String[]{"Nome","Validade"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTable1.setModel(model);
    }
    
    private void preenchetabela() {
        model.setNumRows(0);
        try {
            List<Comida> lista = this.listaComida ;
            for (Comida c : lista) {
                model.addRow(new Object[]{c.getNome(),
                    Utilitarios.dataISOtoBR(c.getDataValidade().toString())});

            }
            jTable1.updateUI();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    private void deleteIngrediente(){
        int linha = jTable1.getSelectedRow();
        listaComida.remove(linha);
        preenchetabela();
    }
    
    private void getIngrediente() {
        
        new JDialogConComidas(null, true).setVisible(true);
        Comida c = (Comida) Data.hash.remove("comida");
        if (c == null) {
            return;
        }
        listaComida.add(c);
        preenchetabela();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelPreco = new javax.swing.JLabel();
        jTextFieldQtde = new javax.swing.JTextField();
        jLabelQtde = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAddIngrediente = new javax.swing.JButton();
        jButtonExcluirIngrediente = new javax.swing.JButton();
        jButtonPesquisar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonLimpar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Cadastro de Pratos");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 11, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        jPanel3.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 361, 25));

        jLabelNome.setText("Nome:");
        jPanel3.add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        jLabelPreco.setText("Preço:");
        jPanel3.add(jLabelPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jTextFieldQtde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldQtdeActionPerformed(evt);
            }
        });
        jPanel3.add(jTextFieldQtde, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 156, 25));

        jLabelQtde.setText("Porções:");
        jPanel3.add(jLabelQtde, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel9.setText("Ingredientes:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, -1));

        jTextFieldPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPrecoActionPerformed(evt);
            }
        });
        jPanel3.add(jTextFieldPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 156, 25));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 170, 120));

        jButtonAddIngrediente.setText("Add Ingrediente");
        jButtonAddIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddIngredienteActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonAddIngrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        jButtonExcluirIngrediente.setText("-- Ingrediente");
        jButtonExcluirIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirIngredienteActionPerformed(evt);
            }
        });
        jPanel3.add(jButtonExcluirIngrediente, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 450, 230));

        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/zoom.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 130, -1));

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
                .addGap(40, 40, 40)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 490, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Prato getDadosDosCampos() {
        Prato p = new Prato();
        p.setNome(jTextFieldNome.getText());
        p.setPreco(Double.parseDouble(jTextFieldPreco.getText()));
        p.setIngredientes(this.listaComida);
        p.setQuantidadePorcoes(Integer.parseInt(jTextFieldQtde.getText()));
        if(this.prato!=null){
            p.setId(this.prato.getId());
        }

        return p;
    }
    
    private void limpaFormularioTodo() {
        jTextFieldNome.setText("");
        jTextFieldPreco.setText("");
        jTextFieldQtde.setText("");
        this.listaComida=new ArrayList<Comida>();
        preenchetabela();

    }
    
    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jTextFieldQtdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldQtdeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldQtdeActionPerformed

    private void jTextFieldPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPrecoActionPerformed

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
        JDialog dialog = new JDialogViewPrato(null, true, this.getDadosDosCampos());
        dialog.setLocation(getX() + 50, getY() + 50);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jButtonAddIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddIngredienteActionPerformed
        // TODO add your handling code here:
        getIngrediente();
    }//GEN-LAST:event_jButtonAddIngredienteActionPerformed

    private void jButtonExcluirIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirIngredienteActionPerformed
        // TODO add your handling code here:
        deleteIngrediente();
    }//GEN-LAST:event_jButtonExcluirIngredienteActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogCadPratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogCadPratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogCadPratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogCadPratos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogCadPratos dialog = new JDialogCadPratos(new javax.swing.JFrame(), true,null);
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
    private javax.swing.JButton jButtonAddIngrediente;
    private javax.swing.JButton jButtonExcluirIngrediente;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreco;
    private javax.swing.JLabel jLabelQtde;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldQtde;
    // End of variables declaration//GEN-END:variables
}

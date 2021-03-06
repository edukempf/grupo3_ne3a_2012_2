package Controle;

import DAO.BebidaDAO;
import DAO.TransactionManager;
import Modelo.Bebida;
import java.awt.Color;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Juliana
 */
public class JDialogCadBebidas extends javax.swing.JDialog {

    private Bebida bebi;
    private BebidaDAO dao;

    public JDialogCadBebidas(java.awt.Frame parent, boolean modal, Bebida bebida) {
        super(parent, modal);
        initComponents();
        if (bebida != null) {
            jTextFieldNome.setText(bebida.getNome());
            jTextFieldQtde.setText(bebida.getQtde() + "");
            jComboBoxBebida.setSelectedItem(bebida.getTipo());
            jFormattedTextFieldPreco.setText(bebida.getPreco() + "");
            jFormattedTextFieldDataValidade.setText(Utils.Utilitarios.formatDate(bebida.getDataValidade()));
            this.bebi = bebida;

        }
    }

    private void setColorBG() {
        jTextFieldNome.setBackground(Color.white);
        jTextFieldQtde.setBackground(Color.white);
        jComboBoxBebida.setBackground(Color.white);
        jFormattedTextFieldPreco.setBackground(Color.white);
        jFormattedTextFieldDataValidade.setBackground(Color.white);
    }

    private String validaCampos() {
        StringBuilder erros = new StringBuilder("");
        this.setColorBG();
        if (jTextFieldNome.getText() == null || jTextFieldNome.getText().equals("")) {
            erros.append("O campo Nome é Obrigatório!\n");
            jTextFieldNome.setBackground(Color.red);
        }
        if (jTextFieldQtde.getText() == null || jTextFieldQtde.getText().equals("")) {
            erros.append("O campo Quantidade é Obrigatória!\n");
            jTextFieldQtde.setBackground(Color.red);
        } else {
            if (Integer.parseInt(jTextFieldQtde.getText()) < 0) {
                erros.append("O campo Quantidade não pode ser negativa!\n");
                jTextFieldQtde.setBackground(Color.red);
            }
        }
        if (jFormattedTextFieldPreco.getText() == null || jFormattedTextFieldPreco.getText().equals("")) {
            erros.append("O campo Preço é obrigatório!\n");
            jFormattedTextFieldPreco.setBackground(Color.red);
        } else {
            if (Double.parseDouble(jFormattedTextFieldPreco.getText().replace(",", ".")) < 0) {
                erros.append("O campo Preço não pode ser negativo!\n");
                jFormattedTextFieldPreco.setBackground(Color.red);
            }
        }

        if (!(jFormattedTextFieldDataValidade.getText() == null || jFormattedTextFieldDataValidade.getText().replaceAll("/", "").trim().equals(""))) {
            if (new Date().after(new Date(jFormattedTextFieldDataValidade.getText()))) {
                erros.append("Data de Validade informada é inválida!\n");
                jFormattedTextFieldDataValidade.setBackground(Color.red);
            }

        } else {
            erros.append("Data de Validade é obrigatória!\n");
            jFormattedTextFieldDataValidade.setBackground(Color.red);
        }

        return erros.toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jButtonPesquisar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonLimpar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxBebida = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldDataValidade = new javax.swing.JFormattedTextField();
        jFormattedTextFieldPreco = new javax.swing.JFormattedTextField();
        jTextFieldQtde = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Cadastro de Bebidas");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 11, -1, -1));

        jButtonPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/zoom.png"))); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 130, -1));

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
                .addGap(42, 42, 42)
                .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldNome.setMaximumSize(new java.awt.Dimension(100, 100));
        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 387, 25));

        jLabel7.setText("Nome:*");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jLabel8.setText("Quantidade:*");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jComboBoxBebida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Refrigerante", "Suco", "Alcoolica" }));
        jComboBoxBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBebidaActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 58, 153, -1));

        jLabel10.setText("Tipo:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 61, -1, -1));

        jLabel9.setText("Preço:*");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 100, -1, -1));

        jLabel1.setText("Validade:*");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 148, -1, -1));

        try {
            jFormattedTextFieldDataValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(jFormattedTextFieldDataValidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 145, 160, 29));

        jFormattedTextFieldPreco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jPanel1.add(jFormattedTextFieldPreco, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 160, 30));

        jTextFieldQtde.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jPanel1.add(jTextFieldQtde, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 160, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 500, 210));

        jLabel6.setText("* Campo de Preenchimento Obrigatório");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private Bebida getDadosDosCampos() {
        Bebida bebida = new Bebida();
        if (this.bebi != null) {
            bebida = this.bebi;
        }
        bebida.setNome(jTextFieldNome.getText());
        bebida.setQtde(Integer.parseInt(jTextFieldQtde.getText()));
        bebida.setTipo(jComboBoxBebida.getSelectedItem().toString());
        bebida.setPreco(Double.parseDouble(jFormattedTextFieldPreco.getText().replace(",", ".")));
        bebida.setDataValidade(new Date(jFormattedTextFieldDataValidade.getText()));

        return bebida;
    }

    private void limpaFormularioTodo() {
        jTextFieldNome.setText("");
        jTextFieldQtde.setText("");
        jComboBoxBebida.setSelectedIndex(0);
        jFormattedTextFieldPreco.setText("");
        jFormattedTextFieldDataValidade.setText("");
    }

    private Bebida insereBebida(Bebida bebida) {
//        System.out.println(bebida.getId());
        dao = new BebidaDAO();
        try {
            bebida = dao.persisteObjeto(bebida);
            JOptionPane.showMessageDialog(null, "Bebida cadastrada com sucesso");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir bebida!");
            System.out.println(ex.toString());
        }
        System.out.println(bebida.getId());
        return bebida;
    }

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        JDialog dialog = new JDialogConBebidas(null, true, false);
        dialog.setLocation(getX() + 50, getY() + 50);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        this.limpaFormularioTodo();
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        String aux = this.validaCampos();
        if (aux.equals("")) {
            dispose();
            JDialog dialog = new JDialogViewBebida(null, true, insereBebida(getDadosDosCampos()));
            dialog.setLocation(getX() + 50, getY() + 50);
            dialog.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, aux);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jComboBoxBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBebidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxBebidaActionPerformed

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
            java.util.logging.Logger.getLogger(JDialogCadBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogCadBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogCadBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogCadBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogCadBebidas dialog = new JDialogCadBebidas(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox jComboBoxBebida;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataValidade;
    private javax.swing.JFormattedTextField jFormattedTextFieldPreco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JFormattedTextField jTextFieldQtde;
    // End of variables declaration//GEN-END:variables
}

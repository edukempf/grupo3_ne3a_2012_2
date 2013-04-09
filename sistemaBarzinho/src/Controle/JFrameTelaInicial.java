/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import javax.swing.JOptionPane;

/**
 *
 * @author a899321
 */
public class JFrameTelaInicial extends javax.swing.JFrame {

    /**
     * Creates new form JFrameTelaInicial
     */
    public JFrameTelaInicial() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem17 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem16 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem19 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem18 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem20 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Página Principal do Sistema");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/logo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 43, 324, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Seja Bem Vindo ao Sistema para Barzinhos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 15, 307, -1));

        jMenu1.setMnemonic('c');
        jMenu1.setText("Cadastro");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/bebidas.png"))); // NOI18N
        jMenuItem5.setText("Bebidas");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);
        jMenu1.add(jSeparator3);

        jMenuItem17.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/usuario.png"))); // NOI18N
        jMenuItem17.setText("Funcionários");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem17);
        jMenu1.add(jSeparator4);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/comidas.png"))); // NOI18N
        jMenuItem16.setText("Comidas");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem16);
        jMenu1.add(jSeparator5);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/listar.jpg"))); // NOI18N
        jMenuItem9.setText("Pedidos");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);
        jMenu1.add(jSeparator6);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pratos.png"))); // NOI18N
        jMenuItem15.setText("Pratos");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem15);

        jMenuBar1.add(jMenu1);

        jMenu2.setMnemonic('l');
        jMenu2.setText("Consulta");

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/bebidas.png"))); // NOI18N
        jMenuItem8.setText("Bebidas");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);
        jMenu2.add(jSeparator7);

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/usuario.png"))); // NOI18N
        jMenuItem19.setText("Funcionários");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem19);
        jMenu2.add(jSeparator8);
        jMenu2.add(jSeparator9);

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/comidas.png"))); // NOI18N
        jMenuItem18.setText("Comidas");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem18);
        jMenu2.add(jSeparator10);

        jMenuItem20.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/listar.jpg"))); // NOI18N
        jMenuItem20.setText("Pedidos");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem20);
        jMenu2.add(jSeparator11);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/pratos.png"))); // NOI18N
        jMenuItem14.setText("Pratos ");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem14);

        jMenuBar1.add(jMenu2);

        jMenu4.setMnemonic('s');
        jMenu4.setText("Sistema");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/reiniciar.png"))); // NOI18N
        jMenuItem7.setText("Reiniciar persistência");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/conf.png"))); // NOI18N
        jMenuItem6.setText("Configurar persistência");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);
        jMenu4.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/sair.jpg"))); // NOI18N
        jMenuItem2.setText("Sair");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuBar1.add(jMenu4);

        jMenu5.setMnemonic('a');
        jMenu5.setText("Conta");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/calcular.png"))); // NOI18N
        jMenuItem4.setText("Calcular Conta");
        jMenuItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem4MousePressed(evt);
            }
        });
        jMenu5.add(jMenuItem4);
        jMenu5.add(jSeparator12);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/emitirConta.png"))); // NOI18N
        jMenuItem1.setText("Emitir Conta");
        jMenu5.add(jMenuItem1);
        jMenu5.add(jSeparator13);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/mesa.png"))); // NOI18N
        jMenuItem3.setText("Liberar Mesa");
        jMenu5.add(jMenuItem3);

        jMenuBar1.add(jMenu5);

        jMenu6.setMnemonic('a');
        jMenu6.setText("Ajuda");

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/ajuda.png"))); // NOI18N
        jMenuItem10.setText("Sobre");
        jMenuItem10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMenuItem10MousePressed(evt);
            }
        });
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new JDialogCadBebidas(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        new JDialogCadFuncionario(this, true,null).setVisible(true);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        new JDialogCadComidas(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        //new JDialogCadPedidos(this, true).setVisible(true); 
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        //new JDialogCadPratos(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        new JDialogConBebidas(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        new JDialogConFuncionario(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        new JDialogConComidas(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        // new JDialogConPedidos(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
       //new JDialogConPratos(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
                JOptionPane.showConfirmDialog(this, "Tem certeza de que deseja reiniciar\n "
                + "a base de dados do sistema e \n apagar todos os dados armazenados?",
                "Aviso", JOptionPane.OK_CANCEL_OPTION);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
         new JDialogConfiguraBD(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem4MousePressed
       
    }//GEN-LAST:event_jMenuItem4MousePressed

    private void jMenuItem10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem10MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem10MousePressed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
         new JDialogAjuda(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameTelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameTelaInicial().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    // End of variables declaration//GEN-END:variables
}

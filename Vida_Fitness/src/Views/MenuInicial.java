/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

/**
 *
 * @author Debor
 */
public class MenuInicial extends javax.swing.JFrame {

    /**
     * Creates new form MenuInicial
     */
    public MenuInicial() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        gerenciarAlunosButton = new javax.swing.JButton();
        jButtonGerenciarPacote = new javax.swing.JButton();
        jButtonGerenciarModalidades = new javax.swing.JButton();
        jButtonGerenciarCustos = new javax.swing.JButton();
        jButtonInicial = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(27, 25, 30));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gerenciarAlunosButton.setBackground(new java.awt.Color(102, 102, 102));
        gerenciarAlunosButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        gerenciarAlunosButton.setForeground(new java.awt.Color(255, 255, 255));
        gerenciarAlunosButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mulher (1).png"))); // NOI18N
        gerenciarAlunosButton.setText("Gerenciar Alunos");
        gerenciarAlunosButton.setToolTipText("");
        gerenciarAlunosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerenciarAlunosButtonActionPerformed(evt);
            }
        });
        jPanel2.add(gerenciarAlunosButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 250, -1));

        jButtonGerenciarPacote.setBackground(new java.awt.Color(102, 102, 102));
        jButtonGerenciarPacote.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButtonGerenciarPacote.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGerenciarPacote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/caixa.png"))); // NOI18N
        jButtonGerenciarPacote.setText("Gerenciar Pacotes");
        jButtonGerenciarPacote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarPacoteActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonGerenciarPacote, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 250, -1));

        jButtonGerenciarModalidades.setBackground(new java.awt.Color(102, 102, 102));
        jButtonGerenciarModalidades.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButtonGerenciarModalidades.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGerenciarModalidades.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/academia.png"))); // NOI18N
        jButtonGerenciarModalidades.setText("Gerenciar Modalidades");
        jButtonGerenciarModalidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarModalidadesActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonGerenciarModalidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 250, -1));

        jButtonGerenciarCustos.setBackground(new java.awt.Color(102, 102, 102));
        jButtonGerenciarCustos.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButtonGerenciarCustos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGerenciarCustos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dinheiro.png"))); // NOI18N
        jButtonGerenciarCustos.setText("Gerenciar Custos");
        jPanel2.add(jButtonGerenciarCustos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 250, -1));

        jButtonInicial.setBackground(new java.awt.Color(102, 102, 102));
        jButtonInicial.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButtonInicial.setForeground(new java.awt.Color(255, 255, 255));
        jButtonInicial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/casa (1).png"))); // NOI18N
        jButtonInicial.setText("Inicio");
        jButtonInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicialActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 250, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vidafitnes-removebg-preview (1).png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 600));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/academia.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 730, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGerenciarPacoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarPacoteActionPerformed
        MenuPacote menuPacote = new MenuPacote();
        menuPacote.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonGerenciarPacoteActionPerformed

    private void gerenciarAlunosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciarAlunosButtonActionPerformed
        MenuAlunos menuAlunos = new MenuAlunos();
        menuAlunos.setVisible(true);
        dispose();
    }//GEN-LAST:event_gerenciarAlunosButtonActionPerformed

    private void jButtonInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicialActionPerformed
       MenuInicial menuInicial = new MenuInicial();
        menuInicial.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonInicialActionPerformed

    private void jButtonGerenciarModalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarModalidadesActionPerformed
        MenuModalidade menuModalidade = new MenuModalidade();
        menuModalidade.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonGerenciarModalidadesActionPerformed

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
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gerenciarAlunosButton;
    private javax.swing.JButton jButtonGerenciarCustos;
    private javax.swing.JButton jButtonGerenciarModalidades;
    private javax.swing.JButton jButtonGerenciarPacote;
    private javax.swing.JButton jButtonInicial;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

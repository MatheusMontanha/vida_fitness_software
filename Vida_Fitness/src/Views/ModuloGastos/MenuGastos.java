/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.ModuloGastos;

import Views.MenuInicial;
import Views.ModuloModalidade.MenuModalidade;
import Views.ModuloPacote.MenuPacote;
import Views.ModuloAluno.MenuAlunos;

/**
 *
 * @author Debor
 */
public class MenuGastos extends javax.swing.JFrame {

    /**
     * Creates new form MenuGastos
     */
    public MenuGastos() {
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
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMensalidadesDia = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        gerenciarAlunosButton = new javax.swing.JButton();
        jButtonGerenciarPacotes = new javax.swing.JButton();
        jButtonGerenciarModalidades = new javax.swing.JButton();
        jButtonGerenciarCustos = new javax.swing.JButton();
        jButtonInicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mensalidadeDiaFiltro = new javax.swing.JTextField();
        lancarPagamentoButton = new javax.swing.JButton();
        mensalidadeAtrasadasButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(27, 25, 30));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Total recebido no mês até agora:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 520, 290, 20));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/moedas.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 550, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/moedas.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 550, -1, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 550, 110, 40));

        tabelaMensalidadesDia.setFont(new java.awt.Font("Segoe UI Symbol", 0, 12)); // NOI18N
        tabelaMensalidadesDia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Telefone", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaMensalidadesDia);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 700, 330));

        jPanel3.setBackground(new java.awt.Color(27, 25, 30));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pagamentos de ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 210, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dinheiro (1).png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 0));
        jLabel6.setText("Hoje");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 310, 50));

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

        jButtonGerenciarPacotes.setBackground(new java.awt.Color(102, 102, 102));
        jButtonGerenciarPacotes.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButtonGerenciarPacotes.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGerenciarPacotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/caixa.png"))); // NOI18N
        jButtonGerenciarPacotes.setText("Gerenciar Pacotes");
        jButtonGerenciarPacotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGerenciarPacotesActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonGerenciarPacotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 250, -1));

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

        jButtonInicio.setBackground(new java.awt.Color(102, 102, 102));
        jButtonInicio.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButtonInicio.setForeground(new java.awt.Color(255, 255, 255));
        jButtonInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/casa (1).png"))); // NOI18N
        jButtonInicio.setText("Inicio");
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 250, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vidafitnes-removebg-preview (1).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 600));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/procurar.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        mensalidadeDiaFiltro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mensalidadeDiaFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mensalidadeDiaFiltroKeyReleased(evt);
            }
        });
        jPanel1.add(mensalidadeDiaFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 210, -1));

        lancarPagamentoButton.setBackground(new java.awt.Color(0, 149, 0));
        lancarPagamentoButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lancarPagamentoButton.setForeground(new java.awt.Color(255, 255, 255));
        lancarPagamentoButton.setText("Lançar Pagamento");
        jPanel1.add(lancarPagamentoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 150, -1, -1));

        mensalidadeAtrasadasButton.setBackground(new java.awt.Color(0, 153, 255));
        mensalidadeAtrasadasButton.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        mensalidadeAtrasadasButton.setForeground(new java.awt.Color(255, 255, 255));
        mensalidadeAtrasadasButton.setText("Mensalidades Atrasadas");
        jPanel1.add(mensalidadeAtrasadasButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 150, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/businessAcademia.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 730, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gerenciarAlunosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciarAlunosButtonActionPerformed
        MenuAlunos menuAlunos = new MenuAlunos();
        menuAlunos.setVisible(true);
        dispose();
    }//GEN-LAST:event_gerenciarAlunosButtonActionPerformed

    private void jButtonGerenciarPacotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarPacotesActionPerformed
        MenuPacote menuPacote = new MenuPacote();
        menuPacote.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonGerenciarPacotesActionPerformed

    private void jButtonGerenciarModalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarModalidadesActionPerformed
        MenuModalidade menuModalidade = new MenuModalidade();
        menuModalidade.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonGerenciarModalidadesActionPerformed

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        MenuInicial inicial = new MenuInicial();
        inicial.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void mensalidadeDiaFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mensalidadeDiaFiltroKeyReleased
       
    }//GEN-LAST:event_mensalidadeDiaFiltroKeyReleased

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
            java.util.logging.Logger.getLogger(MenuGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuGastos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gerenciarAlunosButton;
    private javax.swing.JButton jButtonGerenciarCustos;
    private javax.swing.JButton jButtonGerenciarModalidades;
    private javax.swing.JButton jButtonGerenciarPacotes;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton lancarPagamentoButton;
    private javax.swing.JButton mensalidadeAtrasadasButton;
    private javax.swing.JTextField mensalidadeDiaFiltro;
    private javax.swing.JTable tabelaMensalidadesDia;
    // End of variables declaration//GEN-END:variables
}

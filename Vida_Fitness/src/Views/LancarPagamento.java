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
public class LancarPagamento extends javax.swing.JFrame {

    /**
     * Creates new form LancarPagamento
     */
    public LancarPagamento() {
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

        voltarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        alunosResultadoMensalidade = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lancarPagamento = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        buscarAluno = new javax.swing.JButton();
        campoPesquisaAluno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        voltarButton.setBackground(new java.awt.Color(11, 133, 176));
        voltarButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        voltarButton.setForeground(new java.awt.Color(255, 255, 255));
        voltarButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/back2.png"))); // NOI18N
        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(voltarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        alunosResultadoMensalidade.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(alunosResultadoMensalidade);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 270, 450, 160));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(27, 25, 30));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pesquisar o Aluno Desejado:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/lupa.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        lancarPagamento.setBackground(new java.awt.Color(0, 149, 0));
        lancarPagamento.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        lancarPagamento.setForeground(new java.awt.Color(255, 255, 255));
        lancarPagamento.setText("Lançar Pagamento");
        lancarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lancarPagamentoActionPerformed(evt);
            }
        });
        jPanel2.add(lancarPagamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 170, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Resultado(s):");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 120, -1));

        buscarAluno.setBackground(new java.awt.Color(0, 153, 204));
        buscarAluno.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        buscarAluno.setForeground(new java.awt.Color(255, 255, 255));
        buscarAluno.setText("Buscar");
        buscarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarAlunoActionPerformed(evt);
            }
        });
        jPanel2.add(buscarAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 90, 30));

        campoPesquisaAluno.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        campoPesquisaAluno.setToolTipText("");
        jPanel2.add(campoPesquisaAluno, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 250, 32));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 550, 430));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mensalidadeAcademia.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        VisualizarFrequencia visualizarFrequencia = new VisualizarFrequencia();
        visualizarFrequencia.setVisible(true);
        dispose();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void lancarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lancarPagamentoActionPerformed
        int indiceSelecionado;
        indiceSelecionado = alunosResultadoMensalidade.getSelectedIndex();
        if (indiceSelecionado >= 0) {
            if (listaDeAlunosResultadoJList.get(indiceSelecionado).toString().contains("Frequência de hoje já lançada")) {
                JOptionPane.showMessageDialog(this, "Ops!! Esse aluno já teve a frequencia lançada hoje.");
            } else {
                Aluno aluno = identificarAluno(cpfAlunoSelecionado(listaDeAlunosResultadoJList.get(indiceSelecionado).toString()));
                try {
                    gerenciamentoFrequencia.lancarFrequenciaAluno(aluno);
                    JOptionPane.showMessageDialog(this, "Aê!! Frequencia lançada com sucesso.");
                    listaDeAlunosResultadoJList = new DefaultListModel();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Ops!! Houve algum erro ao tentar inserir."
                        + "Tente novamente.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ops!! Selecione novamente o aluno.");
        }
    }//GEN-LAST:event_lancarPagamentoActionPerformed

    private void buscarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarAlunoActionPerformed
        if (buscarAluno(campoPesquisaAluno.getText()).size() > 0) {
            listaDeAlunos.clear();
            popularListaDeAlunos();
            listaDeResultado = buscarAluno(campoPesquisaAluno.getText());
            preencherLista(buscarAluno(campoPesquisaAluno.getText()));
        } else {
            JOptionPane.showMessageDialog(this, "Ops!! Nenhum Aluno foi encontrado.");
        }
    }//GEN-LAST:event_buscarAlunoActionPerformed

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
            java.util.logging.Logger.getLogger(LancarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LancarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LancarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LancarPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LancarPagamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> alunosResultadoMensalidade;
    private javax.swing.JButton buscarAluno;
    private javax.swing.JTextField campoPesquisaAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lancarPagamento;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}

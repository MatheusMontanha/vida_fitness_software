/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.GerenciamentoAlunosController;
import Models.Aluno;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Debor
 */
public class MenuAlunos extends javax.swing.JFrame {

    int indiceSelecionado;
    List<Aluno> listaDeAlunos;
    GerenciamentoAlunosController controllerAlunos = new GerenciamentoAlunosController();
    DefaultTableModel dtm;

    public MenuAlunos() {
        initComponents();
        try {
            popularTabela();
        } catch (ParseException e) {
            Logger.getLogger(MenuAlunos.class.getName()).log(Level.SEVERE, null, e);
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

        jPanelPrincipal = new javax.swing.JPanel();
        campoValorFiltro = new javax.swing.JTextField();
        excluirBotao = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        editarBotao = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        gerenciarAlunosButton = new javax.swing.JButton();
        jButtonGerenciarPacotes = new javax.swing.JButton();
        jButtonGerenciarModalidades = new javax.swing.JButton();
        jButtonGerenciarCustos = new javax.swing.JButton();
        jButtonIniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanelCorVerde = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDeAlunos = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoValorFiltro.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        campoValorFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoValorFiltroKeyReleased(evt);
            }
        });
        jPanelPrincipal.add(campoValorFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 210, -1));

        excluirBotao.setBackground(new java.awt.Color(255, 0, 0));
        excluirBotao.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        excluirBotao.setForeground(new java.awt.Color(255, 255, 255));
        excluirBotao.setText("Excluir");
        excluirBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirBotaoActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(excluirBotao, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, -1, 30));

        jButton5.setBackground(new java.awt.Color(0, 149, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Cadastrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, -1, -1));

        editarBotao.setBackground(new java.awt.Color(0, 153, 255));
        editarBotao.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        editarBotao.setForeground(new java.awt.Color(255, 255, 255));
        editarBotao.setText("Editar");
        editarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBotaoActionPerformed(evt);
            }
        });
        jPanelPrincipal.add(editarBotao, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, -1, -1));

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
        jPanel2.add(jButtonGerenciarPacotes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 250, 30));

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
        jPanel2.add(jButtonGerenciarModalidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 250, 30));

        jButtonGerenciarCustos.setBackground(new java.awt.Color(102, 102, 102));
        jButtonGerenciarCustos.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButtonGerenciarCustos.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGerenciarCustos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/dinheiro.png"))); // NOI18N
        jButtonGerenciarCustos.setText("Gerenciar Custos");
        jPanel2.add(jButtonGerenciarCustos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 250, 30));

        jButtonIniciar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonIniciar.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButtonIniciar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/casa (1).png"))); // NOI18N
        jButtonIniciar.setText("Inicio");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 250, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vidafitnes-removebg-preview (1).png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        jPanelPrincipal.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 600));

        jPanelCorVerde.setBackground(new java.awt.Color(0, 153, 51));
        jPanelCorVerde.setRequestFocusEnabled(false);
        jPanelCorVerde.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanelPrincipal.add(jPanelCorVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, -1, -1));

        tabelaDeAlunos.setFont(new java.awt.Font("Segoe UI Symbol", 1, 12)); // NOI18N
        tabelaDeAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Endereço", "Telefone Principal", "Modalidades", "Pacote", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaDeAlunos.setColumnSelectionAllowed(true);
        tabelaDeAlunos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaDeAlunos);

        jPanelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 720, 340));

        jButton6.setBackground(new java.awt.Color(0, 153, 255));
        jButton6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Frequencia");
        jPanelPrincipal.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 540, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/procurar.png"))); // NOI18N
        jPanelPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagemTenisCerta.jpg"))); // NOI18N
        jPanelPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 730, 600));

        getContentPane().add(jPanelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void gerenciarAlunosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerenciarAlunosButtonActionPerformed
        MenuAlunos menuAlunos = new MenuAlunos();
        menuAlunos.setVisible(true);
        dispose();
    }//GEN-LAST:event_gerenciarAlunosButtonActionPerformed

    private void jButtonGerenciarPacotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarPacotesActionPerformed
      MenuPacote menuPacotes = new MenuPacote();
        menuPacotes.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonGerenciarPacotesActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CadastroEdicaoAluno cadastroAluno = new CadastroEdicaoAluno();
        cadastroAluno.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void editarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBotaoActionPerformed
        if (tabelaDeAlunos.getSelectedRow() >= 0) {
            int linhaSelecionada = tabelaDeAlunos.getSelectedRow();
            String nome;
            nome = (String) tabelaDeAlunos.getValueAt(linhaSelecionada, 0);
            Aluno aluno = buscarAlunoNaLista(nome);
            CadastroEdicaoAluno telaCadastro = new CadastroEdicaoAluno(aluno);
            telaCadastro.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum aluno foi selecionado!");
        }
    }//GEN-LAST:event_editarBotaoActionPerformed

    private void excluirBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirBotaoActionPerformed
        if (tabelaDeAlunos.getSelectedRow() >= 0) {
            int linhaSelecionada = tabelaDeAlunos.getSelectedRow();
            String nome;
            nome = (String) tabelaDeAlunos.getValueAt(linhaSelecionada, 0);

            Aluno aluno = buscarAlunoNaLista(nome);
            int resposta = JOptionPane.showConfirmDialog(rootPane,
                    "Tem certeza que deseja excluir o(a) aluno(a) " + aluno.getNome() + "? "
                    + "Essa ação não poderá ser revertida.",
                    "Selecione uma Opção",
                    JOptionPane.YES_NO_OPTION);

            if (resposta != 1 & resposta != 2 & resposta != -1) {
                try {
                    controllerAlunos.deletarCadastroAluno(aluno.getIdAluno());
                    JOptionPane.showMessageDialog(this, "Aluno excluido com sucesso!");
                    popularTabela();
                } catch (SQLException e) {
                    Logger.getLogger(GerenciamentoDeAlunos.class.getName()).log(Level.SEVERE, null, e);
                    JOptionPane.showMessageDialog(this, "Ocorreu um erro ao excluir o aluno."
                            + "Tente novamente!");
                } catch (ParseException ex) {
                    Logger.getLogger(GerenciamentoDeAlunos.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this, "Ocorreu um erro ao converter a data do cadastro."
                            + "Tente novamente!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum aluno foi selecionado!");
        }
    }//GEN-LAST:event_excluirBotaoActionPerformed

    private void campoValorFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoValorFiltroKeyReleased
        String valor = campoValorFiltro.getText();
        filtrar(valor);
    }//GEN-LAST:event_campoValorFiltroKeyReleased

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        MenuInicial menuInicial = new MenuInicial();
        menuInicial.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    private void jButtonGerenciarModalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarModalidadesActionPerformed
        MenuModalidade menuModalidade = new MenuModalidade();
        menuModalidade.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonGerenciarModalidadesActionPerformed

    private Aluno buscarAlunoNaLista(String nome) {
        for (int i = 0; i < listaDeAlunos.size(); i++) {
            if (nome.equalsIgnoreCase(listaDeAlunos.get(i).getNome())) {
                return listaDeAlunos.get(i);
            }
        }
        return null;
    }

    private void popularTabela() throws ParseException {
        dtm = (DefaultTableModel) tabelaDeAlunos.getModel();
        dtm.setNumRows(0);
        listaDeAlunos = controllerAlunos.getListaDeAlunos();
        String modalidades = "";
        String situacao;
        if (listaDeAlunos.size() > 0) {
            for (Aluno aluno : listaDeAlunos) {
                if (aluno.isInadimplente()) {
                    situacao = "Inadimplente";
                } else {
                    situacao = "Regular";
                }
                if (!aluno.getModalidades().isEmpty() & aluno.getModalidades() != null) {
                    for (int i = 0; i < aluno.getModalidades().size(); i++) {
                        modalidades += aluno.getModalidades().get(i).getNome();
                        if (i != aluno.getModalidades().size() - 1) {
                            modalidades += ", ";
                        }
                    }
                    dtm.addRow(new Object[]{
                        aluno.getNome(),
                        aluno.getEndereco(),
                        aluno.getTelefonePrincipal(),
                        modalidades, "",
                        situacao});
                    modalidades = "";
                }
                if (aluno.getPacote() != null) {
                    dtm.addRow(new Object[]{
                        aluno.getNome(),
                        aluno.getEndereco(),
                        aluno.getTelefonePrincipal(),
                        "", aluno.getPacote().getNomePacote(),
                        situacao});
                    modalidades = "";
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Nenhum aluno foi cadastrado!");
        }
    }

    public void filtrar(String valor) {
        try {
            TableRowSorter<DefaultTableModel> resultadoFiltro = new TableRowSorter<>(dtm);
            tabelaDeAlunos.setRowSorter(resultadoFiltro);
            resultadoFiltro.setRowFilter(RowFilter.regexFilter(valor));
        } catch (Exception e) {
            System.out.println("Caractere não aceito.");
        }
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAlunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MenuAlunos().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoValorFiltro;
    private javax.swing.JButton editarBotao;
    private javax.swing.JButton excluirBotao;
    private javax.swing.JButton gerenciarAlunosButton;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonGerenciarCustos;
    private javax.swing.JButton jButtonGerenciarModalidades;
    private javax.swing.JButton jButtonGerenciarPacotes;
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCorVerde;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaDeAlunos;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ModalidadeController;
import Models.Modalidade;
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
public class MenuModalidade extends javax.swing.JFrame {

    int indiceSelecionado;
    List<Modalidade> listaDeModalidades;
    ModalidadeController controllerModalidades = new ModalidadeController();
    DefaultTableModel dtm;

    /**
     * Creates new form MenuModalidade
     */
    public MenuModalidade() {
        initComponents();
        try {
            popularTabelaModalidade();
        } catch (ParseException ex) {
            Logger.getLogger(MenuModalidade.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        gerenciarAlunosButton = new javax.swing.JButton();
        jButtonGerenciarPacotes = new javax.swing.JButton();
        jButtonGerenciarModalidades = new javax.swing.JButton();
        jButtonGerenciarCustos = new javax.swing.JButton();
        jButtonInicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaModalidades = new javax.swing.JTable();
        modalidadeFiltro = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        editarModalidade = new javax.swing.JButton();
        excluirModalidade = new javax.swing.JButton();
        cadastrarModalidade = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
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

        tabelaModalidades.setFont(new java.awt.Font("Segoe UI Semilight", 1, 12)); // NOI18N
        tabelaModalidades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaModalidades);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 550, 330));

        modalidadeFiltro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        modalidadeFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                modalidadeFiltroKeyReleased(evt);
            }
        });
        jPanel1.add(modalidadeFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 210, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/procurar.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, -1, -1));

        editarModalidade.setBackground(new java.awt.Color(0, 153, 255));
        editarModalidade.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        editarModalidade.setForeground(new java.awt.Color(255, 255, 255));
        editarModalidade.setText("Editar");
        editarModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarModalidadeActionPerformed(evt);
            }
        });
        jPanel1.add(editarModalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, -1, -1));

        excluirModalidade.setBackground(new java.awt.Color(255, 0, 0));
        excluirModalidade.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        excluirModalidade.setForeground(new java.awt.Color(255, 255, 255));
        excluirModalidade.setText("Excluir");
        excluirModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirModalidadeActionPerformed(evt);
            }
        });
        jPanel1.add(excluirModalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 140, -1, -1));

        cadastrarModalidade.setBackground(new java.awt.Color(0, 149, 0));
        cadastrarModalidade.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        cadastrarModalidade.setForeground(new java.awt.Color(255, 255, 255));
        cadastrarModalidade.setText("Cadastrar");
        cadastrarModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarModalidadeActionPerformed(evt);
            }
        });
        jPanel1.add(cadastrarModalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, 110, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/imagemTenisCerta.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 730, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 600));

        pack();
        setLocationRelativeTo(null);
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

    private void modalidadeFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modalidadeFiltroKeyReleased
        String nome = modalidadeFiltro.getText();
        filtrar(nome);
    }//GEN-LAST:event_modalidadeFiltroKeyReleased

    private Modalidade buscarModalidadeNaLista(String nome) {
        for (int i = 0; i < listaDeModalidades.size(); i++) {
            if (nome.equalsIgnoreCase(listaDeModalidades.get(i).getNome())) {
                return listaDeModalidades.get(i);
            }
        }
        return null;
    }

    private void excluirModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirModalidadeActionPerformed
        if (tabelaModalidades.getSelectedRow() >= 0) {
            int linhaSelecionada = tabelaModalidades.getSelectedRow();
            String nome;
            nome = (String) tabelaModalidades.getValueAt(linhaSelecionada, 0);

            Modalidade modalidade = buscarModalidadeNaLista(nome);
            int resposta = JOptionPane.showConfirmDialog(rootPane,
                    "Tem certeza que deseja excluir a modalidade " + modalidade.getNome() + "? "
                    + "Essa ação não poderá ser revertida.",
                    "Selecione uma Opção",
                    JOptionPane.YES_NO_OPTION);
            if (resposta != 1 & resposta != 2 & resposta != -1) {
                try {
                    controllerModalidades.deletarCadastroModalidade(modalidade.getIdModalidade());
                    JOptionPane.showMessageDialog(this, "Modalidade excluida com sucesso!");
                    popularTabelaModalidade();
                } catch (SQLException e) {
                    Logger.getLogger(CadastroEdicaoModalidade.class.getName()).log(Level.SEVERE, null, e);
                    JOptionPane.showMessageDialog(this, "Ocorreu um erro ao excluir a modalidade."
                            + "Tente novamente!");
                } catch (ParseException ex) {
                    Logger.getLogger(MenuModalidade.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma modalidade foi selecionada!");
        }


    }//GEN-LAST:event_excluirModalidadeActionPerformed

    private void cadastrarModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarModalidadeActionPerformed
        CadastroEdicaoModalidade cadastroModalidade = new CadastroEdicaoModalidade();
        cadastroModalidade.setVisible(true);
        dispose();
    }//GEN-LAST:event_cadastrarModalidadeActionPerformed

    private void editarModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarModalidadeActionPerformed
        if (tabelaModalidades.getSelectedRow() >= 0) {
            int linhaSelecionada = tabelaModalidades.getSelectedRow();
            String nome;
            nome = (String) tabelaModalidades.getValueAt(linhaSelecionada, 0);
            Modalidade modalidade = buscarModalidadeNaLista(nome);
            CadastroEdicaoModalidade cadastroModalidade = new CadastroEdicaoModalidade(modalidade);
            cadastroModalidade.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Nenhuma modalidade foi selecionada!");
        }

    }//GEN-LAST:event_editarModalidadeActionPerformed

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        MenuInicial inicial = new MenuInicial();
        inicial.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jButtonGerenciarModalidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGerenciarModalidadesActionPerformed
            MenuModalidade menuModalidade = new MenuModalidade();
            menuModalidade.setVisible(true);
            dispose();
    }//GEN-LAST:event_jButtonGerenciarModalidadesActionPerformed

    private void filtrar(String nome) {
        try {
            TableRowSorter<DefaultTableModel> resultadoFiltro = new TableRowSorter<>(dtm);
            tabelaModalidades.setRowSorter(resultadoFiltro);
            resultadoFiltro.setRowFilter(RowFilter.regexFilter(nome));
        } catch (Exception e) {
            System.out.println("Caractere não aceito.");
        }
    }

    private void popularTabelaModalidade() throws ParseException {
        dtm = (DefaultTableModel) tabelaModalidades.getModel();
        dtm.setNumRows(0);
        listaDeModalidades = controllerModalidades.getModalidades();
        System.out.println(listaDeModalidades.size());
        for (Modalidade modalidade : listaDeModalidades) {
            dtm.addRow(new Object[]{
                modalidade.getNome(),
                modalidade.getValorModalidade()
            });
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuModalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuModalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuModalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuModalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuModalidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarModalidade;
    private javax.swing.JButton editarModalidade;
    private javax.swing.JButton excluirModalidade;
    private javax.swing.JButton gerenciarAlunosButton;
    private javax.swing.JButton jButtonGerenciarCustos;
    private javax.swing.JButton jButtonGerenciarModalidades;
    private javax.swing.JButton jButtonGerenciarPacotes;
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField modalidadeFiltro;
    private javax.swing.JTable tabelaModalidades;
    // End of variables declaration//GEN-END:variables

}

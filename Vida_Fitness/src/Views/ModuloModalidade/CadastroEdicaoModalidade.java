/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.ModuloModalidade;

import Controllers.ModalidadeController;
import Models.Modalidade;
import java.awt.Component;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Debor
 */
public class CadastroEdicaoModalidade extends javax.swing.JFrame {

    Modalidade modalidade;
    Modalidade editarModalidade;
    ModalidadeController modalidadeController = new ModalidadeController();
    List<Modalidade> listaDeModalides;
    ModalidadeController controllerModalidade = new ModalidadeController();
    DefaultListModel listaDeItensJlist = new DefaultListModel();
    double valor = 0.0;

    /**
     * Creates new form GerenciamentoModalidade
     */
    public CadastroEdicaoModalidade() {
        initComponents();
        tituloTelaCRUDMod.setText("Cadastrar Modalidade");
    }

    public CadastroEdicaoModalidade(Modalidade modalidade) {
        initComponents();
        this.editarModalidade = modalidade;
        preencherCamposParaEditar(modalidade);
        tituloTelaCRUDMod.setText("    Editar Modalidade");

    }

    private int verificarCampoVazio() {
        Component components[] = jPanelCentral.getComponents();
        int controle = -1;
        for (Component component : components) {
            if (component instanceof JTextField) {
                if (((JTextField) component).getText().isEmpty()) {
                    controle = 0;
                }
            }
        }
        return controle;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCRUDModalidade = new javax.swing.JPanel();
        jPanelCentral = new javax.swing.JPanel();
        tituloTelaCRUDMod = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        campoNomeModalidade = new javax.swing.JTextField();
        campoValorModalidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonCancelarModalidade = new javax.swing.JButton();
        jButtonSalvarModalidade = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCRUDModalidade.setBackground(new java.awt.Color(27, 25, 30));
        jPanelCRUDModalidade.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCentral.setBackground(new java.awt.Color(27, 25, 30));
        jPanelCentral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloTelaCRUDMod.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        tituloTelaCRUDMod.setForeground(new java.awt.Color(255, 255, 255));
        tituloTelaCRUDMod.setText("Cadastrar Modalidade");
        jPanelCentral.add(tituloTelaCRUDMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        jPanelCentral.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 510, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome");
        jPanelCentral.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        campoNomeModalidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        campoNomeModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeModalidadeActionPerformed(evt);
            }
        });
        jPanelCentral.add(campoNomeModalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 290, 30));

        campoValorModalidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        campoValorModalidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoValorModalidadeKeyReleased(evt);
            }
        });
        jPanelCentral.add(campoValorModalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 290, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Valor");
        jPanelCentral.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        jButtonCancelarModalidade.setBackground(new java.awt.Color(255, 51, 51));
        jButtonCancelarModalidade.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonCancelarModalidade.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelarModalidade.setText("Cancelar");
        jButtonCancelarModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarModalidadeActionPerformed(evt);
            }
        });
        jPanelCentral.add(jButtonCancelarModalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 100, 30));

        jButtonSalvarModalidade.setBackground(new java.awt.Color(84, 182, 19));
        jButtonSalvarModalidade.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonSalvarModalidade.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalvarModalidade.setText("Salvar");
        jButtonSalvarModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarModalidadeActionPerformed(evt);
            }
        });
        jPanelCentral.add(jButtonSalvarModalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 100, 30));

        jPanelCRUDModalidade.add(jPanelCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 490, 440));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesosPretos1000.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanelCRUDModalidade.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 590));

        getContentPane().add(jPanelCRUDModalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarModalidadeActionPerformed

        int resposta = JOptionPane.showConfirmDialog(rootPane,
                "Tem certeza que deseja cancelar? ",
                "Selecione uma Opção",
                JOptionPane.YES_NO_OPTION);

        if (resposta != 1 & resposta != 2 & resposta != -1) {
            MenuModalidade menuModalidade = new MenuModalidade();
            menuModalidade.setVisible(true);
            dispose();

        }
    }//GEN-LAST:event_jButtonCancelarModalidadeActionPerformed

    private void jButtonSalvarModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarModalidadeActionPerformed
        List<String> nomesModalidadesCadastradas;
        boolean jaContemModalidade = false;
        if (editarModalidade == null) {
            if (verificarCampoVazio() == -1) {
                modalidade = new Modalidade();
                modalidade.setNome(campoNomeModalidade.getText());
                modalidade.setValorModalidade(Float.parseFloat(campoValorModalidade.getText()));
                try {
                    nomesModalidadesCadastradas = modalidadeController.nomeModalidadesCadastradas();
                    for (int i = 0; i < nomesModalidadesCadastradas.size(); i++) {
                        if (nomesModalidadesCadastradas.get(i).equalsIgnoreCase(campoNomeModalidade.getText())) {
                            jaContemModalidade = true;
                        }
                    }
                    if (!jaContemModalidade) {
                        modalidadeController.salvarCadastroModalidade(modalidade);
                        JOptionPane.showMessageDialog(this, "Modalidade salva com sucesso!");
                        MenuModalidade menuModalidade = new MenuModalidade();
                        menuModalidade.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Essa modalidade já foi cadastrada!");
                    }
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Ops!! Algo deu errado. Tente novamente.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ops!! Algum campo foi deixado em branco.");
            }
        } else {
            if (verificarCampoVazio() == -1) {
                editarModalidade.setNome(campoNomeModalidade.getText());
                editarModalidade.setValorModalidade(Float.parseFloat(campoValorModalidade.getText()));
                System.out.println(editarModalidade.getValorModalidade());

                try {
                    modalidadeController.editarCadastroModalidade(editarModalidade);
                    JOptionPane.showMessageDialog(this, "Edição realizada com sucesso!");
                    MenuModalidade menuModalidade = new MenuModalidade();
                    menuModalidade.setVisible(true);
                    dispose();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Ops!! Algo deu errado. Tente novamente.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ops!! Algum campo foi deixado em branco.");
            }
        }

    }//GEN-LAST:event_jButtonSalvarModalidadeActionPerformed

    private void preencherCamposParaEditar(Modalidade modalidade) {
        campoNomeModalidade.setText(modalidade.getNome());
        campoValorModalidade.setText("" + modalidade.getValorModalidade());
    }

    private void campoNomeModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeModalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeModalidadeActionPerformed

    private void campoValorModalidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoValorModalidadeKeyReleased
        int condicao = verificarFormatoValor(campoValorModalidade.getText());
        if (!campoValorModalidade.getText().isEmpty()
                && !campoValorModalidade.getText().equalsIgnoreCase("0")) {
            switch (condicao) {
                case 0:
                    break;
                case 1:
                    campoValorModalidade.setText(campoValorModalidade.getText().substring(0, campoValorModalidade.getText().length() - 1));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(this, "Ops!! Insira (.) ao invés de (,) por favor.");
                    campoValorModalidade.setText(campoValorModalidade.getText().substring(0, campoValorModalidade.getText().length() - 1));
                    break;
                case 3:
                    JOptionPane.showMessageDialog(this, "Ops!! Valor Inválido.");
                    campoValorModalidade.setText("");
                    break;
                default:
                    break;
            }
        }
    }//GEN-LAST:event_campoValorModalidadeKeyReleased

    private int verificarFormatoValor(String text) {
        char caractere;
        for (int i = 0; i < text.length(); i++) {
            caractere = text.charAt(i);
            if (caractere == '.') {
                if ((text.length() - i) > 3) {
                    return 1;
                }
            } else if (caractere == ',') {
                return 2;
            } else if (!Character.isDigit(caractere)) {
                return 3;
            }
        }
        return 0;
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
            java.util.logging.Logger.getLogger(CadastroEdicaoModalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadastroEdicaoModalidade().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoNomeModalidade;
    private javax.swing.JTextField campoValorModalidade;
    private javax.swing.JButton jButtonCancelarModalidade;
    private javax.swing.JButton jButtonSalvarModalidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelCRUDModalidade;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel tituloTelaCRUDMod;
    // End of variables declaration//GEN-END:variables

}

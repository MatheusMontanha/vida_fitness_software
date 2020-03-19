/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ModalidadeController;
import Models.Modalidade;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Debor
 */
public class GerenciamentoModalidade extends javax.swing.JFrame {

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
    public GerenciamentoModalidade() {
        initComponents();
        tituloTelaCRUDMod.setText("Cadastrar Modalidade");
    }

    public GerenciamentoModalidade(Modalidade modalidade) {
        initComponents();
        this.editarModalidade = modalidade;
        preencherCamposParaEditar(modalidade);
        tituloTelaCRUDMod.setText("    Editar Modalidade");

    }

    private int verificarCampoVazio() {

        Component components[] = jPanelCRUDModalidade.getComponents();
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

//    public class jPanelGradient extends JPanel{
//        @Override
//        protected void paintComponent(Graphics g){
//            Graphics2D g2d = (Graphics2D) g;
//            int width = getWidth();
//            int height = getHeight();
//            
//            Color color1 = new Color(27,25,30);
//            Color color2 = new Color(124, 124, 124);
//            GradientPaint gp = new GradientPaint(0,0,color1,180,height, color2);
//            g2d.setPaint(gp);
//            g2d.fillRect(0,0,width,height);
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelCRUDModalidade = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tituloTelaCRUDMod = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        NomeModalidade = new javax.swing.JTextField();
        ValorModalidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonCancelarModalidade = new javax.swing.JButton();
        jButtonSalvarModalidade = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelCRUDModalidade.setBackground(new java.awt.Color(27, 25, 30));
        jPanelCRUDModalidade.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(27, 25, 30));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloTelaCRUDMod.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        tituloTelaCRUDMod.setForeground(new java.awt.Color(255, 255, 255));
        tituloTelaCRUDMod.setText("Cadastrar Modalidade");
        jPanel1.add(tituloTelaCRUDMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 510, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, -1, -1));

        NomeModalidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        NomeModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomeModalidadeActionPerformed(evt);
            }
        });
        jPanel1.add(NomeModalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 290, 30));

        ValorModalidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        ValorModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValorModalidadeActionPerformed(evt);
            }
        });
        jPanel1.add(ValorModalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 290, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Valor");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        jButtonCancelarModalidade.setBackground(new java.awt.Color(255, 51, 51));
        jButtonCancelarModalidade.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonCancelarModalidade.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelarModalidade.setText("Cancelar");
        jButtonCancelarModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarModalidadeActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCancelarModalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 100, 30));

        jButtonSalvarModalidade.setBackground(new java.awt.Color(84, 182, 19));
        jButtonSalvarModalidade.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonSalvarModalidade.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalvarModalidade.setText("Salvar");
        jButtonSalvarModalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarModalidadeActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalvarModalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 100, 30));

        jPanelCRUDModalidade.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 490, 440));

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
        if (editarModalidade == null) {
            if (verificarCampoVazio() == -1) {
                modalidade = new Modalidade();
                modalidade.setNome(NomeModalidade.getText());
                modalidade.setValorModalidade(Float.parseFloat(ValorModalidade.getText()));

                try {
                    modalidadeController.salvarCadastroModalidade(modalidade);
                    JOptionPane.showMessageDialog(this, "Modalidade salva com sucesso!");
                    MenuModalidade menuModalidade = new MenuModalidade();
                    menuModalidade.setVisible(true);
                    dispose();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Ops!! Algo deu errado. Tente novamente.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ops!! Algum campo foi deixado em branco.");
            }
        } else {
            if (verificarCampoVazio() == -1) {
                editarModalidade.setNome(NomeModalidade.getText());
                editarModalidade.setValorModalidade(Float.parseFloat(ValorModalidade.getText()));
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
        NomeModalidade.setText(modalidade.getNome());
        ValorModalidade.setText("" + modalidade.getValorModalidade());
    }

    private void ValorModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValorModalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ValorModalidadeActionPerformed

    private void NomeModalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomeModalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomeModalidadeActionPerformed

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
            java.util.logging.Logger.getLogger(GerenciamentoModalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoModalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoModalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GerenciamentoModalidade.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciamentoModalidade().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NomeModalidade;
    private javax.swing.JTextField ValorModalidade;
    private javax.swing.JButton jButtonCancelarModalidade;
    private javax.swing.JButton jButtonSalvarModalidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCRUDModalidade;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel tituloTelaCRUDMod;
    // End of variables declaration//GEN-END:variables

}

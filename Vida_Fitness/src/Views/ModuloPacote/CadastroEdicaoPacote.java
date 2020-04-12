/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.ModuloPacote;

import Controllers.GerenciadorPacotesController;
import Controllers.ModalidadeController;
import Models.Modalidade;
import Models.Pacote;
import Views.ModuloPacote.MenuPacote;
import java.awt.Component;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Debor
 */
public class CadastroEdicaoPacote extends javax.swing.JFrame {

    Pacote pacote;
    Pacote editarPacote;
    GerenciadorPacotesController pacoteController = new GerenciadorPacotesController();
    List<Pacote> listaDePacotes;
    DefaultListModel defaultModelJlist = new DefaultListModel();
    ModalidadeController controllerModalidade = new ModalidadeController();
    double valor = 0.0;
    List<Modalidade> listaDeModalides;
    NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(Locale.CANADA);

    /**
     * Creates new form GerenciamentoPacote
     */
    public CadastroEdicaoPacote() {
        initComponents();
        popularOpcoesModalidades();
    }

    public CadastroEdicaoPacote(Pacote pacoteEditar) {
        initComponents();
        popularOpcoesModalidades();
        editarPacote = pacoteEditar;
        preencherCamposParaEditar(pacoteEditar);
        tituloTelaPacote.setText("Editar Pacote");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCentral = new javax.swing.JPanel();
        tituloTelaPacote = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        nomePacote = new javax.swing.JTextField();
        duracaoPacote = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButtonCancelarPacote = new javax.swing.JButton();
        salvarPacoteButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        modalidadesDisponiveis = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        campoValorTotalSemDesconto = new javax.swing.JTextField();
        addModalidadeButton = new javax.swing.JButton();
        removerModalidadeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        modalidadesJList = new javax.swing.JList<>();
        campoValorDesconto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoValorTotalDesconto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        painelCentral.setBackground(new java.awt.Color(27, 25, 30));
        painelCentral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tituloTelaPacote.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        tituloTelaPacote.setForeground(new java.awt.Color(255, 255, 255));
        tituloTelaPacote.setText("Cadastrar Pacote");
        painelCentral.add(tituloTelaPacote, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, -1, -1));
        painelCentral.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 940, 10));

        jLabel2.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nome");
        painelCentral.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, -1, -1));

        nomePacote.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nomePacote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomePacoteActionPerformed(evt);
            }
        });
        painelCentral.add(nomePacote, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 290, 30));

        duracaoPacote.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        duracaoPacote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                duracaoPacoteKeyReleased(evt);
            }
        });
        painelCentral.add(duracaoPacote, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 50, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Modalidades");
        painelCentral.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jButtonCancelarPacote.setBackground(new java.awt.Color(255, 51, 51));
        jButtonCancelarPacote.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonCancelarPacote.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelarPacote.setText("Cancelar");
        jButtonCancelarPacote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarPacoteActionPerformed(evt);
            }
        });
        painelCentral.add(jButtonCancelarPacote, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, 100, 30));

        salvarPacoteButton.setBackground(new java.awt.Color(84, 182, 19));
        salvarPacoteButton.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        salvarPacoteButton.setForeground(new java.awt.Color(255, 255, 255));
        salvarPacoteButton.setText("Salvar");
        salvarPacoteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarPacoteButtonActionPerformed(evt);
            }
        });
        painelCentral.add(salvarPacoteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 430, 100, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Meses");
        painelCentral.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, -1, -1));

        modalidadesDisponiveis.setFont(new java.awt.Font("Segoe UI Symbol", 1, 14)); // NOI18N
        modalidadesDisponiveis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma modalidade" }));
        painelCentral.add(modalidadesDisponiveis, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 220, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Valor total (Sem desconto):");
        painelCentral.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 220, -1));

        campoValorTotalSemDesconto.setEditable(false);
        campoValorTotalSemDesconto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        campoValorTotalSemDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoValorTotalSemDescontoActionPerformed(evt);
            }
        });
        painelCentral.add(campoValorTotalSemDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 120, 30));

        addModalidadeButton.setBackground(new java.awt.Color(0, 153, 255));
        addModalidadeButton.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        addModalidadeButton.setForeground(new java.awt.Color(255, 255, 255));
        addModalidadeButton.setText("Adicionar");
        addModalidadeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addModalidadeButtonActionPerformed(evt);
            }
        });
        painelCentral.add(addModalidadeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        removerModalidadeButton.setBackground(new java.awt.Color(0, 153, 255));
        removerModalidadeButton.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        removerModalidadeButton.setForeground(new java.awt.Color(255, 255, 255));
        removerModalidadeButton.setText("Remover");
        removerModalidadeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerModalidadeButtonActionPerformed(evt);
            }
        });
        painelCentral.add(removerModalidadeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        jScrollPane1.setViewportView(modalidadesJList);

        painelCentral.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 210, 160));

        campoValorDesconto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        campoValorDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoValorDescontoKeyReleased(evt);
            }
        });
        painelCentral.add(campoValorDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 270, 90, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Valor total com Desconto:");
        painelCentral.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, -1, -1));

        campoValorTotalDesconto.setEditable(false);
        campoValorTotalDesconto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        campoValorTotalDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoValorTotalDescontoActionPerformed(evt);
            }
        });
        painelCentral.add(campoValorTotalDesconto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, 130, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Duração");
        painelCentral.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("R$:");
        painelCentral.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 30, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Valor de desconto:");
        painelCentral.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 230, -1, -1));

        getContentPane().add(painelCentral, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 940, 480));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesosPretos1000.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 590));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nomePacoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomePacoteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomePacoteActionPerformed

    private void jButtonCancelarPacoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarPacoteActionPerformed
        int resposta = JOptionPane.showConfirmDialog(rootPane,
                "Tem certeza que deseja cancelar? ",
                "Selecione uma Opção",
                JOptionPane.YES_NO_OPTION);

        if (resposta != 1 & resposta != 2 & resposta != -1) {
            MenuPacote menuPacote = new MenuPacote();
            menuPacote.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jButtonCancelarPacoteActionPerformed

    private void salvarPacoteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarPacoteButtonActionPerformed
        if (editarPacote == null) {
            if (verificarCampoVazio() == -1) {
                pacote = new Pacote();
                pacote.setNomePacote(nomePacote.getText());
                pacote.setDuracao(Integer.parseInt(duracaoPacote.getText()));
                pacote.setValorDesconto(Float.parseFloat(campoValorDesconto.getText()));
                pacote.setListaDeModalidades(identificarListaDeModalidades());
                try {
                    pacoteController.cadastrarPacote(pacote);
                    JOptionPane.showMessageDialog(this, "AÊ!! Pacote cadastrado com sucesso.");
                    MenuPacote pacoteMenu = new MenuPacote();
                    pacoteMenu.setVisible(true);
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Ops!! Algo deu errado. Tente novamente.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ops!! Algum campo foi deixado em branco.");
            }
        } else {
            if (verificarCampoVazio() == -1) {
                editarPacote.setNomePacote(nomePacote.getText());
                editarPacote.setDuracao(Integer.parseInt(duracaoPacote.getText()));
                editarPacote.setValorDesconto(Float.parseFloat(campoValorDesconto.getText()));
                editarPacote.setListaDeModalidades(identificarListaDeModalidades());
                try {
                    pacoteController.editarCadastroPacote(editarPacote);
                    JOptionPane.showMessageDialog(this, "AÊ!! Pacote editado com sucesso.");
                    MenuPacote pacoteMenu = new MenuPacote();
                    pacoteMenu.setVisible(true);
                    dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(this, "Ops!! Algo deu errado. Tente novamente.");
                }
            }
        }

    }//GEN-LAST:event_salvarPacoteButtonActionPerformed

    private void campoValorTotalSemDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoValorTotalSemDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoValorTotalSemDescontoActionPerformed

    private void addModalidadeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addModalidadeButtonActionPerformed
        if (modalidadesDisponiveis.getSelectedIndex() != 0) {
            Modalidade modalidade = identificarModalidadeSelecionada();
            if (!verificarDuplicidadeJList(modalidade.getNome() + ", R$" + modalidade.getValorModalidade())) {
                defaultModelJlist.addElement("" + modalidade.getNome() + ", R$" + modalidade.getValorModalidade());
                modalidadesJList.setModel(defaultModelJlist);
                valor += modalidade.getValorModalidade();
                if (!duracaoPacote.getText().isEmpty()) {
                    campoValorTotalSemDesconto.setText("R" + formatoMoeda.format(valor * Float.parseFloat(duracaoPacote.getText())));
                    campoValorTotalDesconto.setText("R" + formatoMoeda.format(encontrarValorString(campoValorTotalSemDesconto.getText()) - encontrarValorString(campoValorDesconto.getText())));
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ops!! Você já selecionou essa modalidade.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ops!! Selecione uma modalidade válida.");
        }
    }//GEN-LAST:event_addModalidadeButtonActionPerformed

    private void removerModalidadeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerModalidadeButtonActionPerformed
        int indiceModalidade = modalidadesJList.getSelectedIndex();
        double valorParaSubtrair;
        if (modalidadesJList.getModel().getSize() < 1) {
            JOptionPane.showMessageDialog(this, "Ops!! Sua lista está vazia.");
        } else {
            if (indiceModalidade != -1) {
                valorParaSubtrair = encontrarValorString(defaultModelJlist.get(indiceModalidade).toString());
//                System.out.println("Valor da variavel valor: "+valor);
//                System.out.println("Valor que vai ser diminuido: "+valorParaSubtrair);
                valor -= valorParaSubtrair;
                // System.out.println("Valor que vai ser jogado no total sem desconto: " + formatoMoeda.format(valor * Float.parseFloat(duracaoPacote.getText())));
                campoValorTotalSemDesconto.setText("R" + formatoMoeda.format(valor * Float.parseFloat(duracaoPacote.getText())));

//                System.out.println("Valor ai sem desconto: " + encontrarValorString(campoValorTotalSemDesconto.getText()));
//                System.out.println("Valor ai do desconto: "+ encontrarValorString(campoValorDesconto.getText()));
//                formatoMoeda.format(encontrarValorString(campoValorTotalSemDesconto.getText()) - encontrarValorString(campoValorDesconto.getText()));
                campoValorTotalDesconto.setText("R" + formatoMoeda.format(encontrarValorString(campoValorTotalSemDesconto.getText()) - Float.parseFloat(campoValorDesconto.getText())));
                defaultModelJlist.removeElementAt(indiceModalidade);
                modalidadesJList.setModel(defaultModelJlist);
            } else {
                JOptionPane.showMessageDialog(this, "Ops!! Nenhum elemento foi selecionado.");
            }
        }
    }//GEN-LAST:event_removerModalidadeButtonActionPerformed

    private void campoValorTotalDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoValorTotalDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoValorTotalDescontoActionPerformed

    private void duracaoPacoteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_duracaoPacoteKeyReleased
        int duracao;
        double valorTemporario;
        if (!duracaoPacote.getText().isEmpty() && !duracaoPacote.getText().equalsIgnoreCase("0")) {
            duracao = Integer.parseInt(duracaoPacote.getText());
            valorTemporario = valor;
            valorTemporario *= duracao;
            campoValorTotalSemDesconto.setText("R" + formatoMoeda.format(valorTemporario));
            campoValorTotalDesconto.setText("R" + formatoMoeda.format((encontrarValorString(campoValorTotalSemDesconto.getText())
                    - Float.parseFloat(campoValorDesconto.getText()))));
        } else {
            campoValorTotalSemDesconto.setText("R" + formatoMoeda.format(valor));
        }
    }//GEN-LAST:event_duracaoPacoteKeyReleased

    private void campoValorDescontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoValorDescontoKeyReleased
        double valorDesconto;
        double valorTemporario;
        int condicao = verificarFormatoValor(campoValorDesconto.getText());
        if (!campoValorDesconto.getText().isEmpty()
                && !campoValorDesconto.getText().equalsIgnoreCase("0")) {
            switch (condicao) {
                case 0:
                    valorDesconto = Double.parseDouble(campoValorDesconto.getText());
                    valorTemporario = encontrarValorString(campoValorTotalSemDesconto.getText());
                    valorTemporario -= valorDesconto;
                    campoValorTotalDesconto.setText("R" + formatoMoeda.format(valorTemporario));
                    break;
                case 1:
                    campoValorDesconto.setText(campoValorDesconto.getText().substring(0, campoValorDesconto.getText().length() - 1));
                    break;
                case 2:
                    JOptionPane.showMessageDialog(this, "Ops!! Insira (.) ao invés de (,) por favor.");
                    campoValorDesconto.setText(campoValorDesconto.getText().substring(0, campoValorDesconto.getText().length() - 1));
                    break;
                case 3:
                    JOptionPane.showMessageDialog(this, "Ops!! Valor Inválido.");
                    campoValorDesconto.setText("");
                    break;
                default:
                    break;
            }
        } else {
            campoValorTotalDesconto.setText(campoValorTotalSemDesconto.getText());
        }

    }//GEN-LAST:event_campoValorDescontoKeyReleased

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

    private double encontrarValorString(String text) {
        char caractere;
        double valorRecuperado = -1.0;
        for (int i = 0; i < text.length(); i++) {
            caractere = text.charAt(i);
            if (caractere == '$') {
                valorRecuperado = Double.parseDouble(text.substring(i + 1, text.length()));
                return valorRecuperado;
            }
        }
        return valorRecuperado;
    }

    private int verificarCampoVazio() {
        Component components[] = painelCentral.getComponents();
        int controle = -1;
        for (Component component : components) {
            if (component instanceof JTextField) {
                if (((JTextField) component).getText().isEmpty()) {
                    controle = 0;
                }
            }
            if (component instanceof JComboBox) {
                if (((JComboBox) component).getSelectedIndex() < 0) {
                    controle = 0;
                }
            }
        }
        return controle;
    }

    private List<Modalidade> identificarListaDeModalidades() {
        List<Modalidade> modalidadesSelecionadas = new ArrayList<>();
        String nome;
        for (int i = 0; i < modalidadesJList.getModel().getSize(); i++) {
            for (int j = 0; j < listaDeModalides.size(); j++) {
                nome = encontrarNomeString(modalidadesJList.getModel().getElementAt(i));
                if (nome.equalsIgnoreCase(listaDeModalides.get(j).getNome())) {
                    modalidadesSelecionadas.add(listaDeModalides.get(j));
                }
            }
        }
        return modalidadesSelecionadas;
    }

    private void popularOpcoesModalidades() {
        listaDeModalides = controllerModalidade.getModalidades();
        listaDeModalides.forEach((modalidade) -> {
            modalidadesDisponiveis.addItem(modalidade.getNome());
        });
    }

    private String encontrarNomeString(String text) {
        char caractere;
        String nome = "";
        for (int i = 0; i < text.length(); i++) {
            caractere = text.charAt(i);
            if (caractere == ',') {
                nome = text.substring(0, i);
                return nome;
            }
        }
        return nome;
    }

    private Modalidade identificarModalidadeSelecionada() {
        for (int i = 0; i < listaDeModalides.size(); i++) {
            if (listaDeModalides.get(i).getNome().equalsIgnoreCase(modalidadesDisponiveis.getSelectedItem().toString())) {
                return listaDeModalides.get(i);
            }

        }
        return null;
    }

    private boolean verificarDuplicidadeJList(String valor) {
        for (int i = 0; i < modalidadesJList.getModel().getSize(); i++) {
            if (modalidadesJList.getModel().getElementAt(i).equalsIgnoreCase(valor)) {
                return true;
            }
        }
        return false;
    }

    private void preencherCamposParaEditar(Pacote pacoteRecuperado) {
        nomePacote.setText(pacoteRecuperado.getNomePacote());
        duracaoPacote.setText("" + pacoteRecuperado.getDuracao());
        campoValorDesconto.setText("" + pacoteRecuperado.getValorDesconto());
        if (pacoteRecuperado.getListaDeModalidades().size() > 0) {
            for (int i = 0; i < pacoteRecuperado.getListaDeModalidades().size(); i++) {
                String nomeModalidade = pacoteRecuperado.getListaDeModalidades().get(i).getNome();
                float valorModalidade = pacoteRecuperado.getListaDeModalidades().get(i).getValorModalidade();
                float valorTotal = 0;
                defaultModelJlist.addElement("" + nomeModalidade + ", R$" + valorModalidade);
                modalidadesJList.setModel(defaultModelJlist);
                for (Modalidade modalidade : pacoteRecuperado.getListaDeModalidades()) {
                    valorTotal += modalidade.getValorModalidade();
                }
                campoValorTotalSemDesconto.setText("R" + formatoMoeda.format(valorTotal * Float.parseFloat(duracaoPacote.getText())));
                campoValorTotalDesconto.setText("R" + formatoMoeda.format((valorTotal * Float.parseFloat(duracaoPacote.getText())) - pacoteRecuperado.getValorDesconto()));
                valor = valorTotal;
            }
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
            java.util.logging.Logger.getLogger(CadastroEdicaoPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroEdicaoPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroEdicaoPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroEdicaoPacote.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadastroEdicaoPacote().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addModalidadeButton;
    private javax.swing.JTextField campoValorDesconto;
    private javax.swing.JTextField campoValorTotalDesconto;
    private javax.swing.JTextField campoValorTotalSemDesconto;
    private javax.swing.JTextField duracaoPacote;
    private javax.swing.JButton jButtonCancelarPacote;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> modalidadesDisponiveis;
    private javax.swing.JList<String> modalidadesJList;
    private javax.swing.JTextField nomePacote;
    private javax.swing.JPanel painelCentral;
    private javax.swing.JButton removerModalidadeButton;
    private javax.swing.JButton salvarPacoteButton;
    private javax.swing.JLabel tituloTelaPacote;
    // End of variables declaration//GEN-END:variables
}

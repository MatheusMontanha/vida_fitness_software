/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Aluno;
import Models.Frequencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathe
 */
public class AlunoDAO {

    ModalidadeDAO modalidadeDAO = new ModalidadeDAO();
    PacoteDAO pacoteDAO = new PacoteDAO();
    FrequenciaDAO frequenciaDAO = new FrequenciaDAO();
    InscricaoAlunoModalidadeDAO inscricaoModalidadeDAO = new InscricaoAlunoModalidadeDAO();
    InscricaoAlunoPacoteDAO inscricaoPacoteDAO = new InscricaoAlunoPacoteDAO();

    public void salvarAluno(Aluno aluno) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        int idUltimoAluno = -1;
        try {
            stm = conexao.prepareStatement("INSERT INTO Aluno(nome,"
                    + " telefone_principal, telefone_secundario, endereco, CPF,"
                    + "inadimplente, bairro, data_cadastro, forma_pagamento)VALUES(?,?,?,?,?,?,?,?,?)");
            stm.setString(1, aluno.getNome());
            stm.setString(2, aluno.getTelefonePrincipal());
            stm.setString(3, aluno.getTelefoneSecundario());
            stm.setString(4, aluno.getEndereco());
            stm.setString(5, aluno.getCpf());
            stm.setBoolean(6, false);
            stm.setString(7, aluno.getBairro());
            stm.setString(8, dataAgora());
            stm.setString(9, aluno.getFormaDePagamento());
            stm.executeUpdate();
            stm = conexao.prepareStatement("SELECT max(Aluno.id_aluno) from Aluno");
            rs = stm.executeQuery();
            while (rs.next()) {
                idUltimoAluno = rs.getInt("max(Aluno.id_aluno)");
            }
            if (aluno.getModalidades() != null & !aluno.getModalidades().isEmpty()) {
                for (int i = 0; i < aluno.getModalidades().size(); i++) {
                    inscricaoModalidadeDAO.salvarInscricaoModalidade(idUltimoAluno,
                            aluno.getModalidades().get(i).getIdModalidade());
                }
            } else if (aluno.getPacote() != null) {
                inscricaoPacoteDAO.salvarInscricaoPacote(idUltimoAluno, aluno.getPacote().getIdPacote());
            }
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public String dataAgora() {
        Calendar c = Calendar.getInstance();
        Date date = c.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(date);
    }

    private boolean verificarInadimplencia(String dataRecebida, int idAluno) {

        Calendar calendarioAtual = Calendar.getInstance();
        Date dataAgora = calendarioAtual.getTime();

        Calendar calendarioDataCadastrada = Calendar.getInstance();
        DateFormat formataData = DateFormat.getDateInstance();

        Date dataConvertida;
        try {
            if (modalidadeDAO.verificarPrimeiroPagamento(idAluno)) {
                dataConvertida = formataData.parse(dataRecebida);
                if (dataConvertida.before(dataAgora)) {
                    long dias;
                    calendarioDataCadastrada.setTime(dataConvertida);
                    dias = Math.abs(ChronoUnit.DAYS.between(calendarioAtual.toInstant(),
                            calendarioDataCadastrada.toInstant()));
                    return dias > 30;
                }
            } else {
                String dataUltimoPagamento;
                dataUltimoPagamento = modalidadeDAO.buscarDataUltimoPagamento(idAluno);
                dataConvertida = formataData.parse(dataUltimoPagamento);
                calendarioDataCadastrada.setTime(dataConvertida);

                int mesUltimoPagamento = calendarioDataCadastrada.get(Calendar.MONTH);
                int mesAtual = calendarioAtual.get(Calendar.MONTH);
                if ((mesUltimoPagamento - mesAtual) > 1) {
                    return true;
                } else if ((mesUltimoPagamento - mesAtual) == 0) {
                    return false;
                } else {
                    Date dataConvertidaOutra;
                    dataConvertidaOutra = formataData.parse(dataRecebida);
                    calendarioDataCadastrada.setTime(dataConvertidaOutra);
                    int diaDeVencimento = calendarioDataCadastrada.get(Calendar.DAY_OF_MONTH);
                    int diaAtual = calendarioAtual.get(Calendar.DAY_OF_MONTH);
                    if (diaAtual > diaDeVencimento) {
                        return true;
                    }
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public void deletarAluno(int idAluno) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        List idsPagamento;
        try {
            idsPagamento = inscricaoModalidadeDAO.getInscricaoAlunoModalidade(idAluno);
            for (int i = 0; i < idsPagamento.size(); i++) {
                deletarRegistroDePagamento(Integer.parseInt("" + idsPagamento.get(i)));
            }
            frequenciaDAO.excluirFrequenciaAluno(idAluno);
            inscricaoModalidadeDAO.deletarInscricaoModalidade(idAluno);
            inscricaoPacoteDAO.deletarInscricaoPacote(idAluno);
            inscricaoModalidadeDAO.deletarInscricaoModalidade(idAluno);
            frequenciaDAO.excluirFrequenciaAluno(idAluno);
            stm = conexao.prepareStatement("DELETE FROM Aluno WHERE Aluno.id_aluno = " + idAluno);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public void deletarRegistroDePagamento(int idInscricaoModalidade) {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("DELETE FROM "
                    + "Pagamento_Inscricao_Modalidade WHERE "
                    + "Pagamento_Inscricao_Modalidade.id_inscricao_aluno_modalidade = "
                    + idInscricaoModalidade);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public List<Aluno> getAlunos() throws SQLException, ParseException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        String nome, telefonePrincipal, telefoneSecundario, endereco, CPF,
                bairro, cep, formaDePagamento;
        boolean inadimplente;
        Date data;
        DateFormat formatData = DateFormat.getDateInstance();
        List<Aluno> listaDeAlunos = new ArrayList<>();
        List<Frequencia> listaDeFrequencias;
        int idAluno;
        try {
            stm = conexao.prepareStatement("SELECT * FROM Aluno");
            rs = stm.executeQuery();
            while (rs.next()) {
                idAluno = rs.getInt("id_aluno");
                nome = rs.getString("nome");
                telefonePrincipal = rs.getString("telefone_principal");
                telefoneSecundario = rs.getString("telefone_secundario");
                endereco = rs.getString("endereco");
                CPF = rs.getString("CPF");
                inadimplente = rs.getBoolean("inadimplente");
                bairro = rs.getString("bairro");
                cep = rs.getString("cep");
                data = formatData.parse(rs.getString("data_cadastro"));
                formaDePagamento = rs.getString("forma_pagamento");
                if (verificarInadimplencia(rs.getString("data_cadastro"), idAluno)) {
                    inadimplente = true;
                }
                listaDeFrequencias = frequenciaDAO.getFrequenciaAluno(idAluno);
                Aluno aluno = new Aluno(idAluno, nome, telefonePrincipal,
                        telefoneSecundario, endereco, bairro, cep, CPF, data, inadimplente,
                        modalidadeDAO.getModalidadesAluno(idAluno),
                        pacoteDAO.getPacoteCliente(idAluno),
                        listaDeFrequencias, formaDePagamento);
                listaDeAlunos.add(aluno);
            }
            return listaDeAlunos;
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return listaDeAlunos;
    }

    public void editarCadastroDeAluno(Aluno aluno) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("update Aluno set "
                    + "nome = '" + aluno.getNome() + "', "
                    + "telefone_principal = '" + aluno.getTelefonePrincipal() + "', "
                    + "telefone_secundario = '" + aluno.getTelefoneSecundario() + "', "
                    + "endereco = '" + aluno.getEndereco() + "', "
                    + "CPF = '" + aluno.getCpf() + "', "
                    + "bairro = '" + aluno.getBairro() + "', "
                    + "cep = '" + aluno.getCep() + "', "
                    + "forma_pagamento = '" + aluno.getFormaDePagamento()
                    + "' where Aluno.id_aluno = " + aluno.getIdAluno());
            stm.executeUpdate();
            if (aluno.getModalidades() != null) {
                inscricaoModalidadeDAO.deletarInscricaoModalidade(aluno.getIdAluno());
                inscricaoPacoteDAO.deletarInscricaoPacote(aluno.getIdAluno());
                for (int i = 0; i < aluno.getModalidades().size(); i++) {
                    inscricaoModalidadeDAO.salvarInscricaoModalidade(aluno.getIdAluno(),
                            aluno.getModalidades().get(i).getIdModalidade());
                }
            }
            if (aluno.getPacote() != null) {
                inscricaoModalidadeDAO.deletarInscricaoModalidade(aluno.getIdAluno());
                inscricaoPacoteDAO.deletarInscricaoPacote(aluno.getPacote().getIdPacote());
                inscricaoPacoteDAO.salvarInscricaoPacote(aluno.getIdAluno(), aluno.getPacote().getIdPacote());
            }
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }
}

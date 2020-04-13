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
                    + "inadimplente, bairro, cep, data_cadastro, pgmt_cartao_credito)VALUES(?,?,?,?,?,?,?,?,?,?)");
            stm.setString(1, aluno.getNome());
            stm.setString(2, aluno.getTelefonePrincipal());
            stm.setString(3, aluno.getTelefoneSecundario());
            stm.setString(4, aluno.getEndereco());
            stm.setString(5, aluno.getCpf());
            stm.setBoolean(6, false);
            stm.setString(7, aluno.getBairro());
            stm.setString(8, aluno.getCep());
            stm.setString(9, dataAgora());
            stm.setBoolean(10, aluno.isPagamentoComCartao());
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

                return (Math.abs(ChronoUnit.DAYS.between(calendarioDataCadastrada.toInstant(),
                        calendarioAtual.toInstant()))) > 30;
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
            idsPagamento = inscricaoPacoteDAO.getInscricaoAlunoPacote(idAluno);
            for (int i = 0; i < idsPagamento.size(); i++) {
                deletarRegistroDePagamentoPacote(Integer.parseInt("" + idsPagamento.get(i)));
            }
            frequenciaDAO.excluirFrequenciaAluno(idAluno);
            inscricaoModalidadeDAO.deletarInscricaoModalidade(idAluno);
            inscricaoPacoteDAO.deletarInscricaoPacote(idAluno);
            inscricaoModalidadeDAO.deletarInscricaoModalidade(idAluno);
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

    public void deletarRegistroDePagamentoPacote(int idInscricaoPacote) {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("DELETE FROM Pagamento_Inscricao_Pacote"
                    + " WHERE Pagamento_Inscricao_Pacote.id_inscricao_aluno_pacote = "
                    + idInscricaoPacote);
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
                bairro, cep;
        boolean inadimplente, pagouCartaoCredito;
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
                pagouCartaoCredito = rs.getBoolean("pgmt_cartao_credito");
                if (verificarInadimplencia(rs.getString("data_cadastro"), idAluno)) {
                    inadimplente = true;
                }
                listaDeFrequencias = frequenciaDAO.getFrequenciaAluno(idAluno);
                Aluno aluno = new Aluno(idAluno, nome, telefonePrincipal,
                        telefoneSecundario, endereco, bairro, cep, CPF, data, inadimplente,
                        modalidadeDAO.getModalidadesAluno(idAluno),
                        pacoteDAO.getPacoteCliente(idAluno),
                        listaDeFrequencias, pagouCartaoCredito);
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
        List idsPagamento;
        try {
            stm = conexao.prepareStatement("update Aluno set "
                    + "nome = '" + aluno.getNome() + "', "
                    + "telefone_principal = '" + aluno.getTelefonePrincipal() + "', "
                    + "telefone_secundario = '" + aluno.getTelefoneSecundario() + "', "
                    + "endereco = '" + aluno.getEndereco() + "', "
                    + "CPF = '" + aluno.getCpf() + "', "
                    + "bairro = '" + aluno.getBairro() + "', "
                    + "cep = '" + aluno.getCep() + "', "
                    + "pgmt_cartao_credito = " + aluno.isPagamentoComCartao()
                    + " where Aluno.id_aluno = " + aluno.getIdAluno());
            stm.executeUpdate();
            if (aluno.getModalidades() != null) {
                idsPagamento = inscricaoModalidadeDAO.getInscricaoAlunoModalidade(aluno.getIdAluno());
                for (int i = 0; i < idsPagamento.size(); i++) {
                    deletarRegistroDePagamento(Integer.parseInt("" + idsPagamento.get(i)));
                }
                inscricaoModalidadeDAO.deletarInscricaoModalidade(aluno.getIdAluno());
                inscricaoPacoteDAO.deletarInscricaoPacote(aluno.getIdAluno());
                for (int i = 0; i < aluno.getModalidades().size(); i++) {
                    inscricaoModalidadeDAO.salvarInscricaoModalidade(aluno.getIdAluno(),
                            aluno.getModalidades().get(i).getIdModalidade());
                }
            }
            if (aluno.getPacote() != null) {
                idsPagamento = inscricaoPacoteDAO.getInscricaoAlunoPacote(aluno.getIdAluno());
                for (int i = 0; i < idsPagamento.size(); i++) {
                    deletarRegistroDePagamentoPacote(Integer.parseInt("" + idsPagamento.get(i)));
                }
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

    public List<Aluno> mensalidadesModalidadeAluno() throws ParseException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        String nome, telefonePrincipal, telefoneSecundario, endereco, CPF,
                bairro, cep, dataUltimoPagamento;
        boolean inadimplente, pagouCartaoCredito;
        Date data;
        DateFormat formatData = DateFormat.getDateInstance();
        List<Aluno> listaDeAlunos = new ArrayList<>();
        int idAluno;
        try {
            stm = conexao.prepareStatement("SELECT * FROM Aluno "
                    + "INNER JOIN Inscricao_Aluno_Modalidade on "
                    + "Inscricao_Aluno_Modalidade.id_aluno = Aluno.id_aluno "
                    + "INNER JOIN Pagamento_Inscricao_Modalidade on "
                    + "Pagamento_Inscricao_Modalidade.id_inscricao_aluno_modalidade = "
                    + "Inscricao_Aluno_Modalidade.id_inscricao_aluno_modalidade WHERE "
                    + "Aluno.pgmt_cartao_credito = false GROUP BY Aluno.nome");
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
                pagouCartaoCredito = rs.getBoolean("pgmt_cartao_credito");
                dataUltimoPagamento = rs.getString("data_pagamento");
                if (verificarInadimplencia(rs.getString("data_cadastro"), idAluno)) {
                    inadimplente = true;
                }
                Aluno aluno = new Aluno(idAluno, nome, telefonePrincipal,
                        telefoneSecundario, endereco, bairro, cep, CPF,
                        data, inadimplente, pagouCartaoCredito, dataUltimoPagamento, modalidadeDAO.getModalidadesAluno(idAluno),
                        pacoteDAO.getPacoteCliente(idAluno));
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

    public List<Aluno> mensalidadesPacoteAluno() throws ParseException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        String nome, telefonePrincipal, telefoneSecundario, endereco, CPF,
                bairro, cep, dataUltimoPagamento;
        boolean inadimplente, pagouCartaoCredito;
        Date data;
        DateFormat formatData = DateFormat.getDateInstance();
        List<Aluno> listaDeAlunos = new ArrayList<>();
        int idAluno;
        try {
            stm = conexao.prepareStatement("SELECT * FROM Aluno INNER JOIN "
                    + "Inscricao_Aluno_Pacote on Inscricao_Aluno_Pacote.id_aluno = "
                    + "Aluno.id_aluno "
                    + "INNER JOIN Pagamento_Inscricao_Pacote on "
                    + "Pagamento_Inscricao_Pacote.id_inscricao_aluno_pacote = "
                    + "Inscricao_Aluno_Pacote.id_inscricao_aluno_pacote WHERE "
                    + "Aluno.pgmt_cartao_credito = false GROUP BY Aluno.nome");
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
                pagouCartaoCredito = rs.getBoolean("pgmt_cartao_credito");
                dataUltimoPagamento = rs.getString("data_pagamento");
                if (verificarInadimplencia(rs.getString("data_cadastro"), idAluno)) {
                    inadimplente = true;
                }
                Aluno aluno = new Aluno(idAluno, nome, telefonePrincipal,
                        telefoneSecundario, endereco, bairro, cep, CPF,
                        data, inadimplente, pagouCartaoCredito, dataUltimoPagamento, modalidadeDAO.getModalidadesAluno(idAluno),
                        pacoteDAO.getPacoteCliente(idAluno));
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

    public void lancarPagamentoDeModalidade(Aluno aluno) {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        List<Integer> identificadores = modalidadeDAO.identificadorInscricaoModalidadeAluno(aluno.getIdAluno());
        try {
            for (int i = 0; i < identificadores.size(); i++) {
                stm = conexao.prepareStatement("INSERT INTO "
                        + "Pagamento_Inscricao_Modalidade(id_inscricao_aluno_modalidade"
                        + ", data_pagamento)VALUES(?,?)");
                stm.setInt(1, identificadores.get(i));
                stm.setString(2, dataAgora());
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public void lancarPagamentoPacote(Aluno aluno) {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {

            stm = conexao.prepareStatement("INSERT INTO "
                    + "Pagamento_Inscricao_Pacote "
                    + "(id_inscricao_aluno_pacote, data_pagamento)VALUES(?,?)");
            stm.setInt(1, pacoteDAO.identificadorInscricaoPacoteAluno(aluno.getIdAluno()));
            stm.setString(2, dataAgora());
            stm.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public boolean verificarExistenciaCpf(String cpf) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        String cpfRegistrado;
        try {
            stm = conexao.prepareStatement("SELECT Aluno.CPF FROM Aluno;");
            rs = stm.executeQuery();
            while (rs.next()) {
                cpfRegistrado = rs.getString("CPF");
                if (cpf.equalsIgnoreCase(cpfRegistrado)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Modalidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
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
public class ModalidadeDAO {

    float valorModalidade;
    int idModalidade;
    String nome;

    public List<Modalidade> getModalidadesAluno(int idAluno) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        try {
            stm = conexao.prepareStatement("Select Modalidade.id_modalidade, "
                    + "Modalidade.valor_modalidade, Modalidade.nome from Modalidade inner join "
                    + "Inscricao_Aluno_Modalidade on "
                    + "Inscricao_Aluno_Modalidade.id_modalidade = Modalidade.id_modalidade "
                    + "AND Inscricao_Aluno_Modalidade.id_aluno = " + idAluno);
            rs = stm.executeQuery();
            List<Modalidade> listaModalidades = new ArrayList<>();
            while (rs.next()) {
                nome = rs.getString("nome");
                valorModalidade = rs.getFloat("valor_modalidade");
                idModalidade = rs.getInt("id_modalidade");
                Modalidade modalidade = new Modalidade(idModalidade, nome, valorModalidade);
                listaModalidades.add(modalidade);
            }
            return listaModalidades;
        } catch (SQLException e) {
            Logger.getLogger(ModalidadeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return null;
    }

    public List<Modalidade> getModalidades() throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        List<Modalidade> listaModalidades = new ArrayList<>();
        try {
            stm = conexao.prepareStatement("Select * from Modalidade");
            rs = stm.executeQuery();

            while (rs.next()) {
                valorModalidade = rs.getFloat("valor_modalidade");
                idModalidade = rs.getInt("id_modalidade");
                nome = rs.getString("nome");
                Modalidade modalidade = new Modalidade(idModalidade, nome, valorModalidade);
                listaModalidades.add(modalidade);
            }
            return listaModalidades;
        } catch (SQLException e) {
            Logger.getLogger(ModalidadeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return null;

    }

    public void salvarModalidades(Modalidade modalidade) throws SQLException {

        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;

        try {
            stm = conexao.prepareStatement("INSERT INTO Modalidade(valor_modalidade,"
                    + " nome)VALUES(?,?)");
            stm.setFloat(1, modalidade.getValorModalidade());
            stm.setString(2, modalidade.getNome());

            stm.executeUpdate();

        } catch (SQLException e) {
            Logger.getLogger(ModalidadeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }

    }

    public void deletarModalidade(int idModalidade) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("DELETE FROM Modalidade WHERE Modalidade.id_modalidade = " + idModalidade);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ModalidadeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public void editarModalidade(Modalidade modalidade) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("update Modalidade set "
                    + "valor_modalidade = " + modalidade.getValorModalidade() + ", "
                    + "nome = '" + modalidade.getNome() + "' "
                    + "WHERE Modalidade.id_modalidade = " + modalidade.getIdModalidade());
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(ModalidadeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public boolean verificarPrimeiroPagamento(int idAluno) {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        try {
            stm = conexao.prepareStatement("SELECT Aluno.nome from Aluno "
                    + "INNER JOIN Inscricao_Aluno_Modalidade on "
                    + "Inscricao_Aluno_Modalidade.id_aluno = Aluno.id_aluno \n"
                    + "INNER JOIN Pagamento_Inscricao_Modalidade on "
                    + "Pagamento_Inscricao_Modalidade.id_inscricao_aluno_modalidade = "
                    + "Inscricao_Aluno_Modalidade.id_inscricao_aluno_modalidade \n"
                    + "WHERE Aluno.id_aluno = " + idAluno);
            rs = stm.executeQuery();
            while (rs.next()) {
                return false;
            }
            return true;
        } catch (SQLException e) {
            Logger.getLogger(ModalidadeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return false;
    }

    public String buscarDataUltimoPagamento(int idAluno) {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        String data;
        try {
            stm = conexao.prepareStatement("SELECT Pagamento_Inscricao_Modalidade.data_pagamento"
                    + " FROM Pagamento_Inscricao_Modalidade "
                    + "INNER JOIN Inscricao_Aluno_Modalidade ON "
                    + "Inscricao_Aluno_Modalidade.id_inscricao_aluno_modalidade = "
                    + "Pagamento_Inscricao_Modalidade.id_inscricao_aluno_modalidade "
                    + "INNER JOIN Aluno on Aluno.id_aluno = Inscricao_Aluno_Modalidade.id_aluno "
                    + "WHERE Aluno.id_aluno = " + idAluno + " GROUP BY Pagamento_Inscricao_Modalidade.data_pagamento");
            rs = stm.executeQuery();
            while (rs.next()) {
                // return false;
                data = rs.getString("data_pagamento");
                return data;
            }
        } catch (SQLException e) {
            Logger.getLogger(ModalidadeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return "";
    }

    public List<Integer> identificadorInscricaoModalidadeAluno(int idAluno) {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<Integer> indentificadores = new ArrayList<>();
        try {
            stm = conexao.prepareStatement("SELECT Inscricao_Aluno_Modalidade.id_inscricao_aluno_modalidade"
                    + " from Inscricao_Aluno_Modalidade WHERE"
                    + " Inscricao_Aluno_Modalidade.id_aluno = " + idAluno);
            rs = stm.executeQuery();
            while (rs.next()) {
                indentificadores.add(rs.getInt("id_inscricao_aluno_modalidade"));
            }
            return indentificadores;
        } catch (SQLException e) {
            Logger.getLogger(ModalidadeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return indentificadores;
    }

    public List<Integer> identificadorModalidadePorAluno(int idAluno) {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<Integer> indentificadores = new ArrayList<>();
        try {
            stm = conexao.prepareStatement("SELECT Modalidade.id_modalidade from Modalidade INNER JOIN Inscricao_Aluno_Modalidade on "
                    + "Inscricao_Aluno_Modalidade.id_modalidade = Modalidade.id_modalidade WHERE "
                    + "Inscricao_Aluno_Modalidade.id_aluno = " + idAluno);
            rs = stm.executeQuery();
            while (rs.next()) {
                indentificadores.add(rs.getInt("id_modalidade"));
            }
            return indentificadores;
        } catch (SQLException e) {
            Logger.getLogger(ModalidadeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return indentificadores;
    }

    public List<Float> mensalidadesPagaModalidade() {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<Float> mensalidadesPagasModalidades = new ArrayList<>();
        Calendar calendarioAtual = Calendar.getInstance();
        Calendar calendarioDataCadastrada = Calendar.getInstance();
        Date dataRecebida;
        DateFormat formataData = DateFormat.getDateInstance();
        calendarioAtual.get(Calendar.MONTH);
        try {
            stm = conexao.prepareStatement("SELECT Modalidade.valor_modalidade, "
                    + "Pagamento_Inscricao_Modalidade.data_pagamento from Modalidade"
                    + " INNER JOIN Inscricao_Aluno_Modalidade on "
                    + "Inscricao_Aluno_Modalidade.id_modalidade = "
                    + "Modalidade.id_modalidade INNER JOIN Pagamento_Inscricao_Modalidade on "
                    + "Pagamento_Inscricao_Modalidade.id_inscricao_aluno_modalidade = "
                    + "Inscricao_Aluno_Modalidade.id_inscricao_aluno_modalidade");
            rs = stm.executeQuery();
            while (rs.next()) {
                try {
                    dataRecebida = formataData.parse(rs.getString("data_pagamento"));
                    calendarioDataCadastrada.setTime(dataRecebida);
                    if ((calendarioAtual.get(Calendar.MONTH)
                            == calendarioDataCadastrada.get(Calendar.MONTH))
                            && (calendarioAtual.get(Calendar.YEAR)
                            == calendarioDataCadastrada.get(Calendar.YEAR))) {
                        mensalidadesPagasModalidades.add(rs.getFloat("valor_modalidade"));
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(ModalidadeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return mensalidadesPagasModalidades;
        } catch (SQLException e) {
            Logger.getLogger(ModalidadeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return mensalidadesPagasModalidades;
    }

    public boolean verificarDependenciaComPacote(int idModalidade) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        try {
            stm = conexao.prepareStatement("SELECT Modalidade.id_modalidade from Modalidade INNER JOIN Grupo_Modalidade_Pacote on "
                    + "Grupo_Modalidade_Pacote.id_modalidade = Modalidade.id_modalidade WHERE Modalidade.id_modalidade =" + idModalidade);
            rs = stm.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return false;
    }

    public boolean verificarDependenciaComInscricao(int idModalidade) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        try {
            stm = conexao.prepareStatement("SELECT Modalidade.id_modalidade from Modalidade INNER JOIN Inscricao_Aluno_Modalidade on "
                    + "Inscricao_Aluno_Modalidade.id_modalidade = Modalidade.id_modalidade WHERE Modalidade.id_modalidade = " + idModalidade);
            rs = stm.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return false;
    }

    public List<String> nomeModalidasCadastradas() {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        ArrayList<String> listaDeModalidades = new ArrayList<>();
        try {
            stm = conexao.prepareStatement("SELECT Modalidade.nome from Modalidade");
            rs = stm.executeQuery();
            while (rs.next()) {
                listaDeModalidades.add(rs.getString("nome"));
            }
            return listaDeModalidades;
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return listaDeModalidades;
    }
}

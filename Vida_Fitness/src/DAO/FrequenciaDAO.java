/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Aluno;
import java.util.List;
import Models.Frequencia;
import Models.Pacote;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathe
 */
public class FrequenciaDAO {

    DateFormat outputDate = new SimpleDateFormat("dd/MM/yyyy");

    public List<Frequencia> getFrequenciaAluno(int idAluno) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        int idFrequencia;
        Date data;
        List<Frequencia> listaDeFrequencia = new ArrayList<>();
        try {
            stm = conexao.prepareStatement("SELECT Frequencia.id_frequencia,"
                    + " Frequencia.data_frequencia from Frequencia "
                    + "INNER JOIN Historico_Frequencia on "
                    + "Historico_Frequencia.id_frequencia = Frequencia.id_frequencia "
                    + "AND Historico_Frequencia.id_aluno = " + idAluno);
            rs = stm.executeQuery();
            while (rs.next()) {
                idFrequencia = rs.getInt("id_frequencia");

                data = outputDate.parse(rs.getString("data_frequencia"));
                Frequencia frequencia = new Frequencia(idFrequencia, data);
                listaDeFrequencia.add(frequencia);
            }
            return listaDeFrequencia;
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ParseException ex) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return null;
    }

    public void excluirFrequenciaAluno(int idAluno) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("DELETE FROM "
                    + "Historico_Frequencia WHERE "
                    + "Historico_Frequencia.id_aluno = " + idAluno);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public void inserirFrequenciaAluno(Aluno aluno) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        int id;
        int idUltimoCadastro = -1;
        ResultSet rs;
        id = verificarExistenciaDiaFrequencia(new AlunoDAO().dataAgora());
        if (id != -1) {
            inserirFrequenciaNoHistorico(id, aluno.getIdAluno());
            Conexao.fecharConexao(conexao);
        } else {
            stm = conexao.prepareStatement("INSERT INTO Frequencia (data_frequencia)"
                    + "VALUES(?)");
            stm.setString(1, new AlunoDAO().dataAgora());
            stm.executeUpdate();
            stm = conexao.prepareStatement("SELECT max(Frequencia.id_frequencia) from Frequencia");
            rs = stm.executeQuery();
            while (rs.next()) {
                idUltimoCadastro = rs.getInt("max(Frequencia.id_frequencia)");
            }
            inserirFrequenciaNoHistorico(idUltimoCadastro, aluno.getIdAluno());
        }
    }

    private void inserirFrequenciaNoHistorico(int id, int idAluno) {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("INSERT INTO Historico_Frequencia "
                    + "(id_frequencia, id_aluno)VALUES(?,?)");
            stm.setInt(1, id);
            stm.setInt(2, idAluno);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    private int verificarExistenciaDiaFrequencia(String data) {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        int id = -1;
        try {
            stm = conexao.prepareStatement("SELECT Frequencia.id_frequencia"
                    + " FROM Frequencia WHERE data_frequencia = '" + data + "'");
            rs = stm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id_frequencia");
            }
            return id;
        } catch (SQLException e) {
            Logger.getLogger(FrequenciaDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return id;
    }

}

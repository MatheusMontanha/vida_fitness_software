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
import java.util.ArrayList;
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
}

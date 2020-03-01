/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathe
 */
public class InscricaoAlunoModalidadeDAO {

    public void salvarInscricaoModalidade(int idAluno, int idModalidade) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("INSERT INTO Inscricao_Aluno_Modalidade(id_aluno,"
                    + " id_modalidade)VALUES(?,?)");
            stm.setInt(1, idAluno);
            stm.setInt(2, idModalidade);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(InscricaoAlunoModalidadeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public void deletarInscricaoModalidade(int idAluno) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("DELETE FROM "
                    + "Inscricao_Aluno_Modalidade WHERE "
                    + "Inscricao_Aluno_Modalidade.id_aluno = " + idAluno);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(InscricaoAlunoModalidadeDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }
}

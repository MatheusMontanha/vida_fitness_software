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
public class InscricaoAlunoPacoteDAO {

    public void salvarInscricaoPacote(int idAluno, int idPacote) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("INSERT INTO Inscricao_Aluno_Pacote(id_aluno,"
                    + " id_pacote)VALUES(?,?)");
            stm.setInt(1, idAluno);
            stm.setInt(2, idPacote);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(InscricaoAlunoPacoteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public void deletarInscricaoPacote(int idAluno) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("DELETE FROM "
                    + "Inscricao_Aluno_Pacote WHERE "
                    + "Inscricao_Aluno_Pacote.id_aluno = " + idAluno);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(InscricaoAlunoPacoteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
           Conexao.fecharConexao(conexao);
        }
    }
}

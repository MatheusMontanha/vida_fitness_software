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
 * @author Debor
 */
public class GrupoModalidadePacoteDAO {

    public void salvarModalidadePacote(int idPacote, int idModalidade) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("INSERT INTO Grupo_Modalidade_Pacote(id_pacote,"
                    + " id_modalidade)VALUES(?,?)");
            stm.setInt(1, idPacote);
            stm.setInt(2, idModalidade);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(GrupoModalidadePacoteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

    public void deletarModalidadePacote(int idModalidade) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("DELETE FROM "
                    + "Grupo_Modalidade_Pacote WHERE "
                    + "Grupo_Modalidade_Pacote.id_modalidade = " + idModalidade);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(GrupoModalidadePacoteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }

    }

    public void deletarModalidadesPacote(int idPacote) {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement("DELETE FROM "
                    + "Grupo_Modalidade_Pacote WHERE "
                    + "Grupo_Modalidade_Pacote.id_pacote = " + idPacote);
            stm.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(GrupoModalidadePacoteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }

}

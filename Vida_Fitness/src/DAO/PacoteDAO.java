/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Modalidade;
import Models.Pacote;
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
public class PacoteDAO {

    public Pacote getPacoteCliente(int idAluno) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        String nomePacote;
        float valorDesconto;
        int duracao;
        List<Modalidade> listaDeModalidades;
        int idPacote;

        try {
            stm = conexao.prepareStatement("select Pacote.id_pacote, "
                    + "Pacote.duracao_pacote, Pacote.nome_pacote, "
                    + "Pacote.valor_desconto_pacote from Pacote "
                    + "INNER JOIN Inscricao_Aluno_Pacote on "
                    + "Inscricao_Aluno_Pacote.id_pacote = Pacote.id_pacote AND "
                    + "Inscricao_Aluno_Pacote.id_aluno = " + idAluno);
            rs = stm.executeQuery();
            while (rs.next()) {
                idPacote = rs.getInt("id_pacote");
                nomePacote = rs.getString("nome_pacote");
                valorDesconto = rs.getFloat("valor_desconto_pacote");
                duracao = rs.getInt("duracao_pacote");
                listaDeModalidades = getModalidadesPacote(idPacote);
                Pacote pacote = new Pacote(idPacote, nomePacote, valorDesconto, duracao, listaDeModalidades);
                return pacote;
            }
        } catch (SQLException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return null;
    }

    public List<Pacote> getPacotes() throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        float valorModalidade, valorDesconto;
        int idModalidade, idPacote, duracaoPacote;
        String nome, nomePacote;
        List<Modalidade> listaDeModalides = new ArrayList<>();
        List<Pacote> listaDePacotes = new ArrayList<>();
        try {
            stm = conexao.prepareStatement("SELECT * from Pacote "
                    + "INNER JOIN Grupo_Modalidade_Pacote on "
                    + "Grupo_Modalidade_Pacote.id_pacote = Pacote.id_pacote "
                    + "INNER JOIN Modalidade on Modalidade.id_modalidade = Grupo_Modalidade_Pacote.id_modalidade");
            rs = stm.executeQuery();
            Pacote pacote = new Pacote();
            while (rs.next()) {
                idPacote = rs.getInt("id_pacote");
                nomePacote = rs.getString("nome_pacote");
                valorDesconto = rs.getFloat("valor_desconto_pacote");
                duracaoPacote = rs.getInt("duracao_pacote");
                pacote.setIdPacote(idPacote);
                pacote.setDuracao(duracaoPacote);
                pacote.setNomePacote(nomePacote);
                pacote.setValorDesconto(valorDesconto);
                nome = rs.getString("nome");
                valorModalidade = rs.getFloat("valor_modalidade");
                idModalidade = rs.getInt("id_modalidade");
                Modalidade modalidade = new Modalidade(idModalidade, nome, valorModalidade);
                listaDeModalides.add(modalidade);
                pacote.setListaDeModalidades(listaDeModalides);
                listaDePacotes.add(pacote);
            }
            return listaDePacotes;
        } catch (SQLException | NullPointerException e) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return null;
    }

    public List<Modalidade> getModalidadesPacote(int idPacote) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
        ResultSet rs;
        float valorModalidade;
        int idModalidade;
        String nome;
        List<Modalidade> listaDeModalides = new ArrayList<>();
        try {
            stm = conexao.prepareStatement("Select Modalidade.id_modalidade,"
                    + " Modalidade.valor_modalidade, Modalidade.nome from Modalidade "
                    + "INNER JOIN Grupo_Modalidade_Pacote on "
                    + "Grupo_Modalidade_Pacote.id_modalidade = Modalidade.id_modalidade "
                    + "AND Grupo_Modalidade_Pacote.id_pacote = " + idPacote);
            rs = stm.executeQuery();
            while (rs.next()) {
                nome = rs.getString("nome");
                valorModalidade = rs.getFloat("valor_modalidade");
                idModalidade = rs.getInt("id_modalidade");
                Modalidade modalidade = new Modalidade(idModalidade, nome, valorModalidade);
                listaDeModalides.add(modalidade);
            }
            return listaDeModalides;
        } catch (SQLException e) {
            Logger.getLogger(PacoteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
        return null;
    }

    public void salvarPacote(Pacote pacote) throws SQLException {
        Connection conexao = Conexao.realizarConexão();
        PreparedStatement stm;
         ResultSet rs;
        int idUltimoPacote = -1;
        try {
            stm = conexao.prepareStatement("INSERT INTO Pacote(nome_pacote,"
                    + " valor_desconto_pacote, duracao_pacote, VALUES(?,?,?)");
            stm.setString(1, pacote.getNomePacote());
            stm.setFloat(2, pacote.getValorDesconto());
            stm.setInt(3, pacote.getDuracao());
            stm.executeUpdate();
            stm = conexao.prepareStatement("SELECT max(Pacote.id_pacote) from Pacote");
            rs = stm.executeQuery();
            while (rs.next()) {
                idUltimoPacote = rs.getInt("max(Pacote.id_pacote)");
            }
        
          
        } catch (SQLException e) {
            Logger.getLogger(PacoteDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            Conexao.fecharConexao(conexao);
        }
    }
}

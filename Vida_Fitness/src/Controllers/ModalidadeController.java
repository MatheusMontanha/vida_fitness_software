package Controllers;

import DAO.ModalidadeDAO;
import Models.Modalidade;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mathe
 */
public class ModalidadeController {

    ModalidadeDAO modalidadeDAO = new ModalidadeDAO();

    public List<Modalidade> getModalidades() {
        try {
            return modalidadeDAO.getModalidades();
        } catch (SQLException e) {
            Logger.getLogger(ModalidadeController.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void salvarCadastroModalidade(Modalidade modalidade) throws SQLException {
        modalidadeDAO.salvarModalidades(modalidade);
    }

    public void deletarCadastroModalidade(int idModalidade) throws SQLException {
        modalidadeDAO.deletarModalidade(idModalidade);
    }

    public void editarCadastroModalidade(Modalidade modalidade) throws SQLException {
        modalidadeDAO.editarModalidade(modalidade);
    }

    public boolean verificarAlgumaDependencia(int idModalidade) throws SQLException {
        return (modalidadeDAO.verificarDependenciaComPacote(idModalidade) || modalidadeDAO.verificarDependenciaComInscricao(idModalidade));
    }
}

package Controllers;

import DAO.PacoteDAO;
import Models.Pacote;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class GerenciadorPacotesController {

    PacoteDAO pacoteDAO = new PacoteDAO();
    List<Pacote> listaDePacotes = new ArrayList<>();

    public List<Pacote> getListaDePacotes() {
        try {
            return pacoteDAO.getPacotes();
        } catch (SQLException e) {
            Logger.getLogger(GerenciadorPacotesController.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaDePacotes;
    }

    public double calcularValorPacote(Pacote pacote) {
        double valor = 0.0;
        for (int i = 0; i < pacote.getListaDeModalidades().size(); i++) {
            valor += pacote.getListaDeModalidades().get(i).getValorModalidade();
        }
        valor = valor - pacote.getValorDesconto();
        return valor;
    }

}

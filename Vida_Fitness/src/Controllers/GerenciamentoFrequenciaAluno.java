/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.AlunoDAO;
import DAO.FrequenciaDAO;
import Models.Aluno;
import Models.Frequencia;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author mathe
 */
public class GerenciamentoFrequenciaAluno {

    DateFormat outputDate = new SimpleDateFormat("dd/MM/yyyy");
    FrequenciaDAO daoFrequencia = new FrequenciaDAO();
    AlunoDAO alunoDAO = new AlunoDAO();

    public void lancarFrequenciaAluno(Aluno aluno) throws SQLException {
        daoFrequencia.inserirFrequenciaAluno(aluno);
    }

    public boolean verificarLancamentoDeFrequencia(List<Frequencia> listaDeFrequencia) {
        String data;
        for (int i = 0; i < listaDeFrequencia.size(); i++) {
            data = outputDate.format(listaDeFrequencia.get(i).getData());
            if (data.equals(alunoDAO.dataAgora())) {
                return true;
            }
        }
        return false;
    }
}

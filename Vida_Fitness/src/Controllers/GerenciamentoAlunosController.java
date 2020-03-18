/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.AlunoDAO;
import Models.Aluno;
import Models.Frequencia;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.temporal.ChronoUnit;
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
public class GerenciamentoAlunosController {

    AlunoDAO daoAluno = new AlunoDAO();
    List<Aluno> listaDeAlunos;

    public List<Aluno> getListaDeAlunos() throws ParseException {
        try {
            listaDeAlunos = daoAluno.getAlunos();
            return listaDeAlunos;
        } catch (SQLException e) {
            Logger.getLogger(GerenciamentoAlunosController.class.getName()).log(Level.SEVERE, null, e);
        }
        return listaDeAlunos = new ArrayList<>();
    }

    public void salvarCadastroAluno(Aluno aluno) throws SQLException {
        daoAluno.salvarAluno(aluno);
    }

    public void deletarCadastroAluno(int idAluno) throws SQLException {
        daoAluno.deletarAluno(idAluno);
    }

    public void editarCadastroAluno(Aluno aluno) throws SQLException {
        daoAluno.editarCadastroDeAluno(aluno);
    }

    public String verificarFrequenciaAluno(Frequencia frequencia) {
        Calendar dataAtual = Calendar.getInstance();
        Date dataAgora = dataAtual.getTime();
        Calendar dataCadastrada = Calendar.getInstance();;
        //DateFormat formataData = DateFormat.getDateInstance();
        long days;
        if (frequencia.getData().before(dataAgora)) {
            dataCadastrada.setTime(frequencia.getData());
            days = Math.abs(ChronoUnit.DAYS.between(dataAtual.toInstant(), dataCadastrada.toInstant()));
            return "Ultima lançada a " + days + " dias.";
        }
        return "";
    }

}

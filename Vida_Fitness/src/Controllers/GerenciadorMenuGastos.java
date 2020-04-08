/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.AlunoDAO;
import Models.Aluno;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author mathe
 */
public class GerenciadorMenuGastos {

    AlunoDAO daoAluno = new AlunoDAO();

    public List<Aluno> mensalidadesDeHoje() throws ParseException, SQLException {
        if (!daoAluno.mensalidadesModalidadeAluno().isEmpty()) {
            return daoAluno.mensalidadesModalidadeAluno();
        } else if (!daoAluno.mensalidadesPacoteAluno().isEmpty()) {
            return daoAluno.mensalidadesPacoteAluno();
        } else {
            return daoAluno.getAlunos();
        }
    }

    public void lancarPagamentoModalidade(Aluno aluno) {
        daoAluno.lancarPagamentoDeModalidade(aluno);
    }
    
    public void lancarPagamentoPacote(Aluno aluno){
        daoAluno.lancarPagamentoPacote(aluno);
    }
}

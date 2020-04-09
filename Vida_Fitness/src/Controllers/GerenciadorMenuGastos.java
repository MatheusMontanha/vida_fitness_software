/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.AlunoDAO;
import DAO.ModalidadeDAO;
import DAO.PacoteDAO;
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
    ModalidadeDAO daoModalidade = new ModalidadeDAO();
    PacoteDAO daoPacote = new PacoteDAO();

    public List<Aluno> mensalidadesDeHoje() throws ParseException, SQLException {
        //Alterar esta lógica
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

    public void lancarPagamentoPacote(Aluno aluno) {
        daoAluno.lancarPagamentoPacote(aluno);
    }

    public List<Float> modalidadesPagaDesteMes() {
        return daoModalidade.mensalidadesPagaModalidade();
    }

    public List<Float> pacotePagosDesteMes() {
        return daoPacote.mensalidadesPagaPacote();
    }

}

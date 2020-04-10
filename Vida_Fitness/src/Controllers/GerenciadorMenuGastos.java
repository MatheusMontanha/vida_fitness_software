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
import java.util.ArrayList;
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
        List<Aluno> listagemDeTodos = new ArrayList<>();
        List<Aluno> mensalidadesModalidade = daoAluno.mensalidadesModalidadeAluno();
        List<Aluno> mensalidadesPacote = daoAluno.mensalidadesPacoteAluno();
        List<Aluno> alunosSemPagamentoRegistrados = daoAluno.getAlunos();
        if (!mensalidadesModalidade.isEmpty()) {
            mensalidadesModalidade.forEach((mensalidadeModalidade) -> {
                listagemDeTodos.add(mensalidadeModalidade);
            });
        }
        if (!mensalidadesPacote.isEmpty()) {
            mensalidadesPacote.forEach((mensalidadePacote) -> {
                listagemDeTodos.add(mensalidadePacote);
            });
        }
        if (!alunosSemPagamentoRegistrados.isEmpty()) {
            if (mensalidadesModalidade.isEmpty() && mensalidadesPacote.isEmpty()) {
                return alunosSemPagamentoRegistrados;
            } else {
                alunosSemPagamentoRegistrados.forEach((alunosSemPagamentoRegistrado) -> {
                    if (!verificarDuplicidadeAluno(alunosSemPagamentoRegistrado.getCpf(), mensalidadesModalidade)
                            && !verificarDuplicidadeAluno(alunosSemPagamentoRegistrado.getCpf(), mensalidadesPacote)) {
                        listagemDeTodos.add(alunosSemPagamentoRegistrado);
                    }
                });
            }
        }
        return listagemDeTodos;
    }

    private boolean verificarDuplicidadeAluno(String valor, List<Aluno> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCpf().equalsIgnoreCase(valor)) {
                return true;
            }
        }
        return false;
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

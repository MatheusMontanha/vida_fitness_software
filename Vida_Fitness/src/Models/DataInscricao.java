/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.Date;

/**
 *
 * @author mathe
 */
public class DataInscricao {
    private Date data;
    private Aluno aluno;
    private Modalidade modalidade;
    private Pacote pacote;

    public DataInscricao(Date data, Aluno aluno, Modalidade modalidade, Pacote pacote) {
        this.data = data;
        this.aluno = aluno;
        this.modalidade = modalidade;
        this.pacote = pacote;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public void setPacote(Pacote pacote) {
        this.pacote = pacote;
    }
   
}

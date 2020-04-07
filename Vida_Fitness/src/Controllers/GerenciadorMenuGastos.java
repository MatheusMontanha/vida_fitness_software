/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.AlunoDAO;
import Models.Aluno;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author mathe
 */
public class GerenciadorMenuGastos {
    AlunoDAO daoAluno = new AlunoDAO();
    public List<Aluno> mensalidadesDeHoje() throws ParseException{
         return daoAluno.mensalidadesAlunoHoje();
    }
}

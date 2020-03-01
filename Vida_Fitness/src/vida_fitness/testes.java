/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vida_fitness;

import DAO.AlunoDAO;
import Models.Aluno;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mathe
 */
public class testes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Aluno aluno = new Aluno();
        aluno.setModalidades(null);
        if (aluno.getModalidades() == null) {
            System.out.println("Ta nulooo");
        }
//        Calendar dataDeCadastro = Calendar.getInstance();
//        Calendar dataAtual = Calendar.getInstance();
//        DateFormat formataData = DateFormat.getDateInstance();
//
//        String dataRecebida = "03/12/2019";
//        String dataAtualRecebida = "02/01/2020";
//
//        int anoCadastrado;
//        int anoAtual;
//
//        int mesCadastrado;
//        int mesAtual;
//
//        int diaCadastrado;
//        int diaAtual;
//
//        try {
//            Date dataConvertida = formataData.parse(dataRecebida);
//            Date dataAtualRecebidaConvertida = formataData.parse(dataAtualRecebida);
//            dataDeCadastro.setTime(dataConvertida);
//            dataAtual.setTime(dataAtualRecebidaConvertida);
//            if (dataDeCadastro.before(dataAtual)) {
//                anoCadastrado = dataDeCadastro.get(Calendar.YEAR);
//                anoAtual = dataAtual.get(Calendar.YEAR);
//                if (anoCadastrado < anoAtual) {
//                    mesCadastrado = dataDeCadastro.get(Calendar.MONTH);
//                    mesAtual = dataAtual.get(Calendar.MONTH);
//                    if (mesCadastrado >= mesAtual) {
//                        diaCadastrado = dataDeCadastro.get(Calendar.DAY_OF_MONTH);
//                        diaAtual = dataAtual.get(Calendar.DAY_OF_MONTH);
//                        if (diaAtual > diaCadastrado) {
//                            System.out.println("Está inadimplente - Comparando final do ano");
//                        }
//                    }
//                }
//                if (anoCadastrado == anoAtual) {
//                    mesCadastrado = dataDeCadastro.get(Calendar.MONTH);
//                    mesAtual = dataAtual.get(Calendar.MONTH);
//                    if (mesCadastrado < mesAtual) {
//                        diaCadastrado = dataDeCadastro.get(Calendar.DAY_OF_MONTH);
//                        diaAtual = dataAtual.get(Calendar.DAY_OF_MONTH);
//                        if (diaCadastrado < diaAtual) {
//                            System.out.println("Está inadimplente - Comparando durante o ano");
//                        }
//                    }
//                }
//                System.out.println("Situação normal.");
//            }
//        } catch (ParseException e) {
//            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, e);
//        }

    }

}

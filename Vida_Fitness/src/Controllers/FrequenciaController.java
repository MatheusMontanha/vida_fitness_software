/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DAO.FrequenciaDAO;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mathe
 */
public class FrequenciaController {

    FrequenciaDAO frequenciaDAO = new FrequenciaDAO();

    public void verificarFrequencia() {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        DateFormat formataData = DateFormat.getDateInstance();

        try {
            Date data1 = formataData.parse("20/02/2020");

            if (data.compareTo(data1) > 0) {
                System.out.println("Essa " + formataData.format(data) + " é depois dessa " + formataData.format(data1));
            }
        } catch (ParseException e) {

        }
    }

    public void deletarFrequenciaAluno(int idAluno) throws SQLException {
        frequenciaDAO.excluirFrequenciaAluno(idAluno);
    }
}

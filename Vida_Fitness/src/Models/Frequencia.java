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
public class Frequencia {

    private int idFrequencia;
    private Date data;

    public Frequencia(int idFrequencia, Date data) {
        this.idFrequencia = idFrequencia;
        this.data = data;
    }

    public int getIdFrequencia() {
        return idFrequencia;
    }

    public void setIdFrequencia(int idFrequencia) {
        this.idFrequencia = idFrequencia;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}

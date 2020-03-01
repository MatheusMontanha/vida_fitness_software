/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.List;

/**
 *
 * @author mathe
 */
public class EntradaDinheiro {

    List<DataInscricao> listaDeInscritosNoDia;
    private float valorTotal;

    public EntradaDinheiro(List<DataInscricao> listaDeInscritosNoDia, float valorTotal) {
        this.listaDeInscritosNoDia = listaDeInscritosNoDia;
        this.valorTotal = valorTotal;
    }

    public List<DataInscricao> getListaDeInscritosNoDia() {
        return listaDeInscritosNoDia;
    }

    public void setListaDeInscritosNoDia(List<DataInscricao> listaDeInscritosNoDia) {
        this.listaDeInscritosNoDia = listaDeInscritosNoDia;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

}
